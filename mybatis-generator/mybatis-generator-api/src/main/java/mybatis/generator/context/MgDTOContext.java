package mybatis.generator.context;

import mybatis.generator.enums.GenClassTypeEnum;
import mybatis.generator.util.BeanToolBox;
import org.apache.commons.lang3.StringUtils;

/**
 * @author unclezhao on 15-12-2.
 */
public class MgDTOContext extends AbstractMgContext {

    private final MgDOContext doContext;

    public MgDTOContext(MgDOContext doContext) {
        super(GenClassTypeEnum.DTO);
        this.doContext = doContext;
    }

    public MgDOContext getDoContext() {
        return doContext;
    }

    public String getDoFieldName() {
        if(doContext == null || StringUtils.isBlank(doContext.getClassName()))
            return null;
        return BeanToolBox.classNameToFieldName(doContext.getClassName());
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
}
