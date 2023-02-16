package cn.hyqup.dict.base;

import cn.hutool.core.util.ObjectUtil;

import java.util.EnumSet;
import java.util.Objects;

public interface IBaseEnum {
    public String getValue();

    String getName();

    static <E extends Enum<E> & IBaseEnum> E getEnumByValue(Object value, Class<E> clazz) {
        Objects.requireNonNull(value);
        EnumSet<E> allEnums = EnumSet.allOf(clazz); // 获取类型下的所有枚举
        E matchEnum = allEnums.stream()
                .filter(e -> ObjectUtil.equal(e.getValue(), value))
                .findFirst()
                .orElse(null);
        return matchEnum;
    }

    static <E extends Enum<E> & IBaseEnum> String getNameByValue(Object value, Class<E> clazz) {
        Objects.requireNonNull(value);
        EnumSet<E> allEnums = EnumSet.allOf(clazz); // 获取类型下的所有枚举
        E matchEnum = allEnums.stream()
                .filter(e -> ObjectUtil.equal(e.getValue(), value))
                .findFirst()
                .orElse(null);

        String name = null;
        if (matchEnum != null) {
            name = matchEnum.getName();
        }
        return name;
    }

    static <E extends Enum<E> & IBaseEnum> Object getValueByName(String name, Class<E> clazz) {
        Objects.requireNonNull(name);
        EnumSet<E> allEnums = EnumSet.allOf(clazz); // 获取类型下的所有枚举
        String finalLabel = name;
        E matchEnum = allEnums.stream()
                .filter(e -> ObjectUtil.equal(e.getName(), finalLabel))
                .findFirst()
                .orElse(null);

        Object value = null;
        if (matchEnum != null) {
            value = matchEnum.getValue();
        }
        return value;
    }


}
