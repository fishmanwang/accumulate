package com.accumulate.exception;

/**
 * Created by tjwang on 2016/8/18.
 */
public enum CommonErrorCode implements ErrorCode {

    SYSTEM(1, "系统异常"),
    INVALID_CONFIG(2, "配置错误"),
    SYSTEM_CLASS_NOT_FOUND(3, "无法加载class:{0}"),
    VALIDATION_ERROR(4, "数据校验异常"),

    //日期错误代码定义1000-1100
    DATE_ILLEGAL_FORMAT(1000, "日期{0}的格式非法"),
    DATE_FORMAT_ERROR(1001, "字符串{0}无法转换成格式为{1}的日期"),
    DATE_START_NULL(1002, "开始时间不能为空"),
    DATE_END_NULL(1003, "结束时间不能为空"),
    DATE_END_LESSTHAN_NOW(1004, "结束时间{0}不能小于当前时间"),
    DATE_END_BEFORE_START(1005, "开始时间{0}必须早于结束时间{1}"),
    DATE_RANGE_OVERSTEP_DAYS(1006, "开始时间{0}和结束时间{1}范围不能超过{2}天"),
    DATE_RANGE_LESSTHAN_DAYS(1007, "开始时间{0}和结束时间{1}范围不能小于{2}天"),
    ;

    private int code;
    private String message;

    private CommonErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
