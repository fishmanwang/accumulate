package com.accumulate.entity;

/**
 * Created by tjwang on 2016/8/10.
 */
public class UserEntity extends BaseEntity {

    private String name;

    private Integer age;

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
