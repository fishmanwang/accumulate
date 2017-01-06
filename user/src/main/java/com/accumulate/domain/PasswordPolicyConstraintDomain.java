package com.accumulate.domain;

import com.accumulate.domain.check.ConstraintCheck;
import com.accumulate.domain.check.*;

/**
 * Created by tjwang on 2017/1/6.
 */
public class PasswordPolicyConstraintDomain {

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

    public PolicyTip check(String password) {
        PolicyTip.Items items = new PolicyTip.Items();

        ConstraintCheck lengthConstraintCheck = new LengthConstraintCheck(getMin(), getMax());
        items = items.add(lengthConstraintCheck.check(password))
                .add(new RepeatConstraintCheck(getMaxRepeatCharacter()).check(password));

        if (getMinNonAlphanumeric() != 0) {
            items = items.add(new NonAlphanumericConstraintCheck(getMinNonAlphanumeric()).check(password));
        }

        if (getMinDigits() != 0) {
            items = items.add(new DigitsConstraintCheck(getMinDigits()).check(password));
        }

        if (getMinLowercase() != 0) {
            items = items.add(new LowercaseConstraintCheck(getMinLowercase()).check(password));
        }
        if (getMinUppercase() != 0) {
            items = items.add(new UppercaseConstraintCheck(getMinUppercase()).check(password));
        }
        if (getNotBlank()) {
            items = items.add(new BlankConstraintCheck().check(password));
        }
        return items.stop();
    }

    /**
     * 获取密码限制提示信息
     * @return
     */
    public String getTip() {
        StringBuilder sb = new StringBuilder();
        sb.append("为保证安全，密码有以下限制：");
        sb.append("最小长度");
        sb.append(this.getMin());
        sb.append("，最大长度");
        sb.append(this.getMax());
        sb.append("，最多包含");
        sb.append(this.getMaxRepeatCharacter());
        sb.append("个重复字符");
        if (this.getMinNonAlphanumeric() != 0) {
            sb.append("，至少包含");
            sb.append(this.getMinNonAlphanumeric());
            sb.append("位特殊字符(如:!@&*,.)");
        }

        if (this.getMinDigits() != 0) {
            sb.append("，至少包含");
            sb.append(this.getMinDigits());
            sb.append("位数字");
        }

        if (this.getMinLowercase() != 0) {
            sb.append("，至少包含");
            sb.append(this.getMinLowercase());
            sb.append("位小写字母");
        }

        if (this.getMinUppercase() != 0) {
            sb.append("，至少包含");
            sb.append(this.getMinUppercase());
            sb.append("位大写字母");
        }

        sb.append("。");

        return sb.toString();
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
