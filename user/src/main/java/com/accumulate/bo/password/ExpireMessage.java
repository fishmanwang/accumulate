package com.accumulate.bo.password;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Size;

/**
 * 失效信息配置
 * Created by tjwang on 2017/1/4.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExpireMessage {

    private String from;

    private String fromAlias;

    private String email;

    @Size(min = 0, max = 20, message = "邮件主题模板必须为{min}到{max}个字符")
    private String subject;

    // 将要过期
    @Size(min = 0, max = 200, message = "邮件内容必须为{min}到{max}个字符")
    private String message;

    @Size(min = 0, max = 200, message = "过期邮件内容必须为{min}到{max}个字符")
    private String expiredMessage;

    private String mobile;

    @Size(min = 0, max = 200, message = "短信内容必须为{min}到{max}个字符")
    private String smsContent;

    @Size(min = 0, max = 200, message = "过期短信内容必须为{min}到{max}个字符")
    private String expiredSmsContent;

    private ExpireMessage() {
    }

    /**
     * 构造邮件过期信息
     * @param from
     * @param fromAlias
     * @param email
     * @param subject
     * @param message
     * @param expiredMessage
     * @return
     */
    public static ExpireMessage buildEmailExpireMessage(String from, String fromAlias, String email, String subject, String message, String expiredMessage) {
        ExpireMessage m = new ExpireMessage();
        m.from = from;
        m.fromAlias = fromAlias;
        m.email = email;
        m.subject = subject;
        m.message = message;
        m.expiredMessage = expiredMessage;
        return m;
    }

    public static ExpireMessage buildSmsExpireMessage(String mobile, String smsContent, String expiredSmsContent) {
        ExpireMessage m = new ExpireMessage();
        m.mobile = mobile;
        m.smsContent = smsContent;
        m.expiredMessage = expiredSmsContent;
        return m;
    }

    public static ExpireMessage buildFullExpireMessage(String from, String fromAlias, String email, String subject, String message, String expiredMessage, String mobile, String smsContent, String expiredSmsContent) {
        ExpireMessage m = new ExpireMessage();
        m.from = from;
        m.fromAlias = fromAlias;
        m.email = email;
        m.subject = subject;
        m.message = message;
        m.expiredMessage = expiredMessage;

        m.mobile = mobile;
        m.smsContent = smsContent;
        m.expiredSmsContent = expiredSmsContent;
        return m;
    }

    public static ExpireMessage buildDefault() {
        ExpireMessage expireMessage = buildEmailExpireMessage("ngiam@jingantech.com",
                "NGIAM",
                "{{u.email}}",
                "密码过期通知，请勿回复",
                "尊敬的用户{{u.displayName}}你好,你的账户【{{u.username}}】密码将在{{d}}天后过期，请在【个人中心】及时修改密码。请勿回复本邮件。",
                "尊敬的用户{{u.displayName}}你好,你账户【{{u.username}}】密码已过期，通过【忘记密码】流程重置密码。请勿回复本邮件。"
        );
        return expireMessage;
    }


    public static ExpireMessage template() {
        ExpireMessage expireMessage = buildFullExpireMessage("ngiam@jingantech.com",
                "NGIAM",
                "{{u.email}}",
                "密码过期通知，请勿回复",
                "尊敬的用户{{u.displayName}}你好,你的账户【{{u.username}}】密码将在{{d}}天后过期，请在【个人中心】及时修改密码。请勿回复本邮件。",
                "尊敬的用户{{u.displayName}}你好,你账户【{{u.username}}】密码已过期，通过【忘记密码】流程重置密码。请勿回复本邮件。",
                "{{u.mobile}}",
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

    public String getFrom() {
        return from;
    }

    public String getFromAlias() {
        return fromAlias;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public String getMobile() {
        return mobile;
    }

    public String getExpiredMessage() {
        return expiredMessage;
    }

    public String getExpiredSmsContent() {
        return expiredSmsContent;
    }

}
