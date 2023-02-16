package cn.hyqup.dict.code;

import cn.hyqup.dict.base.IBaseEnum;
import lombok.Getter;


public enum SexEnum implements IBaseEnum {
    MALE("1", "男"),
    FEMALE("2", "女"),
    ;

    @Getter
    private String value;
    @Getter
    private String name;
    SexEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }
}
