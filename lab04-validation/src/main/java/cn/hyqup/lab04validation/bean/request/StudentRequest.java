package cn.hyqup.lab04validation.bean.request;

import cn.hyqup.lab04validation.base.validator.annations.ParamCheck;
import cn.hyqup.lab04validation.base.validator.enums.CheckType;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Copyright © 2021灼华. All rights reserved.
 *
 * @author create by hyq
 * @version 1.0
 * @date 2021/2/6
 * @description:
 */
@Data
public class StudentRequest {
    //    @ParamCheck(checkType = CheckType.Custom, message = "自定义校验异常", clazz = UserNameCheck.class)
    private String name;

    //    @ParamCheck(checkType = CheckType.Custom, message = "自定义校验异常")
    @NotNull
    private String age;

    //    @NotEmpty(message = "不能为空")
//    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    @ParamCheck(checkType = CheckType.MobilePhone, message = "手机号码格式错误")
    private String phone;

}
