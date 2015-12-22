package mybatis.generator.util;

import mybatis.generator.BaseProperties;

/**
 * Created by young on 15-6-3.
 */
public class AppProperties extends BaseProperties {

    private static final String PROPERTY_FILE_PATH = "/config/application.properties";

    private static final class LazyHolder {
        public static final AppProperties INSTANCE = new AppProperties();
    }

    public static AppProperties getInstance() {
        return LazyHolder.INSTANCE;
    }

    private AppProperties() {
        super(PROPERTY_FILE_PATH);
    }
}
