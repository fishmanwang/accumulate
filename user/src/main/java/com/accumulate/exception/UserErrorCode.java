package com.accumulate.exception;

/**
 * Created by tjwang on 2017/1/5.
 */
public enum UserErrorCode implements ErrorCode {

    PASSOWRD_POLICY_CANT_BE_NULL(200, "密码策略不能为空"),
    PASSWORD_POLICY_CONFIG_NOT_EXIST(201, "Id为{0}的密码策略不存在"),
    PASSWORD_POLICY_CONSTRAINT_NOT_EXIST(202, "密码策略中Id为{0}的限制配置不存在"),
    PASSWORD_POLICY_EXPIRATION_NOT_EXIST(203, "密码策略中Id为{0}的过期配置不存在"),
    PASSWORD_POLICY_RETRY_NOT_EXIST(204, "密码策略中Id为{0}重试配置的不存在"),
    PASSWORD_POLICY_CONFIG_DEFAULT_NOT_EXIST(205, "默认密码策略不存在"),
    ;

    private UserErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
