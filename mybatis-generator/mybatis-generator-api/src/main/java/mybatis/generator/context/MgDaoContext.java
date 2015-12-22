package mybatis.generator.context;

import mybatis.generator.dto.AbstractMgColumnDTO;
import mybatis.generator.enums.GenClassTypeEnum;

/**
 * @author unclezhao on 15-12-2.
 */
public class MgDaoContext extends AbstractMgContext {

    private final MgDOContext doContext;

    public MgDaoContext(MgDOContext doContext) {
        super(GenClassTypeEnum.DAO);
        this.doContext = doContext;
    }

    public MgDOContext getDoContext() {
        return doContext;
    }

    @Override
    public String getClassName() {
        return typeEnum.getClassName(doContext.getTableName());
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
        for(AbstractMgColumnDTO dto : doContext.getColumns()) {
            if(dto.isPrimaryKey()) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public String getPrimaryKeyJavaType() {
        for(AbstractMgColumnDTO dto : doContext.getColumns()) {
            if(dto.isPrimaryKey()) {
                return dto.getJavaType();
            }
        }
        throw new AssertionError();
    }
}
