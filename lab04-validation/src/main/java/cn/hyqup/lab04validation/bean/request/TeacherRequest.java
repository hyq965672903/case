package cn.hyqup.lab04validation.bean.request;

import cn.hyqup.lab04validation.validate.annations.AbcValidate;
import cn.hyqup.lab04validation.validate.enums.Check;
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
public class TeacherRequest {
    private String name;

    @NotNull
    private String age;

    @AbcValidate(required = true, fun = Check.MobilePhone)
    private String phone;

}
