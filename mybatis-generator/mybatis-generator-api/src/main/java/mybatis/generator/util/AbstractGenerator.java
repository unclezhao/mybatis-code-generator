package mybatis.generator.util;

import mybatis.generator.context.*;
import mybatis.generator.dao.MgColumnDao;
import mybatis.generator.dao.MgTableDao;
import mybatis.generator.dao.query.MgColumnQuery;
import mybatis.generator.dao.query.MgTableQuery;
import mybatis.generator.domain.MgColumnDO;
import mybatis.generator.domain.MgTableDO;
import mybatis.generator.dto.AbstractMgColumnDTO;
import mybatis.generator.dto.MgTableDTO;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author unclezhao on 15-12-3.
 */
public abstract class AbstractGenerator<T extends AbstractMgColumnDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractGenerator.class);
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void generating(String dbSchema) {
        generating(dbSchema, null);
    }

    public void generating(String dbSchema, String tableName) {
        SqlSession session = null;
        try {
            SqlSessionFactory factory = new MybatisUtil().getSessionFactory();
            session = factory.openSession();
            LOGGER.info("start generating...");
            if (StringUtils.isBlank(tableName)) {
                generateBySchema(session, dbSchema);
            } else {
                generateByTable(session, dbSchema, tableName);
            }
            generateCommons();
            LOGGER.info("generate complete");
        } catch (Exception e) {
            LOGGER.error("generating exception: ", e);
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public void generateBySchema(SqlSession session, String dbSchema) {
        MgTableDao tableDao = session.getMapper(MgTableDao.class);
        MgTableQuery tableQuery = new MgTableQuery();
        tableQuery.setTableSchema(dbSchema);
        List<MgTableDTO> tableDTOList = new ArrayList<>();
        List<MgTableDO> tableDOs = tableDao.query(tableQuery);
        for(MgTableDO temp : tableDOs) {
            tableDTOList.add(new MgTableDTO(temp));
        }
        for(MgTableDTO dto : tableDTOList) {
            generateByTable(session, dbSchema, dto.getTableName());
        }
    }

    public void generateByTable(SqlSession session, String dbSchema, String tableName) {
        MgColumnDao columnDao = session.getMapper(MgColumnDao.class);
        MgColumnQuery query = new MgColumnQuery();
        query.setDbSchema(dbSchema);
        query.setTableName(tableName);
        List<MgColumnDO> columnDOs = columnDao.query(query);
        MgDOContext doContext = new MgDOContext(tableName);
        doContext.setColumns(fromDOList(columnDOs));
        LOGGER.debug("start generating do ...");
        generateFromTemplate(doContext);
        LOGGER.debug("do generated complete");
        MgDTOContext dtoContext = new MgDTOContext(doContext);
        LOGGER.debug("start generating dto ...");
        generateFromTemplate(dtoContext);
        LOGGER.debug("dto generated complete");
        MgDaoContext daoContext = new MgDaoContext(doContext);
        LOGGER.debug("start generating dao ...");
        generateFromTemplate(daoContext);
        LOGGER.debug("dao generated complete");
        MgSqlMapContext sqlMapContext = new MgSqlMapContext(doContext, daoContext);
        LOGGER.debug("start generating sql map ...");
        generateFromTemplate(sqlMapContext);
        LOGGER.debug("sql map generated complete");
        MgServiceContext serviceContext = new MgServiceContext(dtoContext);
        LOGGER.debug("start generating service ...");
        generateFromTemplate(serviceContext);
        LOGGER.debug("service generated complete");
        MgServiceImplContext serviceImplContext = new MgServiceImplContext(doContext, dtoContext, daoContext, serviceContext);
        LOGGER.debug("start generating service impl ...");
        generateFromTemplate(serviceImplContext);
        LOGGER.debug("service impl generated complete");
    }

    public abstract List<T> fromDOList(List<MgColumnDO> list);

    public void generateCommons() {
        MgSerialModelContext serialModelContext = new MgSerialModelContext();
        LOGGER.debug("start generating serial model ...");
        generateFromTemplate(serialModelContext);
        LOGGER.debug("serial model generated complete");
        MgBaseQueryContext queryContext = new MgBaseQueryContext();
        LOGGER.debug("start generating base query ...");
        generateFromTemplate(queryContext);
        LOGGER.debug("base query generated complete");
    }

    private String getFullFilePath(MgContext context) {
        String targetDirPath = AppParams.INSTANCE.getGenerateDir().endsWith("/")
                ? AppParams.INSTANCE.getGenerateDir()
                : AppParams.INSTANCE.getGenerateDir() + "/";
        StringBuilder fullFilePath = new StringBuilder();
        fullFilePath.append(targetDirPath).append(context.getGeneratePath()).append("/")
                .append(context.getFileName());
        return fullFilePath.toString();
    }

    public void generateFromTemplate(AbstractMgContext context) {
        VelocityEngine engine = new VelocityEngine();
        engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        engine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        engine.setProperty(Velocity.ENCODING_DEFAULT, DEFAULT_CHARSET);
        engine.setProperty(Velocity.INPUT_ENCODING, DEFAULT_CHARSET);
        engine.setProperty(Velocity.OUTPUT_ENCODING, DEFAULT_CHARSET);
        engine.init();
        Template template = engine.getTemplate("templates/" + context.getTypeEnum().getTemplateName());
        VelocityContext ctx = new VelocityContext();
        ctx.put("context", context);
        ctx.put("gmtCreate", dateFormater.format(new Date()));
        String filePath = getFullFilePath(context);
        File file = new File(filePath);
        if(!file.getParentFile().exists()) {
            Boolean mkParentFileSucc = file.getParentFile().mkdirs();
            if(!mkParentFileSucc) {
                LOGGER.error("make parent file fail, path: {}", filePath);
                System.exit(1);
            }
        } else if(file.exists()) {
            Boolean deleteSucc = file.delete();
            if(!deleteSucc) {
                LOGGER.error("delete exist file fail, path: {}", filePath);
                System.exit(2);
            }
        }
        FileOutputStream fos = null;
        BufferedWriter writer = null;
        try {
            fos = new FileOutputStream(file);
            writer = new BufferedWriter(new OutputStreamWriter(fos, DEFAULT_CHARSET));
            template.merge(ctx, writer);
            writer.flush();
        } catch (Exception e) {
            LOGGER.error("exception when write file", e);
            throw new RuntimeException(e);
        } finally {
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {}
            }
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {}
            }
        }
    }
}
