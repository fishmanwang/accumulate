package com.accumulate.dto;

import java.util.Date;
import java.util.Set;

/**
 * 密码策略设置
 * Created by tjwang on 2017/1/5.
 */
public class PasswordPolicyDto {

    private String name;

    private String description;

    private Boolean enable;

    private Boolean banned;

    private Set<String> bannedSet;

    private ConstraintDto constraint;

    private ExpirationDto expiration;

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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    public Set<String> getBannedSet() {
        return bannedSet;
    }

    public void setBannedSet(Set<String> bannedSet) {
        this.bannedSet = bannedSet;
    }

    public ConstraintDto getConstraint() {
        return constraint;
    }

    public void setConstraint(ConstraintDto constraint) {
        this.constraint = constraint;
    }

    public ExpirationDto getExpiration() {
        return expiration;
    }

    public void setExpiration(ExpirationDto expiration) {
        this.expiration = expiration;
    }

    /**
     * 密码策略约束
     */
    public static class ConstraintDto {

        private Boolean enable;

        private Integer min;

        private Integer max;

        private Integer maxRepeatCharacter;

        private Integer minNonAlphanumeric;

        private Integer minDigits;

        private Integer minLowercase;

        private Integer minUppercase;

        private Boolean noBlank;

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

        public Boolean getNoBlank() {
            return noBlank;
        }

        public void setNoBlank(Boolean noBlank) {
            this.noBlank = noBlank;
        }
    }

    /**
     * 过期信息
     */
    public static class ExpirationDto {

        private Boolean enable;

        private Integer expiredDay;

        private Integer waringBeforeDay;

        /**
         * 1.邮箱；2.手机。
         */
        private Integer waringAction;

        private String subject;

        private String emailExpiringMessage;

        private String emailExpiredMessage;

        private String smsExpiringMessage;

        private String smsExpiredMessage;

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        public Integer getExpiredDay() {
            return expiredDay;
        }

        public void setExpiredDay(Integer expiredDay) {
            this.expiredDay = expiredDay;
        }

        public Integer getWaringBeforeDay() {
            return waringBeforeDay;
        }

        public void setWaringBeforeDay(Integer waringBeforeDay) {
            this.waringBeforeDay = waringBeforeDay;
        }

        public Integer getWaringAction() {
            return waringAction;
        }

        public void setWaringAction(Integer waringAction) {
            this.waringAction = waringAction;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject == null ? null : subject.trim();
        }

        public String getEmailExpiringMessage() {
            return emailExpiringMessage;
        }

        public void setEmailExpiringMessage(String emailExpiringMessage) {
            this.emailExpiringMessage = emailExpiringMessage == null ? null : emailExpiringMessage.trim();
        }

        public String getEmailExpiredMessage() {
            return emailExpiredMessage;
        }

        public void setEmailExpiredMessage(String emailExpiredMessage) {
            this.emailExpiredMessage = emailExpiredMessage == null ? null : emailExpiredMessage.trim();
        }

        public String getSmsExpiringMessage() {
            return smsExpiringMessage;
        }

        public void setSmsExpiringMessage(String smsExpiringMessage) {
            this.smsExpiringMessage = smsExpiringMessage == null ? null : smsExpiringMessage.trim();
        }

        public String getSmsExpiredMessage() {
            return smsExpiredMessage;
        }

        public void setSmsExpiredMessage(String smsExpiredMessage) {
            this.smsExpiredMessage = smsExpiredMessage == null ? null : smsExpiredMessage.trim();
        }
    }

}
