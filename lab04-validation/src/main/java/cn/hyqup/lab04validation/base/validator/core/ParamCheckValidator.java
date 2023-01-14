package cn.hyqup.lab04validation.base.validator.core;


import cn.hyqup.lab04validation.base.validator.enums.CheckType;
import cn.hyqup.lab04validation.base.validator.annations.ParamCheck;

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
public class ParamCheckValidator implements ConstraintValidator<ParamCheck, Object> {

    private String message;
    private CheckType checkType;
    private Class<? extends ParamValidator> clazz;

    @Override
    public void initialize(ParamCheck paramCheck) {
        message = paramCheck.message();
        checkType = paramCheck.checkType();
        clazz = paramCheck.clazz();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }
        String tmpMsg = message;
        Boolean res = false;
        try {
            if (null != clazz) {
                res = checkType.fun2.apply(value, clazz);
            } else {
                res = checkType.fun1.apply(value);
            }
        } catch (Exception e) {
            String errorMessage = "";
            if (e.getCause() != null && e.getCause().getMessage() != null) {
                errorMessage = e.getCause().getMessage();
            } else {
                errorMessage = e.getMessage();
            }
            tmpMsg = message + "; raw exception occured, info: " + errorMessage;
        }
        if (!res) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(tmpMsg)
                    .addConstraintViolation();
        }
        return res;
    }
}
