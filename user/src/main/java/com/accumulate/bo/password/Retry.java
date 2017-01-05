package com.accumulate.bo.password;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.DateTime;
import org.joda.time.Seconds;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 重试配置
 * Created by tjwang on 2017/1/4.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Retry {

    @NotNull
    private boolean enabled = true;

    @Min(value = 1, message = "重试次数最小为{value}")
    @Max(value = 10, message = "重试次数最大为{value}")
    private int num = 3;

    @Min(value = 1, message = "锁定时间最小为{value}")
    @Max(value = 24 * 60, message = "锁定时间最大为{value}")
    private long lockTime = 2;

    private Retry() {
    }

    public Retry(boolean enabled, int num, long lockTime) {
        this.enabled = enabled;
        this.num = num;
        this.lockTime = lockTime;
    }

    public boolean isOpen() {
        return enabled;
    }

    public int getNum() {
        return num;
    }

    public long getLockTime() {
        return lockTime;
    }

    public static Retry buildDefault() {
        return new Retry(true, 3, 2);
    }

    /**
     * 判断账户是否锁定
     *
     * @param lastFail
     * @return
     */
    public boolean isLock(LastFail lastFail) {
        if (!this.isOpen()) {
            return false;
        }
        if (lastFail == null || lastFail.getLastUpdate() == null) {
            return false;
        }
        // 相差时间（秒）
        Seconds v = Seconds.secondsBetween(lastFail.getLastUpdate(), DateTime.now());
        return v.getSeconds() < getLockTime() * 60 && lastFail.getNum() >= this.getNum();
    }

    /**
     * 剩余次数
     *
     * @param lastFail
     * @return
     */
    public int remainingNum(LastFail lastFail) {
        if (lastFail == null) {
            return 0;
        }
        int num = this.getNum() - lastFail.getNum();
        if (num > 0) {
            return num;
        } else {
            return 0;
        }
    }

    /**
     * 剩余时间
     *
     * @param lastFail
     * @return
     */
    public long remainingTime(LastFail lastFail) {
        if (lastFail == null) {
            return this.getLockTime();
        }
        // 相差时间（秒）
        Seconds v = Seconds.secondsBetween(lastFail.getLastUpdate(), DateTime.now());
        return this.getLockTime() * 60 - v.getSeconds();
    }

}
