package mybatis.generator.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author unclezhao on 15-11-27.
 */
public class MybatisUtil {

    public SqlSessionFactory getSessionFactory() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            return factory;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
