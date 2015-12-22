package mybatis.generator.dao.query;

/**
 * @author unclezhao on 15-11-26.
 */
public class MgTableQuery extends MgBaseQuery {

    public String getTableSchema() {
        return (String) params.get("tableSchema");
    }

    public void setTableSchema(String tableSchema) {
        params.put("tableSchema", tableSchema);
    }

    public String getTableName() {
        return (String) params.get("tableName");
    }

    public void setTableName(String tableName) {
        params.put("tableName", tableName);
    }
}
