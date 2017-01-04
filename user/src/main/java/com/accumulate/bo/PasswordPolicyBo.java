package com.accumulate.bo;

import com.accumulate.bo.password.*;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

/**
 * Created by tjwang on 2017/1/4.
 */
public class PasswordPolicyBo extends BaseBo {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Valid
    private General general;
    @Valid
    private Constraint constraint;
    @Valid
    private Expiration expiration;
    @Valid
    private ExpireMessage expireMessage;
    @Valid
    private Retry retry;

    private PasswordPolicyBo() {
    }

    public PasswordPolicyBo(General general,
                          Constraint constraint,
                          Expiration expiration,
                          ExpireMessage expireMessage,
                          Retry retry
    ) {
        this.general = general;
        this.constraint = constraint;
        this.expiration = expiration;
        this.expireMessage = expireMessage;
        this.retry = retry;
    }

    /**
     * 取得密码约策略束提示信息
     *
     * @return
     */
    public PolicyTip policyTip() {
        if (getGeneral().isEnable()) {
            return new PolicyTip(getConstraint().getTip());
        } else {
            return PolicyTip.pass();
        }
    }

    /**
     * 检测密码是否满足密码策略
     *
     * @param password
     * @return
     */
    public PolicyTip check(String password) {
        if (!getGeneral().isEnable()) {
            return PolicyTip.pass();
        }
        PolicyTip.Items items = new PolicyTip.Items();
        items = items.add(getGeneral().check(password))
                .add(getConstraint().check(password));
        return items.stop();
    }

    public static PasswordPolicyBo buildDefault() {
        return new PasswordPolicyBo(General.buildDefault(),
                Constraint.buildDefault(),
                Expiration.buildDefault(),
                ExpireMessage.buildDefault(),
                Retry.buildDefault());
    }

    /**
     * 构建管理员密码策略
     *
     * @return
     */
    public static PasswordPolicyBo buildAdminPasswordPolicy() {
        return new PasswordPolicyBo(General.buildDefault(),
                new Constraint(6, 20, 3, true, 1, true, 1, true, 1, true, 1, true),
                Expiration.buildDefault(),
                ExpireMessage.buildDefault(),
                Retry.buildDefault());
    }

    /**
     * 是否过期
     *
     * @param lastDate
     * @return
     */
    public boolean isExpiration(DateTime lastDate) {
        if (null == lastDate) {
            return false;
        }
        if (null == getExpiration()) {
            return false;
        }
        int d = Days.daysBetween(lastDate, DateTime.now()).getDays();
        // 最后一次修改时间与当前时间的差
        if (logger.isDebugEnabled()) {
            logger.debug("d -> {}", d);
        }
        return d >= getExpiration().getExpiredDay();
    }


    /**
     * 判断是否需要通知
     *
     * @param lastDate
     * @return
     */
    public boolean notification(DateTime lastDate) {
        logger.debug("lastDate = {}", lastDate);
        if (null == lastDate) {
            return true;
        }
        if (null == getGeneral()) {
            return false;
        }
        if (!getGeneral().isEnable()) {
            return false;
        }
        if (null == getExpiration()) {
            return false;
        }
        // 当前时间与最后一次修改密码时间相差多少天
        int d = Days.daysBetween(lastDate, DateTime.now()).getDays();
        logger.debug("d -> {} day", d);
        // 自密码修改过多少天后通知
        return d >= (getExpiration().getExpiredDay() - getExpiration().getWaringBeforeDay());
    }

    /**
     * 计算即将过期天数
     *
     * @param lastDate
     * @return
     */
    public int notificationDay(DateTime lastDate) {
        if (null == lastDate) {
            return 0;
        }
        // 当前时间与最后一次修改密码时间相差多少天
        int d = Days.daysBetween(lastDate, DateTime.now()).getDays();
        logger.debug("d1 -> {} day", d);
        d = this.getExpiration().getExpiredDay() - d;
        logger.debug("d -> {} day", d);
        return d;
    }

    /**
     * 告警提示
     *
     * @param lastDate
     * @return
     */
    public ExpirationTip expirationTip(DateTime lastDate) {
        if (null == lastDate) {
            return new ExpirationTip(30, 0, ExpirationTip.Status.normal);
        }
        // 当前距离上次修改，已过时间（天）
        int lastDay = Days.daysBetween(lastDate, DateTime.now()).getDays();
        // 过期时间
        int d = getExpiration().getExpiredDay() - lastDay;
        // 安全
        int safe = getExpiration().getExpiredDay() - getExpiration().getWaringBeforeDay();
        if (lastDay < safe) {
            return new ExpirationTip(d, lastDay, ExpirationTip.Status.normal);
        }
        // 已经过期
        if (lastDay >= getExpiration().getExpiredDay()) {
            return new ExpirationTip(Math.abs(d), lastDay, ExpirationTip.Status.overdue);
        }
        return new ExpirationTip(d, lastDay, ExpirationTip.Status.waring);
    }


    public General getGeneral() {
        return general;
    }

    public void setGeneral(General general) {
        this.general = general;
    }

    public Constraint getConstraint() {
        return constraint;
    }

    public void setConstraint(Constraint constraint) {
        this.constraint = constraint;
    }

    public Expiration getExpiration() {
        return expiration;
    }

    public void setExpiration(Expiration expiration) {
        this.expiration = expiration;
    }

    public ExpireMessage getExpireMessage() {
        return expireMessage;
    }

    public void setExpireMessage(ExpireMessage expireMessage) {
        this.expireMessage = expireMessage;
    }

    public Retry getRetry() {
        return retry;
    }

    public void setRetry(Retry retry) {
        this.retry = retry;
    }
}
