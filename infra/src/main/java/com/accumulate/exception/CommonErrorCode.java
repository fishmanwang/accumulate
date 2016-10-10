package com.accumulate.exception;

/**
 * Created by tjwang on 2016/8/18.
 */
public enum CommonErrorCode implements ErrorCode {

    SYSTEM(1, "系统异常"),
    INVALID_CONFIG(2, "配置错误"),
    SYSTEM_CLASS_NOT_FOUND(3, "无法加载class:{0}"),
    VALIDATION_EXCEPTION(4, "数据校验异常"),

    /**扩展属性*/
    APP_ATTR_TYPE_NOT_EXISTS(100, "不存在的自定义属性类型")
    ;

    private int code;
    private String message;

    private CommonErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
