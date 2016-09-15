package com.accumulate.base;

/**
 * 所有rest接口统一返回格式
 * Created by tjwang on 2016/8/19.
 */
public class RestResult<T> extends BaseDTO {

    private ResultCode code;

    private T data;

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

    public static <T> RestResult<T> fail(T data) {
        RestResult result = new RestResult();
        result.setCode(ResultCode.ERROR);
        result.setData(data);
        return result;
    }

    public static <T> RestResult<T> fail(ResultCode code, T data) {
        RestResult result = new RestResult();
        result.setCode(code);
        result.setData(data);
        return result;
    }

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
