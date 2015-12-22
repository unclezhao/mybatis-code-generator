package mybatis.generator.context;

import mybatis.generator.dto.AbstractMgColumnDTO;
import mybatis.generator.enums.GenClassTypeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author unclezhao on 15-12-1.
 */
public class MgDOContext extends AbstractMgContext {

    public MgDOContext(String tableName) {
        super(GenClassTypeEnum.DO);
        this.tableName = tableName;
    }

    private String tableName;
    private List<? extends AbstractMgColumnDTO> columns;

    public String getTableName() {
        return tableName;
    }

    public List<? extends AbstractMgColumnDTO> getColumns() {
        return columns;
    }

    public void setColumns(List<? extends AbstractMgColumnDTO> columns) {
        this.columns = columns;
    }

    public List<String> getImportTypes() {
        List<String> result = new ArrayList<>();
        for(AbstractMgColumnDTO dto : getColumns()) {
            if(!result.contains(dto.getImportType())) {
                result.add(dto.getImportType());
            }
        }
        return result;
    }

    @Override
    public String getClassName() {
        return typeEnum.getClassName(tableName);
    }

    @Override
    public String getGeneratePath() {
        return typeEnum.getGeneratePath();
    }

    @Override
    public String getFileName() {
        return typeEnum.getFileName(getTableName());
    }
}
