package cn.hyqup.validator.utils;


import cn.hyqup.validator.core.ParamValidator;

import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * Copyright © 2021灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2021/2/8
 * @description:
 */
public class CheckUtil {

    public final static Pattern MOBILE = Pattern.compile("(?:0|86|\\+86)?1[3456789]\\d{9}");

    public static Boolean  customValidate(Object value, Class<? extends ParamValidator> clazz) {
        ParamValidator bean = SpringtHolder.getBean(clazz);
        if (bean == null) {
            throw new IllegalArgumentException("invalied bean, this bean can not  found in spring context");
        }
        Function<Object, Boolean> func = bean::validate;
        return func.apply(value);
    }


    public static Boolean isNull(Object value) {
        if (null != value) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static Boolean isMobilePhone(Object value ) {
        if (null == value) {
            return Boolean.FALSE;
        }
        return MOBILE.matcher(String.valueOf(value)).matches();
    }


}
