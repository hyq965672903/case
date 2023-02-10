package cn.hyqup.validator.utils;


import cn.hutool.extra.spring.SpringUtil;
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

    public static Boolean customValidate(Object value, Class<? extends ParamValidator> clazz) {
        ParamValidator bean = SpringUtil.getBean(clazz);
        if (bean == null) {
            throw new IllegalArgumentException("IOC容器中找不到该验证类");
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

    public static Boolean isMobilePhone(Object value) {
        if (null == value) {
            return Boolean.FALSE;
        }
        return MOBILE.matcher(String.valueOf(value)).matches();
    }

    /**
     * 判断参数是否是 true
     * 支持Boolean类型
     * 支持String类型
     *
     * @param value
     * @return
     */
    public static Boolean isTrue(Object value) {

        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        if (value instanceof String) {
            try {
                return Boolean.parseBoolean((String) value);
            } catch (Exception e) {
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * 判断参数是否是 false
     * 支持Boolean类型
     * 支持String类型
     *
     * @param value
     * @return
     */
    public static Boolean isFalse(Object value) {
        return !isTrue(value);
    }


}
