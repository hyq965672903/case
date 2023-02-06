package cn.hyqup.lab04validation.validate.config;

import cn.hyqup.lab04validation.validate.core.CheckParamAop;
import cn.hyqup.lab04validation.validate.utils.SpringContextHolder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * springboot stater 自动装配
 *
 * @author liangbaikai
 * @version 0.1.0
 * @date 2020/5/17 14:23
 */
@Configuration
@Import({CheckParamAop.class, SpringContextHolder.class})
public class SpringValidateAutoConfig {
}
