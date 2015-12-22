package mybatis.generator.util;

import org.apache.commons.io.FileUtils;

/**
 * @author unclezhao on 15-11-30.
 */
public enum AppParams {

    INSTANCE;

    private static final class ParamNames {
        public static final String GLOBAL_PREFIX = "mg.global.prefix";
        public static final String DO_SURFFIX = "mg.mybatis.do.surffix";
        public static final String MAPPER_SURFFIX = "mg.mybatis.mapper.surffix";
        public static final String RESULTMAP_PREFIX = "mg.mybatis.resultmap.prefix";
        public static final String SERVICE_SURFFIX = "mg.mybatis.service.surffix";
        public static final String SERVICE_IMPL_SURFFIX = "mg.mybatis.service.impl.surffix";
        public static final String DTO_SURFFIX = "mg.mybatis.dto.surffix";
        public static final String BASE_PACKAGE_NAME = "mg.basepackage.name";
        public static final String DO_PACKAGE_NAME = "mg.package.do.name";
        public static final String DAO_PACKAGE_NAME = "mg.package.dao.name";
        public static final String SERVICE_PACKAGE_NAME = "mg.package.service.name";
        public static final String SERVICE_IMPL_PACKAGE_NAME = "mg.package.service.impl.name";
        public static final String DTO_PACKAGE_NAME = "mg.package.dto.name";
        public static final String SQLMAP_PACKAGE_NAME = "mg.package.sqlmap.name";
        public static final String GENERATE_DIR = "mg.generate.dir";
        public static final String GENERATE_DB_SCHEMA = "mg.generate.db.schema.name";
        public static final String GENERATED_TABLE = "mg.generate.db.table.name";
    }

    public String getGlobalPrefix() {
        return AppProperties.getInstance().getProperty(ParamNames.GLOBAL_PREFIX, "mg");
    }

    public String getDoSurffix() {
        return AppProperties.getInstance().getProperty(ParamNames.DO_SURFFIX, "do");
    }

    public String getMapperSurffix() {
        return AppProperties.getInstance().getProperty(ParamNames.MAPPER_SURFFIX, "dao");
    }

    public String getResultMapPrefix() {
        return AppProperties.getInstance().getProperty(ParamNames.RESULTMAP_PREFIX, "rm");
    }

    public String getServiceSurffix() {
        return AppProperties.getInstance().getProperty(ParamNames.SERVICE_SURFFIX, "service");
    }

    public String getServiceImplSurffix() {
        return AppProperties.getInstance().getProperty(ParamNames.SERVICE_IMPL_SURFFIX, "serviceImpl");
    }

    public String getDtoSurffix() {
        return AppProperties.getInstance().getProperty(ParamNames.DTO_SURFFIX, "dto");
    }

    public String getBasePackageName() {
        return AppProperties.getInstance().getProperty(ParamNames.BASE_PACKAGE_NAME, "");
    }

    public String getDoPackageName() {
        return AppProperties.getInstance().getProperty(ParamNames.DO_PACKAGE_NAME, "domain");
    }

    public String getDaoPackageName() {
        return AppProperties.getInstance().getProperty(ParamNames.DAO_PACKAGE_NAME, "dao");
    }

    public String getServicePackageName() {
        return AppProperties.getInstance().getProperty(ParamNames.SERVICE_PACKAGE_NAME, "service");
    }

    public String getServiceImplPackageName() {
        return AppProperties.getInstance().getProperty(ParamNames.SERVICE_IMPL_PACKAGE_NAME, "service.impl");
    }

    public String getDtoPackageName() {
        return AppProperties.getInstance().getProperty(ParamNames.DTO_PACKAGE_NAME, "dto");
    }

    public String getSqlMapPackageName() {
        return AppProperties.getInstance().getProperty(ParamNames.SQLMAP_PACKAGE_NAME, "mybatis");
    }

    public String getQueryPackageName() {
        return "query";
    }

    public String getGenerateDir() {
        return AppProperties.getInstance().getProperty(ParamNames.GENERATE_DIR, FileUtils.getUserDirectoryPath());
    }

    public String getGenerateDbSchema() {
        return AppProperties.getInstance().getProperty(ParamNames.GENERATE_DB_SCHEMA, null);
    }

    public String getGenerateTable() {
        return AppProperties.getInstance().getProperty(ParamNames.SQLMAP_PACKAGE_NAME, null);
    }

    public static void main(String[] args) {
        System.out.println(INSTANCE.getBasePackageName());
        System.out.println(INSTANCE.getDaoPackageName());
    }
}
