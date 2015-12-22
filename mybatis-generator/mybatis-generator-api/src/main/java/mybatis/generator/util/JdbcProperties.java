package mybatis.generator.util;

import mybatis.generator.BaseProperties;

/**
 * Created by young on 15-6-3.
 */
public class JdbcProperties extends BaseProperties {

    private static final String PROPERTY_FILE_PATH = "/config/jdbc.properties";

    private static final class LazyHolder {
        public static final JdbcProperties INSTANCE = new JdbcProperties();
    }

    public static JdbcProperties getInstance() {
        return LazyHolder.INSTANCE;
    }

    private JdbcProperties() {
        super(PROPERTY_FILE_PATH);
    }
}
