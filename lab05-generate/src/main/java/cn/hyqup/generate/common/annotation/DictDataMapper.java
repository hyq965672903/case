package cn.hyqup.generate.common.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字典数据映射注解
 *
 * @author itino
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@JacksonAnnotationsInside
public @interface DictDataMapper {

    /**
     * 设置字典的type值 (如: sys_user_sex)
     */
    String dictType() default "";
}
