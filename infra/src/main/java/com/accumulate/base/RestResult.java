package com.accumulate.base;

import java.util.List;

/**
 * Created by tjwang on 2016/8/19.
 */
public class RestResult<T> extends BaseDTO {

    private boolean success;

    private String message;

    private T data;

    private List<T> dataList;

    public static <T> RestResult<T> ok() {
        RestResult result = new RestResult();
        result.setSuccess(true);
        return result;
    }

    public static <T> RestResult<T> ok(T data) {
        RestResult result = new RestResult();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> RestResult<T> ok(List<T> dataList) {
        RestResult result = new RestResult();
        result.setSuccess(true);
        result.setDataList(dataList);
        return result;
    }

    public static <T> RestResult<T> fail() {
        RestResult result = new RestResult();
        result.setSuccess(false);
        return result;
    }

    public static <T> RestResult<T> fail(String message) {
        RestResult result = new RestResult();
        result.setSuccess(false);
        result.setMessage(message);
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
