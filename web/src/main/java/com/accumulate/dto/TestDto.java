package com.accumulate.dto;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by tjwang on 2016/8/10.
 */
public class TestDto {

    @NotBlank
    private String name;

    private Integer age;

    @Override
    public String toString() {
        return "TestDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
