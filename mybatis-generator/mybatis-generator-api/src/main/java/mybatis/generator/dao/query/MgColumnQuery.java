package mybatis.generator.dao.query;

/**
 * @author unclezhao on 15-11-26.
 */
public class MgColumnQuery extends MgBaseQuery {

    public String getDbSchema() {
        return (String) params.get("dbSchema");
    }

    public void setDbSchema(String dbSchema) {
        params.put("dbSchema", dbSchema);
    }

    public String getTableName() {
        return (String) params.get("tableName");
    }

    public void setTableName(String tableName) {
        params.put("tableName", tableName);
    }
}
