package com.accumulate.base;

import com.accumulate.exception.ValidationError;

import java.util.List;

/**
 * 错误信息。系统出错后，封装错误信息。结合RestResult使用。
 * Created by tjwang on 2016/9/15.
 */
public class ErrorData {

    // TODO stack信息很长，为了减少传入前端的消息长度。应该设置开关，灵活配置是否开启stack信息。开发时可以打开，生产环境关闭。
    private String shortStack;

    private String fullStack;

    private String errorMsg;

    private Integer errorCode;

    private List<ValidationError> validationErrors;

    public String getShortStack() {
        return shortStack;
    }

    public void setShortStack(String shortStack) {
        this.shortStack = shortStack;
    }

    public String getFullStack() {
        return fullStack;
    }

    public void setFullStack(String fullStack) {
        this.fullStack = fullStack;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }

}
