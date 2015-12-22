package mybatis.generator;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Created by young on 15-5-27.
 */
public abstract class BaseProperties extends Properties {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseProperties.class);

    private String propertyFilePath;

    public BaseProperties(String propertyFilePath) {
        super();

        URL propFileUrl = BaseProperties.class.getResource(propertyFilePath);
        if(propFileUrl != null) {
            this.propertyFilePath = propertyFilePath;
        }

        LOGGER.info("The property file path in: {}", propertyFilePath);

        InputStream propFileIn = BaseProperties.class.getResourceAsStream(this.propertyFilePath);
        try {
            this.load(propFileIn);
        } catch (Exception e) {
            LOGGER.error("Fail to load the {}", this.propertyFilePath, e);
        }
    }

    public int getPropertyAsInt(String key) {
        String value = this.getProperty(key);
        int result = NumberUtils.toInt(value);

        LOGGER.debug("A key: {}, value: {} in {}", key, value, this.propertyFilePath);

        return result;
    }

    public int getPropertyAsInt(String key, int defaultValue) {
        String value = this.getProperty(key, String.valueOf(defaultValue));
        int result = NumberUtils.toInt(value);


        LOGGER.debug("A key: {}, value: {}, default: {} in {}", key, value, defaultValue, this.propertyFilePath);

        return result;
    }

    public boolean getPropertyAsBool(String key) {
        String value = this.getProperty(key);
        boolean result = BooleanUtils.toBoolean(value);

        LOGGER.debug("A key: {}, value: {} in {}", key, value, this.propertyFilePath);

        return result;
    }

    public boolean getPropertyAsBool(String key, boolean defaultValue) {
        String value = this.getProperty(key, String.valueOf(defaultValue));
        boolean result = BooleanUtils.toBoolean(value);


        LOGGER.debug("A key: {}, value: {}, default: {} in {}", key, value, defaultValue, this.propertyFilePath);

        return result;
    }

    public long getPropertyAsLong(String key) {
        String value = this.getProperty(key);
        long result = NumberUtils.toLong(value);

        LOGGER.debug("A key: {}, value: {} in {}", key, value, this.propertyFilePath);

        return result;
    }


    public long getPropertyAsLong(String key, long defaultValue) {
        String value = this.getProperty(key, String.valueOf(defaultValue));
        long result = NumberUtils.toLong(value);


        LOGGER.debug("A key: {}, value: {}, default: {} in {}", key, value, defaultValue, this.propertyFilePath);

        return result;
    }

}
