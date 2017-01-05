package com.accumulate.bo.password;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * 密码过期配置
 * Created by tjwang on 2017/1/4.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Expiration {

    /**
     * 是否启用
     */
    private boolean enable = false;

    /**
     * 过期天数
     */
    @Min(value = 1, message = "过期时间最小为{value}")
    @Max(value = 100, message = "过期时间最大为{value}")
    private int expiredDay = 30;

    /**
     * 过期前多少天提醒
     */
    @Min(value = 1, message = "过期警告时间最小为{value}")
    @Max(value = 100, message = "过期警告时间最大为{value}")
    private int waringBeforeDay = 10;

    /**
     * 提示方式
     */
    private ExpiredWaringAction waringAction = ExpiredWaringAction.EMAIL;

    /**
     * 邮件主题
     */
    @Size(min = 0, max = 20, message = "邮件主题模板必须为{min}到{max}个字符")
    private String subject;

    /**
     * 将过期邮件信息
     */
    @Size(min = 0, max = 200, message = "邮件内容必须为{min}到{max}个字符")
    private String emailExpiringMessage;

    /**
     * 已过期邮件信息
     */
    @Size(min = 0, max = 200, message = "过期邮件内容必须为{min}到{max}个字符")
    private String emailExpiredMessage;

    /**
     * 将过期短信信息
     */
    @Size(min = 0, max = 200, message = "短信内容必须为{min}到{max}个字符")
    private String smsExpiringMessage;

    /**
     * 已过期短信信息
     */
    @Size(min = 0, max = 200, message = "过期短信内容必须为{min}到{max}个字符")
    private String smsExpiredMessage;

    private Expiration() {
    }

    public Expiration(boolean enable) {
        this.enable = enable;
    }

    public static Expiration buildDefault() {
        Expiration expiration = new Expiration(true);
        expiration.expiredDay = 30;
        expiration.waringBeforeDay = 10;
        expiration.waringAction = ExpiredWaringAction.EMAIL;
        expiration.subject = "密码过期通知，请勿回复";
        expiration.emailExpiringMessage = "尊敬的用户{{u.displayName}}你好,你的账户【{{u.username}}】密码将在{{d}}天后过期，请在【个人中心】及时修改密码。请勿回复本邮件。";
        expiration.emailExpiredMessage = "尊敬的用户{{u.displayName}}你好,你账户【{{u.username}}】密码已过期，通过【忘记密码】流程重置密码。请勿回复本邮件。";
        expiration.smsExpiringMessage = "尊敬的用户【{{u.username}}】你好,你的账户密码将在{{d}}天后过期，请及时修改密码。请勿回复本短信。";
        expiration.smsExpiredMessage = "尊敬的用户【{{u.username}}】你好,你的账户密码已过期，通过【忘记密码】流程重置密码。请勿回复本短信。";
        return expiration;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getExpiredDay() {
        return expiredDay;
    }

    public void setExpiredDay(int expiredDay) {
        this.expiredDay = expiredDay;
    }

    public int getWaringBeforeDay() {
        return waringBeforeDay;
    }

    public void setWaringBeforeDay(int waringBeforeDay) {
        this.waringBeforeDay = waringBeforeDay;
    }

    public ExpiredWaringAction getWaringAction() {
        return waringAction;
    }

    public void setWaringAction(ExpiredWaringAction waringAction) {
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
