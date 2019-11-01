package com.ucloud.uaanal.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysTest implements Serializable {


    /**
     * id
     */
    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

}
