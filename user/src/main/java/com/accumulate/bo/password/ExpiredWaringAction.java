package com.accumulate.bo.password;

/**
 * 密码过期通知方式
 * Created by tjwang on 2017/1/4.
 */
public enum ExpiredWaringAction {

    EMAIL("email", "电子邮件"),
    SMS("sms", "短信");

    private String code;
    private String name;

    private ExpiredWaringAction(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
