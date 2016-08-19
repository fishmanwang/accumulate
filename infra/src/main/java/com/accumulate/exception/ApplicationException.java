package com.accumulate.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjwang on 2016/8/18.
 */
public class ApplicationException extends RuntimeException {

    /**
     * 系统错误代码
     */
    private ErrorCode errorCode;

    /**
     * 当验证产生问题时，记录字段和错误原因的键值对
     */
    private List<ValidationError> validationErrors = new ArrayList<ValidationError>();

    @Override
    public String toString() {
        if (errorCode.equals(CommonErrorCode.VALIDATION_EXCEPTION)) {
            String additionMsg = "";
            for (ValidationError v : getValidationErrors()) {
                additionMsg = additionMsg + "\n" + v;
            }
            return super.toString() + additionMsg;
        }

        return errorCode.getMessage();
    }

    public ApplicationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApplicationException(ErrorCode errorCode, Throwable ex) {
        super(errorCode.getMessage(), ex);
        this.errorCode = errorCode;
    }

    public ApplicationException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ApplicationException(ErrorCode errorCode, String message, Throwable ex) {
        super(message,ex);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<ValidationError> errors) {
        this.validationErrors = errors;
    }

}
