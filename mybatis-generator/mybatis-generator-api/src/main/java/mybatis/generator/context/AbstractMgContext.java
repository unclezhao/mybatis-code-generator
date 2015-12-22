package mybatis.generator.context;

import mybatis.generator.enums.GenClassTypeEnum;

/**
 * @author unclezhao on 15-12-2.
 */
public abstract class AbstractMgContext implements MgContext {

    public AbstractMgContext(GenClassTypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    protected final GenClassTypeEnum typeEnum;

    public GenClassTypeEnum getTypeEnum() {
        return typeEnum;
    }

    @Override
    public String getPackageName() {
        return typeEnum.getPackageName();
    }

}
