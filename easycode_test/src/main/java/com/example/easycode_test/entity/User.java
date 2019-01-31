package com.example.easycode_test.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2019-01-31 11:59:02
 */
public class User implements Serializable {
    private static final long serialVersionUID = 119145725943411241L;
    //ä¸»é?®
    private Long id;
    //å§?å??
    private String name;
    //å¹´é¾?
    private Integer age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}