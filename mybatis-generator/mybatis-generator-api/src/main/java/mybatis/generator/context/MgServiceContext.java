package mybatis.generator.context;

import mybatis.generator.dto.AbstractMgColumnDTO;
import mybatis.generator.enums.GenClassTypeEnum;
import mybatis.generator.util.BeanToolBox;
import org.apache.commons.lang3.StringUtils;

/**
 * @author unclezhao on 15-12-2.
 */
public class MgServiceContext extends AbstractMgContext {

    private final MgDTOContext dtoContext;

    public MgServiceContext(MgDTOContext dtoContext) {
        super(GenClassTypeEnum.SERVICE);
        this.dtoContext = dtoContext;
    }


    public MgDTOContext getDtoContext() {
        return dtoContext;
    }

    public String getDtoFieldName() {
        if(dtoContext == null || StringUtils.isBlank(dtoContext.getClassName()))
            return null;
        return BeanToolBox.classNameToFieldName(dtoContext.getClassName());
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
        return typeEnum.getFileName(dtoContext.getDoContext().getTableName());
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
