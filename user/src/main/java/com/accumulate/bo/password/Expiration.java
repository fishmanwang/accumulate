package com.accumulate.bo.password;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 密码过期配置
 * Created by tjwang on 2017/1/4.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Expiration {

    @Min(value = 1, message = "过期时间最小为{value}")
    @Max(value = 100, message = "过期时间最大为{value}")
    private int expiredDay = 30;

    @Min(value = 1, message = "过期警告时间最小为{value}")
    @Max(value = 100, message = "过期警告时间最大为{value}")
    private int waringBeforeDay = 10;

    private ExpiredWaringAction action = ExpiredWaringAction.EMAIL;

    private Expiration() {
    }

    public Expiration(int expiredDay, int waringBeforeDay, ExpiredWaringAction action) {
        if (waringBeforeDay > expiredDay) {
            throw new IllegalArgumentException("过期警告时间超过了过期时间");
        }
        this.expiredDay = expiredDay;
        this.waringBeforeDay = waringBeforeDay;

        this.action = action;
    }

    public static Expiration buildDefault() {
        Expiration expiration = new Expiration(30, 10, ExpiredWaringAction.EMAIL);
        return expiration;
    }

    /**
     * 过期时间
     *
     * @return
     */
    public int getExpiredDay() {
        return expiredDay;
    }

    /**
     * 告警前时间
     *
     * @return
     */
    public int getWaringBeforeDay() {
        return waringBeforeDay;
    }

    /**
     * 告警动作
     *
     * @return
     */
    public ExpiredWaringAction getAction() {
        return action;
    }

}
