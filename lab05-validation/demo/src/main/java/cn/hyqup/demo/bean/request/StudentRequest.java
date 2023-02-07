package cn.hyqup.demo.bean.request;

import cn.hyqup.validator.annations.ParamCheck;
import cn.hyqup.validator.enums.CheckType;
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
    private String name;

    @NotNull(message = "年龄不能为空")
    private String age;


    @ParamCheck(checkType = CheckType.MobilePhone, message = "手机号码格式错误")
    private String phone;

}
