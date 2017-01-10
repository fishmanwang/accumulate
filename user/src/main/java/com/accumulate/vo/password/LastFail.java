package com.accumulate.vo.password;

import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

/**
 * 最后一次失败信息。登录失败后，生成该信息。
 * Created by tjwang on 2017/1/4.
 */
public class LastFail {
    private static final long serialVersionUID = -6334962433963162074L;

    @NotNull
    private int num = 0;

    @NotNull
    private DateTime lastUpdate = DateTime.now();

    private LastFail() {
    }

    public LastFail(int num, DateTime lastUpdate) {
        this.num = num;
        this.lastUpdate = lastUpdate;
    }

    public int getNum() {
        return num;
    }

    public DateTime getLastUpdate() {
        return lastUpdate;
    }
}
