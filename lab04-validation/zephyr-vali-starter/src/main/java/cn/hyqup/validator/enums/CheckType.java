package cn.hyqup.validator.enums;


import cn.hyqup.validator.core.ParamValidator;
import cn.hyqup.validator.utils.CheckUtil;

import java.util.function.BiFunction;
import java.util.function.Function;


/**
 * Copyright © 2021灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2021/2/8
 * @description:
 */
public enum CheckType {

    /**
     * 自定义方法佳肴
     */
    Custom("参数验证不通过", CheckUtil::customValidate),

    Null("参数必须为空", CheckUtil::isNull),
    MobilePhone("参数必须是手机号", CheckUtil::isMobilePhone),
    True("参数必须为 true", CheckUtil::isTrue),

    False("参数必须为 false", CheckUtil::isFalse),
    ;


    public String msg;

    public Function<Object, Boolean> fun;

    public BiFunction<Object, Class<? extends ParamValidator>, Boolean> biFun;


    CheckType(String msg, Function<Object, Boolean> fun) {
        this.msg = msg;
        this.fun = fun;
    }

    CheckType(String msg, BiFunction<Object, Class<? extends ParamValidator>, Boolean> biFun) {
        this.msg = msg;
        this.biFun = biFun;
    }
}
