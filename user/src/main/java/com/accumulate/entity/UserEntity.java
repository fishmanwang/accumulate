package com.accumulate.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Created by tjwang on 2016/8/10.
 */
public class UserEntity extends BaseEntity {

    @NotBlank
    @Size(min = 6, max = 20)
    private String name;

    @Min(0)
    @Max(150)
    private Integer age;

    private String password;

    @Override
    public void validate() {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
