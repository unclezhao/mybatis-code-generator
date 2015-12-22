package mybatis.generator.context;

import mybatis.generator.dto.AbstractMgColumnDTO;
import mybatis.generator.enums.GenClassTypeEnum;
import mybatis.generator.util.BeanToolBox;
import org.apache.commons.lang3.StringUtils;

/**
 * @author unclezhao on 15-12-2.
 */
public class MgServiceImplContext extends AbstractMgContext {

    private final MgDOContext doContext;
    private final MgDTOContext dtoContext;
    private final MgDaoContext daoContext;
    private final MgServiceContext serviceContext;

    public MgServiceImplContext(MgDOContext doContext, MgDTOContext dtoContext,
                                MgDaoContext daoContext, MgServiceContext serviceContext) {
        super(GenClassTypeEnum.SERVICE_IMPL);
        this.doContext = doContext;
        this.dtoContext = dtoContext;
        this.daoContext = daoContext;
        this.serviceContext = serviceContext;
    }

    public MgDOContext getDoContext() {
        return doContext;
    }

    public MgDTOContext getDtoContext() {
        return dtoContext;
    }

    public MgDaoContext getDaoContext() {
        return daoContext;
    }

    public MgServiceContext getServiceContext() {
        return serviceContext;
    }

    public String getDoFieldName() {
        if(doContext == null || StringUtils.isBlank(doContext.getClassName()))
            return null;
        return BeanToolBox.classNameToFieldName(doContext.getClassName());
    }

    public String getDtoFieldName() {
        if(dtoContext == null || StringUtils.isBlank(dtoContext.getClassName()))
            return null;
        return BeanToolBox.classNameToFieldName(dtoContext.getClassName());
    }

    public String getDaoFieldName() {
        if(daoContext == null || StringUtils.isBlank(daoContext.getClassName()))
            return null;
        return BeanToolBox.classNameToFieldName(daoContext.getClassName());
    }

    @Override
    public String getClassName() {
        return typeEnum.getClassName(dtoContext.getDoContext().getTableName());
    }

    @Override
    public String getGeneratePath() {
        return typeEnum.getGeneratePath();
    }

    @Override
    public String getFileName() {
        return typeEnum.getFileName(doContext.getTableName());
    }

    public Boolean hasPrimaryKey() {
        for(AbstractMgColumnDTO dto : dtoContext.getDoContext().getColumns()) {
            if(dto.isPrimaryKey()) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public String getPrimaryKeyJavaType() {
        for(AbstractMgColumnDTO dto : dtoContext.getDoContext().getColumns()) {
            if(dto.isPrimaryKey()) {
                return dto.getJavaType();
            }
        }
        throw new AssertionError();
    }
}
