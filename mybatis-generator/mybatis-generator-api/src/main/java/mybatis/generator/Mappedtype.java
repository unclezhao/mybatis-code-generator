package mybatis.generator;

/**
 * @author unclezhao on 15-11-30.
 */
public interface Mappedtype {

    String getJavaTypeName(String dbColumnName);
    String getJavaImportName(String dbColumnName);
}
