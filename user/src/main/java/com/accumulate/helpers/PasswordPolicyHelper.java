package com.accumulate.helpers;

import com.accumulate.dto.PasswordPolicyConfigDto;
import com.accumulate.dto.PasswordPolicyConstraintDto;
import com.accumulate.dto.PasswordPolicyExpirationDto;
import com.accumulate.dto.PasswordPolicyRetryDto;

import java.util.Date;

/**
 * 密码策略工具类
 * Created by tjwang on 2017/1/5.
 */
public class PasswordPolicyHelper {

    /**
     * 需排除的密码
     */
    private static final String WEAK_PASSWORD_25 = "000000 111111 11111111 112233 123123 123321 123456 " +
            "12345678 654321 666666 888888 abcdef abcabc abc123 a1b2c3 aaa111 123qwe qwerty qweasd " +
            "admin password p@ssword passwd iloveyou 5201314";

    /**
     * 生成。默认enable为false，只能通过其它方法激活。
     */
    public static PasswordPolicyConfigDto buildDefaultConfigDto() {
        Date now = new Date();

        PasswordPolicyConfigDto config = new PasswordPolicyConfigDto();
        config.setEnable(false);
        config.setName("default");
        config.setDescription("默认密码策略");
        config.setBanned(true);
        config.setBannedUrl(WEAK_PASSWORD_25);
        config.setCreateBy(0);
        config.setCreateTime(now);
        config.setUpdateBy(0);
        config.setUpdateTime(now);

        PasswordPolicyConstraintDto constraint = buildDefaultConstraint();
        config.setConstraint(constraint);

        PasswordPolicyExpirationDto expiration = buildDefaultExpiration();
        config.setExpiration(expiration);

        PasswordPolicyRetryDto retry = buildDefaultRetry();
        config.setRetry(retry);

        return config;
    }

    public static PasswordPolicyConstraintDto buildDefaultConstraint() {
        PasswordPolicyConstraintDto constraint = new PasswordPolicyConstraintDto();
        constraint.setEnable(true);
        constraint.setMin(6);
        constraint.setMax(20);
        constraint.setMaxRepeatCharacter(3);
        constraint.setMinNonAlphanumeric(1);
        constraint.setMinDigits(1);
        constraint.setMinLowercase(1);
        constraint.setMinUppercase(1);
        constraint.setNotBlank(false);
        return constraint;
    }

    public static PasswordPolicyExpirationDto buildDefaultExpiration() {
        PasswordPolicyExpirationDto expiration = new PasswordPolicyExpirationDto();
        expiration.setEnable(true);
        expiration.setExpiredDay(30);
        expiration.setWaringBeforeDay(10);
        expiration.setWaringAction(1);
        expiration.setSubject("密码过期通知，请勿回复");
        expiration.setEmailExpiringMessage("尊敬的用户{{u.displayName}}你好,你的账户【{{u.username}}】密码将在{{d}}天后过期，请在【个人中心】及时修改密码。请勿回复本邮件。");
        expiration.setEmailExpiredMessage("尊敬的用户{{u.displayName}}你好,你账户【{{u.username}}】密码已过期，通过【忘记密码】流程重置密码。请勿回复本邮件。");
        expiration.setSmsExpiringMessage("尊敬的用户【{{u.username}}】你好,你的账户密码将在{{d}}天后过期，请及时修改密码。请勿回复本短信。");
        expiration.setSmsExpiredMessage("尊敬的用户【{{u.username}}】你好,你的账户密码已过期，通过【忘记密码】流程重置密码。请勿回复本短信。");
        return expiration;
    }

    public static PasswordPolicyRetryDto buildDefaultRetry() {
        PasswordPolicyRetryDto retry = new PasswordPolicyRetryDto();
        retry.setEnable(true);
        retry.setNum(5);
        retry.setLockTime(2);
        return retry;
    }

}
