package mybatis.generator.dao;

import mybatis.generator.dao.query.MgColumnQuery;
import mybatis.generator.domain.MgColumnDO;

import java.util.List;

/**
 * @author unclezhao on 15-11-26.
 */
public interface MgColumnDao extends BaseDao {

    /**
     * query meta data by db schema and table name
     *
     * @param query query params
     * @return
     */
    List<MgColumnDO> query(MgColumnQuery query);
}
