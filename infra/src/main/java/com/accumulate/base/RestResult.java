package com.accumulate.base;

import java.util.List;

/**
 * Created by tjwang on 2016/8/19.
 */
public class RestResult<T> extends BaseDTO {

    private ResultCode code;

    private String message;

    private T data;

    private List<T> dataList;

    public static <T> RestResult<T> ok() {
        RestResult result = new RestResult();
        result.setCode(ResultCode.SUCCESS);
        return result;
    }

    public static <T> RestResult<T> ok(T data) {
        RestResult result = new RestResult();
        result.setCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static <T> RestResult<T> ok(List<T> dataList) {
        RestResult result = new RestResult();
        result.setCode(ResultCode.SUCCESS);
        result.setDataList(dataList);
        return result;
    }

    public static <T> RestResult<T> fail(ResultCode code) {
        RestResult result = new RestResult();
        result.setCode(code);
        return result;
    }

    public static <T> RestResult<T> fail(ResultCode code, String message) {
        RestResult result = new RestResult();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
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
