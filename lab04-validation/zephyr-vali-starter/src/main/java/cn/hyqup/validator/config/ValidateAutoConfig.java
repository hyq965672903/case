package cn.hyqup.validator.config;

import cn.hyqup.validator.advice.ValidateRequestBodyAdvice;
import cn.hyqup.validator.aop.ParamCheckAop;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Copyright © 2021灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2021/2/8
 * @description:
 */
@Configuration
@Import({SpringMvcConfig.class, ParamCheckAop.class, ValidateRequestBodyAdvice.class})
public class ValidateAutoConfig {


}
