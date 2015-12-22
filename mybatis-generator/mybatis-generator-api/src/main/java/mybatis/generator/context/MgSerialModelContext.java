package mybatis.generator.context;

import mybatis.generator.enums.GenClassTypeEnum;

/**
 * @author unclezhao on 15-12-4.
 */
public class MgSerialModelContext extends AbstractMgContext {

    public MgSerialModelContext() {
        super(GenClassTypeEnum.SERIAL_MODEL);
    }

    @Override
    public String getClassName() {
        return "SerialModel";
    }

    @Override
    public String getGeneratePath() {
        return typeEnum.getGeneratePath();
    }

    @Override
    public String getFileName() {
        return typeEnum.getFileName(getClassName());
    }
}
