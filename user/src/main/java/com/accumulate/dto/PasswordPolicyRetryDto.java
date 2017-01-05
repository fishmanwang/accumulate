package com.accumulate.dto;

import com.accumulate.entity.PasswordPolicyRetry;
import org.springframework.beans.BeanUtils;

/**
 * 密码策略重试设置
 * Created by tjwang on 2017/1/5.
 */
public class PasswordPolicyRetryDto {

    private Integer id;

    private Boolean enable;

    private Integer num;

    private Integer lockTime;

    public PasswordPolicyRetry transfer() {
        PasswordPolicyRetry r = new PasswordPolicyRetry();
        BeanUtils.copyProperties(this, r);
        return r;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getLockTime() {
        return lockTime;
    }

    public void setLockTime(Integer lockTime) {
        this.lockTime = lockTime;
    }
}