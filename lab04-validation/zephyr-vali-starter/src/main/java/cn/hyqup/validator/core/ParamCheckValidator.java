package cn.hyqup.validator.core;


import cn.hyqup.validator.annations.ValidateProperty;
import cn.hyqup.validator.enums.CheckType;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Copyright © 2021灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2021/2/8
 * @description:
 */
@Slf4j
public class ParamCheckValidator implements ConstraintValidator<ValidateProperty, Object> {

    private String message;
    private CheckType checkType;
    private Class<? extends ParamValidator> clazz;

    @Override
    public void initialize(ValidateProperty validateProperty) {
        message = validateProperty.message();
        checkType = validateProperty.checkType();
        clazz = validateProperty.clazz();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }
        String tmpMsg = message;
        Boolean res = false;
        try {
            if (!clazz.isInterface() ) {
                res = checkType.biFun.apply(value, clazz);
            } else {
                res = checkType.fun.apply(value);
            }
        } catch (Exception e) {
            log.info("校验发生异常:{}",e.getMessage());
            String errorMessage = "";
            if (e.getCause() != null && e.getCause().getMessage() != null) {
                errorMessage = e.getCause().getMessage();
            } else {
                errorMessage = e.getMessage();
            }
            tmpMsg = message;
        }
        if (!res) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(tmpMsg)
                    .addConstraintViolation();
        }
        return res;
    }
}
