package mybatis.generator.dto;

import mybatis.generator.SerialModel;
import mybatis.generator.domain.MgTableDO;

import java.util.Date;

/**
 * @author unclezhao on 15-11-26.
 */
public class MgTableDTO extends SerialModel {

    private MgTableDO tableDO;

    public MgTableDTO() {
        this(new MgTableDO());
    }

    public MgTableDTO(MgTableDO tableDO) {
        this.tableDO = tableDO;
    }

    public String getTableName() {
        return tableDO.getTableName();
    }

    public void setTableName(String tableName) {
        this.tableDO.setTableName(tableName);
    }

    public Date getGmtCreate() {
        return tableDO.getGmtCreate();
    }

    public void setGmtCreate(Date gmtCreate) {
        this.tableDO.setGmtCreate(gmtCreate);
    }
}
