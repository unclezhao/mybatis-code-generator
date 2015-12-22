package mybatis.generator.enums;

import mybatis.generator.Mappedtype;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Contact first:
 *      DB type     Java type
 *      smallint    Integer
 *      int         Long
 *      bigint      Long
 *      char        String
 *      varchar     String
 *      text        String
 *      date        Date
 *      datetime    Date
 *      float       BigDecimal
 *      double      BigDecimal
 *      decimal     BigDecimal
 *
 * @author unclezhao on 15-11-30.
 */
public enum MgMysqlMappedTypeEnum implements Mappedtype {

    INT(Arrays.asList("smallint"), Integer.class.getSimpleName(), Integer.class.getName()),
    LONG(Arrays.asList("int", "bigint"), Long.class.getSimpleName(), Long.class.getName()),
    STRING(Arrays.asList("char", "varchar", "text"), String.class.getSimpleName(), String.class.getName()),
    DATE(Arrays.asList("date", "datetime"), Date.class.getSimpleName(), Date.class.getName()),
    DECIMAL(Arrays.asList("float", "double", "decimal"), BigDecimal.class.getSimpleName(), BigDecimal.class.getName()),
    UNKNOWN(Arrays.asList("UnknownColumnType"), "UnknownMappedType", null);

    private MgMysqlMappedTypeEnum(List<String> columnNames, String simpleMappedTypeName, String fullMappedTypeName) {
        this.columnNames = columnNames;
        this.simpleMappedTypeName = simpleMappedTypeName;
        this.fullMappedTypeName = fullMappedTypeName;
    }

    private List<String> columnNames;
    private String simpleMappedTypeName;
    private String fullMappedTypeName;

    public List<String> getColumnNames() {
        return columnNames;
    }

    public String getSimpleMappedTypeName() {
        return simpleMappedTypeName;
    }

    public String getFullMappedTypeName() {
        return fullMappedTypeName;
    }

    public static MgMysqlMappedTypeEnum toEnum(String dbColumnName) {
        if(StringUtils.isBlank(dbColumnName))
            return UNKNOWN;
        for(MgMysqlMappedTypeEnum temp : values()) {
            for(String dbType : temp.getColumnNames()) {
                if (dbType.equals(dbColumnName))
                    return temp;
            }
        }
        return UNKNOWN;
    }

    @Override
    public String getJavaTypeName(String dbColumnName) {
        return toEnum(dbColumnName).getSimpleMappedTypeName();
    }

    @Override
    public String getJavaImportName(String dbColumnName) {
        return toEnum(dbColumnName).getFullMappedTypeName();
    }
}
