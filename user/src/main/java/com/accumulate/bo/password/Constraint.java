package com.accumulate.bo.password;

import com.accumulate.bo.password.check.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 密码的各种限制
 * Created by tjwang on 2017/1/4.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Constraint {

    @Min(value = 1, message = "最小长度最小为{value}")
    @Max(value = 100, message = "最小长度最大为{value}")
    private int min = 6;

    @Min(value = 1, message = "最大长度最小为{value}")
    @Max(value = 100, message = "最大长度最大为{value}")
    private int max = 20;

    @Min(value = 1, message = "最大重复单词数最小为{value}")
    @Max(value = 100, message = "最大重复单词数最大为{value}")
    private int maxRepeatCharacter = 3;

    private boolean enableNonAlphanumeric = true;

    @Min(value = 1, message = "特殊字符最小长度最小为{value}")
    @Max(value = 100, message = "特殊字符最小长度最大为{value}")
    private int minNonAlphanumeric = 3;

    private boolean enableDigits = true;

    @Min(value = 1, message = "数字最小长度最小为{value}")
    @Max(value = 100, message = "数字最小长度最大为{value}")
    private int minDigits = 1;

    private boolean enableLowercase = true;

    @Min(value = 1, message = "小写字母最小长度最小为{value}")
    @Max(value = 100, message = "小写字母最小长最大为{value}")
    private int minLowercase = 1;

    private boolean enableUppercase = true;

    @Min(value = 1, message = "大写字母最小长度最小为{value}")
    @Max(value = 100, message = "大写字母最小长度最大为{value}")
    private int minUppercase = 1;

    /**
     * 是否能包含空字符' '
     */
    private boolean notBlank = true;

    private Constraint() {
    }

    public Constraint(int min, int max, int maxRepeatCharacter,
                      boolean enableNonAlphanumeric, int minNonAlphanumeric,
                      boolean enableDigits, int minDigits,
                      boolean enableLowercase, int minLowercase,
                      boolean enableUppercase, int minUppercase,
                      boolean notBlank) {
        this.min = min;
        this.max = max;
        this.maxRepeatCharacter = maxRepeatCharacter;
        this.enableNonAlphanumeric = enableNonAlphanumeric;
        this.minNonAlphanumeric = minNonAlphanumeric;
        this.enableDigits = enableDigits;
        this.minDigits = minDigits;
        this.enableLowercase = enableLowercase;
        this.minLowercase = minLowercase;
        this.enableUppercase = enableUppercase;
        this.minUppercase = minUppercase;
        this.notBlank = notBlank;
        PolicyTip policyTip = validation();
        if (!policyTip.isPass()) {
            throw new IllegalArgumentException(policyTip.getTip());
        }
    }

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
        if (this.enableNonAlphanumeric) {
            sb.append("，至少包含");
            sb.append(this.getMinNonAlphanumeric());
            sb.append("位特殊字符(如:!@&*,.)");
        }

        if (this.enableDigits) {
            sb.append("，至少包含");
            sb.append(this.getMinDigits());
            sb.append("位数字");
        }

        if (this.enableLowercase) {
            sb.append("，至少包含");
            sb.append(this.getMinLowercase());
            sb.append("位小写字母");
        }

        if (this.enableUppercase) {
            sb.append("，至少包含");
            sb.append(this.getMinUppercase());
            sb.append("位大写字母");
        }

        sb.append("。");

        return sb.toString();
    }


    /**
     * 最小长度
     *
     * @return
     */
    public int getMin() {
        return min;
    }

    /**
     * 最大长度
     *
     * @return
     */
    public int getMax() {
        return max;
    }

    /**
     * 最多重复字符
     *
     * @return
     */
    public int getMaxRepeatCharacter() {
        return maxRepeatCharacter;
    }

    /**
     * 是否开启特殊字符
     *
     * @return
     */
    public boolean isEnableNonAlphanumeric() {
        return enableNonAlphanumeric;
    }

    /**
     * 特殊字符最小数目
     *
     * @return
     */
    public int getMinNonAlphanumeric() {
        return minNonAlphanumeric;
    }

    /**
     * 是否开启数字
     *
     * @return
     */
    public boolean isEnableDigits() {
        return enableDigits;
    }

    /**
     * 数字最小数目
     *
     * @return
     */
    public int getMinDigits() {
        return minDigits;
    }

    /**
     * 是否开启小写字符
     *
     * @return
     */
    public boolean isEnableLowercase() {
        return enableLowercase;
    }

    /**
     * 小写字母最小数目
     *
     * @return
     */
    public int getMinLowercase() {
        return minLowercase;
    }

    /**
     * 是否开启大小字符
     *
     * @return
     */
    public boolean isEnableUppercase() {
        return enableUppercase;
    }

    /**
     * 大写字符最小数目
     *
     * @return
     */
    public int getMinUppercase() {
        return minUppercase;
    }

    public static Constraint buildDefault() {
        Constraint constraint = new Constraint(6, 20, 3, true, 1, false, 1, false, 1, false, 1, true);
        return constraint;
    }

    public PolicyTip check(String password) {
        PolicyTip.Items items = new PolicyTip.Items();

        ConstraintCheck lengthConstraintCheck = new LengthConstraintCheck(getMin(), getMax());
        items = items.add(lengthConstraintCheck.check(password))
                .add(new RepeatConstraintCheck(getMaxRepeatCharacter()).check(password));

        if (isEnableNonAlphanumeric()) {
            items = items.add(new NonAlphanumericConstraintCheck(getMinNonAlphanumeric()).check(password));
        }

        if (isEnableDigits()) {
            items = items.add(new DigitsConstraintCheck(getMinDigits()).check(password));
        }

        if (isEnableLowercase()) {
            items = items.add(new LowercaseConstraintCheck(getMinLowercase()).check(password));
        }
        if (isEnableUppercase()) {
            items = items.add(new UppercaseConstraintCheck(getMinUppercase()).check(password));
        }
        if (isNotBlank()) {
            items = items.add(new BlankConstraintCheck().check(password));
        }
        return items.stop();
    }

    /**
     * 验证约束条件最小值之和超过密码的最大长度
     *
     * @return
     */
    public PolicyTip validation() {
        int min = 0;
        if (isEnableNonAlphanumeric()) {
            min = min + this.getMinNonAlphanumeric();
        }
        if (this.isEnableDigits()) {
            min = min + this.getMinDigits();
        }
        if (this.isEnableLowercase()) {
            min = min + this.getMinLowercase();
        }

        if (this.isEnableUppercase()) {
            min = min + this.getMinUppercase();
        }

        if (min > this.getMax()) {
            return new PolicyTip("各约束条件的最小值之和超过密码的最大长度。", false);
        }
        return PolicyTip.pass();
    }

    public boolean isNotBlank() {
        return notBlank;
    }

}
