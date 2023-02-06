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
    MobilePhone("参数必须是手机号", CheckUtil::isMobilePhone)
    ;


    public String msg;

    public Function<Object, Boolean> fun1;

    public BiFunction<Object, Class<? extends ParamValidator>, Boolean> fun2;


    CheckType(String msg, Function<Object, Boolean> fun1) {
        this.msg = msg;
        this.fun1 = fun1;
    }

    CheckType(String msg, BiFunction<Object, Class<? extends ParamValidator>, Boolean> fun2) {
        this.msg = msg;
        this.fun2 = fun2;
    }
}
