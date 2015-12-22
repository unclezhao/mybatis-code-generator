package mybatis.generator.context;

import mybatis.generator.dto.AbstractMgColumnDTO;
import mybatis.generator.enums.GenClassTypeEnum;
import mybatis.generator.util.BeanToolBox;
import org.apache.commons.lang3.StringUtils;

/**
 * @author unclezhao on 15-12-2.
 */
public class MgSqlMapContext extends AbstractMgContext {

    private static final Integer PROPERTY_LENGTH = 30;

    private final MgDOContext doContext;
    private final MgDaoContext daoContext;

    public MgSqlMapContext(MgDOContext doContext, MgDaoContext daoContext) {
        super(GenClassTypeEnum.SQLMAP);
        this.doContext = doContext;
        this.daoContext = daoContext;
    }

    public MgDOContext getDoContext() {
        return doContext;
    }

    public MgDaoContext getDaoContext() {
        return daoContext;
    }

    @Override
    public String getPackageName() {
        return doContext == null ? null : doContext.getPackageName();
    }

    @Override
    public String getClassName() {
        return doContext == null ? null : doContext.getClassName();
    }

    @Override
    public String getGeneratePath() {
        return typeEnum.getGeneratePath();
    }

    @Override
    public String getFileName() {
        return typeEnum.getFileName(doContext.getTableName());
    }

    public String getTableNameUC() {
        return doContext.getTableName().toUpperCase();
    }

    public String getResultMapName() {
        return BeanToolBox.toResultMapName(doContext.getTableName());
    }

    public Boolean hasPrimaryKey() {
        for(AbstractMgColumnDTO dto : doContext.getColumns()) {
            if(dto.isPrimaryKey()) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public String printSpaces(String fieldName) {
        if(StringUtils.isBlank(fieldName))
            throw new AssertionError();
        int length = PROPERTY_LENGTH - fieldName.length();
        StringBuilder spaces = new StringBuilder();
        for(int i = 0; i < length; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }
}
