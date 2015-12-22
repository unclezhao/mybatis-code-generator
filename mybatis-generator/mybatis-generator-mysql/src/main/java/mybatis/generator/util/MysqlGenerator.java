package mybatis.generator.util;

import mybatis.generator.domain.MgColumnDO;
import mybatis.generator.dto.MgMysqlColumnDTO;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author unclezhao on 15-12-22.
 */
public class MysqlGenerator extends AbstractGenerator<MgMysqlColumnDTO> {

    @Override
    public List<MgMysqlColumnDTO> fromDOList(List<MgColumnDO> list) {
        if(CollectionUtils.isEmpty(list))
            return Collections.emptyList();
        List<MgMysqlColumnDTO> columnDTOList = new ArrayList<>();
        for(MgColumnDO temp : list) {
            columnDTOList.add(new MgMysqlColumnDTO(temp));
        }
        return columnDTOList;
    }
}
