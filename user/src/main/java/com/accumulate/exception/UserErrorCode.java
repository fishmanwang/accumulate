package com.accumulate.exception;

/**
 * Created by tjwang on 2017/1/5.
 */
public enum UserErrorCode implements ErrorCode {

    PASSOWRD_POLICY_CANT_BE_NULL(200, "密码策略不能为空");

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
