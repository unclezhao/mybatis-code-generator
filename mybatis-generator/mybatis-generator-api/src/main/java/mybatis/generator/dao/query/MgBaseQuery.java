package mybatis.generator.dao.query;

import mybatis.generator.SerialModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author unclezhao on 15-11-26.
 */
public class MgBaseQuery extends SerialModel {

    protected Map<String, Object> params = new HashMap<>();

    public Map<String, Object> toMap() {
        return params;
    }

    public Integer getStart() {
        return (Integer) params.get("start");
    }

    public void setStart(Integer start) {
        params.put("start", start);
    }

    public Integer getSize() {
        return (Integer) params.get("size");
    }

    public void setSize(Integer size) {
        params.put("size", size);
    }
}
