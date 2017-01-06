package com.accumulate.domain;

import org.joda.time.DateTime;
import org.joda.time.Seconds;

/**
 * Created by tjwang on 2017/1/6.
 */
public class PasswordPolicyRetryDomain {

    private Integer id;

    private Boolean enable;

    private Integer num;

    private Integer lockTime;

    /**
     * 判断账户是否锁定
     *
     * @param lastFail
     * @return
     */
    public boolean isLock(LastFail lastFail) {
        if (!getEnable()) {
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getLockTime() {
        return lockTime;
    }

    public void setLockTime(Integer lockTime) {
        this.lockTime = lockTime;
    }
}
