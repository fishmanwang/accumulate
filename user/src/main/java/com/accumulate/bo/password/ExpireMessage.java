package com.accumulate.bo.password;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Size;

/**
 * 失效信息配置
 * Created by tjwang on 2017/1/4.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExpireMessage {

    @Size(min = 0, max = 20, message = "邮件主题模板必须为{min}到{max}个字符")
    private String subject;

    // 将要过期
    @Size(min = 0, max = 200, message = "邮件内容必须为{min}到{max}个字符")
    private String message;

    @Size(min = 0, max = 200, message = "过期邮件内容必须为{min}到{max}个字符")
    private String expiredMessage;

    @Size(min = 0, max = 200, message = "短信内容必须为{min}到{max}个字符")
    private String smsContent;

    @Size(min = 0, max = 200, message = "过期短信内容必须为{min}到{max}个字符")
    private String expiredSmsContent;

    private ExpireMessage() {
    }

    /**
     * 构造邮件过期信息
     * @param subject
     * @param message
     * @param expiredMessage
     * @return
     */
    public static ExpireMessage buildEmailExpireMessage(String subject, String message, String expiredMessage) {
        ExpireMessage m = new ExpireMessage();
        m.subject = subject;
        m.message = message;
        m.expiredMessage = expiredMessage;
        return m;
    }

    public static ExpireMessage buildSmsExpireMessage(String smsContent, String expiredSmsContent) {
        ExpireMessage m = new ExpireMessage();
        m.smsContent = smsContent;
        m.expiredMessage = expiredSmsContent;
        return m;
    }

    public static ExpireMessage buildFullExpireMessage(String subject, String message, String expiredMessage, String smsContent, String expiredSmsContent) {
        ExpireMessage m = new ExpireMessage();
        m.subject = subject;
        m.message = message;
        m.expiredMessage = expiredMessage;

        m.smsContent = smsContent;
        m.expiredSmsContent = expiredSmsContent;
        return m;
    }

    public static ExpireMessage buildDefault() {
        ExpireMessage expireMessage = buildEmailExpireMessage(
                "密码过期通知，请勿回复",
                "尊敬的用户{{u.displayName}}你好,你的账户【{{u.username}}】密码将在{{d}}天后过期，请在【个人中心】及时修改密码。请勿回复本邮件。",
                "尊敬的用户{{u.displayName}}你好,你账户【{{u.username}}】密码已过期，通过【忘记密码】流程重置密码。请勿回复本邮件。"
        );
        return expireMessage;
    }


    public static ExpireMessage template() {
        ExpireMessage expireMessage = buildFullExpireMessage(
                "密码过期通知，请勿回复",
                "尊敬的用户{{u.displayName}}你好,你的账户【{{u.username}}】密码将在{{d}}天后过期，请在【个人中心】及时修改密码。请勿回复本邮件。",
                "尊敬的用户{{u.displayName}}你好,你账户【{{u.username}}】密码已过期，通过【忘记密码】流程重置密码。请勿回复本邮件。",
                "尊敬的用户【{{u.username}}】你好,你的账户密码将在{{d}}天后过期，请及时修改密码。请勿回复本短信。",
                "尊敬的用户【{{u.username}}】你好,你的账户密码已过期，通过【忘记密码】流程重置密码。请勿回复本短信。"
        );
        return expireMessage;
    }

    public String getSubject() {
        return subject;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public String getMessage() {
        return message;
    }

    public String getExpiredMessage() {
        return expiredMessage;
    }

    public String getExpiredSmsContent() {
        return expiredSmsContent;
    }

}
