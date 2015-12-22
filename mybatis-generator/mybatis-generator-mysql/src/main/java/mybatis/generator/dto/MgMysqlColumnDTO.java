package mybatis.generator.dto;

import mybatis.generator.domain.MgColumnDO;
import mybatis.generator.enums.MgMysqlMappedTypeEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * @author unclezhao on 15-12-1.
 */
public class MgMysqlColumnDTO extends AbstractMgColumnDTO {

    public MgMysqlColumnDTO() {
        super();
    }

    public MgMysqlColumnDTO(MgColumnDO columnDO) {
        super(columnDO);
    }

    @Override
    public Boolean isPrimaryKey() {
        ColumnKeyEnum keyEnum = ColumnKeyEnum.toEnum(getColumnKey());
        if(keyEnum == ColumnKeyEnum.PRI)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    @Override
    public String getJavaType() {
        return MgMysqlMappedTypeEnum.toEnum(getDataType()).getSimpleMappedTypeName();
    }

    @Override
    public String getImportType() {
        return MgMysqlMappedTypeEnum.toEnum(getDataType()).getFullMappedTypeName();
    }

    public String getColumnNameUC() {
        return getColumnName().toUpperCase();
    }

    public Boolean hasDefaultVal() {
        return !StringUtils.isBlank(getColumnDefault());
    }

    private enum ColumnKeyEnum {

        PRI("PRI"),
        UNI("UNI"),
        MUL("MUL"),
        UNKNOWN("");

        private ColumnKeyEnum(String value) {
            this.value = value;
        }

        private String value;

        public String getValue() {
            return value;
        }

        public static ColumnKeyEnum toEnum(String val) {
            if(StringUtils.isBlank(val))
                return UNKNOWN;
            for(ColumnKeyEnum temp : values()) {
                if(temp.getValue().equals(val))
                    return temp;
            }
            return UNKNOWN;
        }
    }
}
