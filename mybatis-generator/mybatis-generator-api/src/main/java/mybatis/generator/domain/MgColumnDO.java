package mybatis.generator.domain;

import mybatis.generator.SerialModel;

/**
 * Contact first:
 *      1) separator in column name: _
 *      2) primary key column's name: id
 *      3) date type column's name start with: gmt, and:
 *          gmt_create correspond to create time
 *          gmt_modified correspond to modified time
 *          gmt_delete correspond to delete time
 *
 * @author unclezhao on 15-11-26.
 */
public class MgColumnDO extends SerialModel {

    /**
     * db schema name
     */
    private String dbSchema;
    /**
     * table name
     */
    private String tableName;
    /**
     * column name
     */
    private String columnName;
    /**
     * column ordinal position
     */
    private Integer ordinalPosition;
    /**
     * default value of column
     */
    private String columnDefault;
    /**
     * column can be null or not
     */
    private String isNullable;
    /**
     * data type of column
     */
    private String dataType;
    /**
     * column key, e.g.: primary key, unique key ...
     */
    private String columnKey;

    public String getDbSchema() {
        return dbSchema;
    }

    public void setDbSchema(String dbSchema) {
        this.dbSchema = dbSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(Integer ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }
}
