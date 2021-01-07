package com.commons.util.commons.shop.api.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

/**
 * @author cxk
 * @date 2021/1/7 18:42
 */
public enum SexEnum {
    /**
     * 男
     * */
    MAN(1, "男"),

    /**
     * 女
     * */
    WOMEN(2, "女");


    @EnumValue
    private final int code;

    @JsonValue
    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return description;
    }

    private final String description;
    SexEnum(int val, String description) {
        this.code = val;
        this.description = description;
    }

    @JsonCreator
    public static SexEnum getByCode(int code) {
        for (SexEnum value : SexEnum.values()) {
            if (Objects.equals(code, value.getCode())) {
                return value;
            }
        }
        return null;
    }
/*
    @Override
    public Integer getValue() {
        return code;
    }*/
}
