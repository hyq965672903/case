package cn.hyqup.validator.config;

import cn.hyqup.validator.advice.ValidateRequestBodyAdvice;
import cn.hyqup.validator.aop.ParamCheckAop;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({ParamCheckAop.class, ValidateRequestBodyAdvice.class})
public @interface EnableValidate {
}
