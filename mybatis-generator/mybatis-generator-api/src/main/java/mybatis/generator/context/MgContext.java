package mybatis.generator.context;

/**
 * @author unclezhao on 15-12-2.
 */
public interface MgContext {

    String getPackageName();
    String getClassName();
    String getGeneratePath();
    String getFileName();
}
