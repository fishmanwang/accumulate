package com.accumulate.dto;

import com.accumulate.entity.PasswordPolicyConstraint;
import org.springframework.beans.BeanUtils;

/**
 * 密码配置限制
 * Created by tjwang on 2017/1/5.
 */
public class PasswordPolicyConstraintDto {

    private Integer id;

    private Boolean enable;

    private Integer min;

    private Integer max;

    private Integer maxRepeatCharacter;

    private Integer minNonAlphanumeric;

    private Integer minDigits;

    private Integer minLowercase;

    private Integer minUppercase;

    private Boolean notBlank;

    public PasswordPolicyConstraint transfer() {
        PasswordPolicyConstraint c = new PasswordPolicyConstraint();
        BeanUtils.copyProperties(this, c);
        return c;
    }

    public static PasswordPolicyConstraintDto build(PasswordPolicyConstraint constraint) {
        PasswordPolicyConstraintDto dto = new PasswordPolicyConstraintDto();
        BeanUtils.copyProperties(constraint, dto);
        return dto;
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

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMaxRepeatCharacter() {
        return maxRepeatCharacter;
    }

    public void setMaxRepeatCharacter(Integer maxRepeatCharacter) {
        this.maxRepeatCharacter = maxRepeatCharacter;
    }

    public Integer getMinNonAlphanumeric() {
        return minNonAlphanumeric;
    }

    public void setMinNonAlphanumeric(Integer minNonAlphanumeric) {
        this.minNonAlphanumeric = minNonAlphanumeric;
    }

    public Integer getMinDigits() {
        return minDigits;
    }

    public void setMinDigits(Integer minDigits) {
        this.minDigits = minDigits;
    }

    public Integer getMinLowercase() {
        return minLowercase;
    }

    public void setMinLowercase(Integer minLowercase) {
        this.minLowercase = minLowercase;
    }

    public Integer getMinUppercase() {
        return minUppercase;
    }

    public void setMinUppercase(Integer minUppercase) {
        this.minUppercase = minUppercase;
    }

    public Boolean getNotBlank() {
        return notBlank;
    }

    public void setNotBlank(Boolean notBlank) {
        this.notBlank = notBlank;
    }

}
