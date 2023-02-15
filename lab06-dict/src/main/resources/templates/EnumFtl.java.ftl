package cn.hyqup.dict.code;

import cn.hyqup.dict.base.IBaseEnum;
import lombok.Getter;


public enum {{className}} implements IBaseEnum<String> {
    MALE("1", "男"),
    FEMALE("2", "女"),
    ;

    @Getter
    private String code;
    @Getter
    private String name;


    SexEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
