package com.accumulate.dto;

import com.accumulate.entity.PasswordPolicyConfig;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * 密码策略设置
 * Created by tjwang on 2017/1/5.
 */
public class PasswordPolicyConfigCreateDto {

    private Integer id;

    private String name;

    private String description;

    private Boolean banned;

    private String bannedUrl;

    private PasswordPolicyConstraintDto constraint;

    private PasswordPolicyExpirationDto expiration;

    private PasswordPolicyRetryDto retry;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    public PasswordPolicyConfig transfer() {
        PasswordPolicyConfig c = new PasswordPolicyConfig();
        BeanUtils.copyProperties(this, c);
        c.setEnable(false);
        c.setConstraintId(0);
        c.setExpirationId(0);
        c.setRetryId(0);
        return c;
    }

    public static PasswordPolicyConfigCreateDto build(PasswordPolicyConfig config) {
        PasswordPolicyConfigCreateDto dto = new PasswordPolicyConfigCreateDto();
        BeanUtils.copyProperties(config, dto);
        return dto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    public String getBannedUrl() {
        return bannedUrl;
    }

    public void setBannedUrl(String bannedUrl) {
        this.bannedUrl = bannedUrl == null ? null : bannedUrl.trim();
    }

    public PasswordPolicyConstraintDto getConstraint() {
        return constraint;
    }

    public void setConstraint(PasswordPolicyConstraintDto constraint) {
        this.constraint = constraint;
    }

    public PasswordPolicyExpirationDto getExpiration() {
        return expiration;
    }

    public void setExpiration(PasswordPolicyExpirationDto expiration) {
        this.expiration = expiration;
    }

    public PasswordPolicyRetryDto getRetry() {
        return retry;
    }

    public void setRetry(PasswordPolicyRetryDto retry) {
        this.retry = retry;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

}
