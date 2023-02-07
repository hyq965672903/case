package cn.hyqup.validator.annations;


import cn.hyqup.validator.core.ParamCheckValidator;
import cn.hyqup.validator.core.ParamValidator;
import cn.hyqup.validator.enums.CheckType;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Copyright © 2021灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2021/2/8
 * @description:  是JSR303规范必须的参数
 */
@Target({FIELD, PARAMETER,METHOD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ParamCheckValidator.class})
public @interface ValidateProperty {

    /**
     * 返回错误信息
     */
    String message() default "参数校验不合法";

    /**
     * 分组
     */
    Class<?>[] groups() default {};

    /**
     * 极少用到 携带数据
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * 验证类型 必填
     *
     * @return
     */
    CheckType checkType();

    /**
     * 自定义处理入参的类
     * 使用自定义接口实现参数校验的时候需要指定
     *
     * @return
     */
    Class<? extends ParamValidator> clazz() default ParamValidator.class;
}
