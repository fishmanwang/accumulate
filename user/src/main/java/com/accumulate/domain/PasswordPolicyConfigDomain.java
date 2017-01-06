package com.accumulate.domain;

import com.accumulate.domain.check.BannedConstraintCheck;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by tjwang on 2017/1/6.
 */
public class PasswordPolicyConfigDomain {

    private Logger logger = LoggerFactory.getLogger(PasswordPolicyConfigDomain.class);

    private Integer id;

    private String name;

    private String description;

    private Boolean enable;

    private Boolean banned;

    private String bannedUrl;

    private PasswordPolicyConstraintDomain constraint;

    private PasswordPolicyExpirationDomain expiration;

    private PasswordPolicyRetryDomain retry;

    private Date createTime;

    private Integer createBy;

    private Date updateTime;

    private Integer updateBy;

    /**
     * 检测密码是否满足密码策略
     *
     * @param password
     * @return
     */
    public PolicyTip check(String password) {
        if (!getEnable()) {
            return PolicyTip.pass();
        }
        PolicyTip.Items items = new PolicyTip.Items();
        items = items.add(checkBanned(password))
                .add(getConstraint().check(password));
        return items.stop();
    }

    /**
     * 取得密码约策略束提示信息
     *
     * @return
     */
    public PolicyTip policyTip() {
        if (getEnable()) {
            if (getConstraint() == null || !getConstraint().getEnable()) {
                return PolicyTip.pass();
            }
            return new PolicyTip(getConstraint().getTip());
        } else {
            return PolicyTip.pass();
        }
    }

    /**
     * 校验黑名单
     * @param password
     * @return
     */
    public PolicyTip checkBanned(String password) {
        if (getBanned()) {
            BannedConstraintCheck bannedConstraintCheck = new BannedConstraintCheck(bannedUrl);
            return bannedConstraintCheck.check(password);
        }
        return PolicyTip.pass();
    }

    /**
     * 判断密码是否已过期
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
    public boolean needNotification(DateTime lastDate) {
        logger.debug("lastDate = {}", lastDate);
        if (null == lastDate) {
            return true;
        }
        if (!getEnable()) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    public String getBannedUrl() {
        return bannedUrl;
    }

    public void setBannedUrl(String bannedUrl) {
        this.bannedUrl = bannedUrl;
    }

    public PasswordPolicyConstraintDomain getConstraint() {
        return constraint;
    }

    public void setConstraint(PasswordPolicyConstraintDomain constraint) {
        this.constraint = constraint;
    }

    public PasswordPolicyExpirationDomain getExpiration() {
        return expiration;
    }

    public void setExpiration(PasswordPolicyExpirationDomain expiration) {
        this.expiration = expiration;
    }

    public PasswordPolicyRetryDomain getRetry() {
        return retry;
    }

    public void setRetry(PasswordPolicyRetryDomain retry) {
        this.retry = retry;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }
}
