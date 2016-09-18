package com.accumulate.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by tjwang on 2016/8/10.
 */
public class TestDto {

    @NotBlank(message = "名称不能为空")
    private String name;

    private Integer age;

    @Valid
    @NotNull(message = "内部信息不能为空")
    private TestInnerDto inner;

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

    public TestInnerDto getInner() {
        return inner;
    }

    public void setInner(TestInnerDto inner) {
        this.inner = inner;
    }
}
