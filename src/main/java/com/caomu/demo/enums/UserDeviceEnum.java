package com.caomu.demo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * mybatis-plus 使用枚举
 *
 * @author admin
 */
public enum UserDeviceEnum {

    /**
     *
     */
    ONE(1, "一岁"),
    /**
     *
     */
    THREE(3, "三岁"),
    /**
     *
     */
    TWO(2, "二岁");

    /**
     * 数据库保存的值
     */
    @EnumValue
    private Integer value;

    /**
     * 显示的值
     */
    @JsonValue
    private String desc;

    UserDeviceEnum(Integer value, String desc) {

        this.value = value;
        this.desc  = desc;
    }

}
