package com.accumulate.dto;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by tjwang on 2016/9/15.
 */
public class TestInnerDto2 {

    @NotBlank(message = "公司信息不能为空")
    private String company;

    private String locate;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

}
