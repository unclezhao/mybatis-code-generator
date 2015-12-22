package mybatis.generator.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author unclezhao on 15-11-26.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MybatisRepository {
}
