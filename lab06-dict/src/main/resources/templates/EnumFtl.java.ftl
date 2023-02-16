package cn.hyqup.dict.code;

import cn.hyqup.dict.base.IBaseEnum;
import lombok.Getter;


public enum ${className} implements IBaseEnum {
    <#list dictList! as dict>
    ${dict.dictCode}("${dict.dictValue}", "${dict.dictName}"),
    </#list>
    ;

    @Getter
    private String value;
    @Getter
    private String name;
    ${className}(String value, String name) {
        this.value = value;
        this.name = name;
    }
}
