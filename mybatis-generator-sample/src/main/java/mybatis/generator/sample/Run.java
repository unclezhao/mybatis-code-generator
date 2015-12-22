package mybatis.generator.sample;

import mybatis.generator.util.AppParams;
import mybatis.generator.util.MysqlGenerator;
import org.apache.commons.lang3.StringUtils;

/**
 * @author unclezhao on 15-12-3.
 */
public class Run {

    public static void main(String[] args) {
        String dbSchema = AppParams.INSTANCE.getGenerateDbSchema();
        if(StringUtils.isBlank(dbSchema)) {
            throw new AssertionError("param generate db schema not found");
        }
        new MysqlGenerator().generating(dbSchema);
    }
}
