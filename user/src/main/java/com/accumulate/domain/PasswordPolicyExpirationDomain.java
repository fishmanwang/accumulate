package com.accumulate.domain;

/**
 * Created by tjwang on 2017/1/6.
 */
public class PasswordPolicyExpirationDomain {

    private Integer id;

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
        this.subject = subject;
    }

    public String getEmailExpiringMessage() {
        return emailExpiringMessage;
    }

    public void setEmailExpiringMessage(String emailExpiringMessage) {
        this.emailExpiringMessage = emailExpiringMessage;
    }

    public String getEmailExpiredMessage() {
        return emailExpiredMessage;
    }

    public void setEmailExpiredMessage(String emailExpiredMessage) {
        this.emailExpiredMessage = emailExpiredMessage;
    }

    public String getSmsExpiringMessage() {
        return smsExpiringMessage;
    }

    public void setSmsExpiringMessage(String smsExpiringMessage) {
        this.smsExpiringMessage = smsExpiringMessage;
    }

    public String getSmsExpiredMessage() {
        return smsExpiredMessage;
    }

    public void setSmsExpiredMessage(String smsExpiredMessage) {
        this.smsExpiredMessage = smsExpiredMessage;
    }
}
