package mybatis.generator.dto;

import mybatis.generator.SerialModel;
import mybatis.generator.domain.MgColumnDO;
import mybatis.generator.util.BeanToolBox;

/**
 * @author unclezhao on 15-11-26.
 */
public abstract class AbstractMgColumnDTO extends SerialModel {

    private MgColumnDO columnDO;

    public AbstractMgColumnDTO() {
        this(new MgColumnDO());
    }

    public AbstractMgColumnDTO(MgColumnDO columnDO) {
        this.columnDO = columnDO;
    }

    public String getDbSchema() {
        return columnDO.getDbSchema();
    }

    public void setDbSchema(String dbSchema) {
        this.columnDO.setDbSchema(dbSchema);
    }

    public String getTableName() {
        return columnDO.getTableName();
    }

    public void setTableName(String tableName) {
        this.columnDO.setTableName(tableName);
    }

    public String getColumnName() {
        return columnDO.getColumnName();
    }

    public void setColumnName(String columnName) {
        this.columnDO.setColumnName(columnName);
    }

    public Integer getOrdinalPosition() {
        return columnDO.getOrdinalPosition();
    }

    public void setOrdinalPosition(Integer ordinalPosition) {
        this.columnDO.setOrdinalPosition(ordinalPosition);
    }

    public String getColumnDefault() {
        return columnDO.getColumnDefault();
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDO.setColumnDefault(columnDefault);
    }

    public String getIsNullable() {
        return columnDO.getIsNullable();
    }

    public void setIsNullable(String isNullable) {
        this.columnDO.setIsNullable(isNullable);
    }

    public String getDataType() {
        return columnDO.getDataType();
    }

    public void setDataType(String dataType) {
        this.columnDO.setDataType(dataType);
    }

    public String getColumnKey() {
        return columnDO.getColumnKey();
    }

    public void setColumnKey(String columnKey) {
        this.columnDO.setColumnKey(columnKey);
    }

    public String getFieldName() {
        return BeanToolBox.columnNameToFieldName(getColumnName());
    }

//    public String toClassName() {
//        return BeanToolBox.toClassName(getTableName());
//    }

    public String getSetterMethod() {
        return BeanToolBox.toSetter(getColumnName());
    }

    public String getGetterMethod() {
        return BeanToolBox.toGetter(getColumnName());
    }

    public abstract Boolean isPrimaryKey();

    public abstract String getJavaType();

    public abstract String getImportType();

}
