package mybatis.generator.domain;

import mybatis.generator.SerialModel;

import java.util.Date;

/**
 * @author unclezhao on 15-11-26.
 */
public class MgTableDO extends SerialModel {

    /**
     * db schema name
     */
    private String tableSchema;
    /**
     * table name
     */
    private String tableName;
    /**
     * create time
     */
    private Date gmtCreate;

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
