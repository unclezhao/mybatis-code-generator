package mybatis.generator.context;

import mybatis.generator.enums.GenClassTypeEnum;

/**
 * @author unclezhao on 15-12-4.
 */
public class MgBaseQueryContext extends AbstractMgContext {

    private static final String TABLE_NAME = "base_query";

    public MgBaseQueryContext() {
        super(GenClassTypeEnum.BASE_QUERY);
    }

    @Override
    public String getClassName() {
        return typeEnum.getClassName(TABLE_NAME);
    }

    @Override
    public String getGeneratePath() {
        return typeEnum.getGeneratePath();
    }

    @Override
    public String getFileName() {
        return typeEnum.getFileName(TABLE_NAME);
    }

    public String getDoPackageName() {
        return GenClassTypeEnum.DO.getPackageName();
    }
}
