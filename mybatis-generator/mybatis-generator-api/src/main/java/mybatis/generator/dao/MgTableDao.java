package mybatis.generator.dao;

import mybatis.generator.dao.query.MgTableQuery;
import mybatis.generator.domain.MgTableDO;

import java.util.List;

/**
 * @author unclezhao on 15-11-26.
 */
public interface MgTableDao extends BaseDao {

    List<MgTableDO> query(MgTableQuery query);
}
