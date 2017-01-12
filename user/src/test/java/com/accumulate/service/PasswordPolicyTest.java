package com.accumulate.service;

import com.accumulate.service.password.Expiration;
import com.accumulate.factory.PasswordPolicyFactory;
import com.accumulate.service.password.PasswordPolicy;
import com.accumulate.utils.ObjectUtils;
import com.accumulate.vo.password.ExpirationTip;
import com.accumulate.vo.password.PolicyTip;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;

import static junit.framework.Assert.*;

/**
 * 密码策略测试
 * Created by tjwang on 2017/1/10.
 */
public class PasswordPolicyTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private PasswordPolicy pp = null;

    @Before
    public void before() {
        pp = PasswordPolicyFactory.createDefaut();
    }

    /**
     * 校验正确的密码
     */
    @Test
    public void testCorrect() {
        String pwd = "Aa123.";
        PolicyTip tip = pp.check(pwd);
        assertTrue(tip.isPass());
    }

    /**
     * 密码长度不足6位，其他满足
     */
    @Test
    public void testLengthMinViolate() {
        assertEquals(6, pp.getConstraint().getMin().intValue());

        String pwd = "Aa12.";
        PolicyTip tip = pp.check(pwd);
        assertEquals("密码长度不足6位", tip.getTip());
        assertFalse(tip.isPass());
    }

    /**
     * 密码长度超过20位，其他满足
     */
    @Test
    public void testLengthMaxViolate() {
        assertEquals(20, pp.getConstraint().getMax().intValue());

        String pwd = "Aa12.bcdefghijklmnopqrstsfe";
        PolicyTip tip = pp.check(pwd);
        logger.debug(tip.getTip());
        assertEquals("密码长度超过20位", tip.getTip());
        assertFalse(tip.isPass());
    }

    /**
     * 最大重复次数测试
     */
    @Test
    public void testMaxRepeatCharacterViolate() {
        assertEquals(3, pp.getConstraint().getMaxRepeatCharacter().intValue());

        String pwd = "Aa12.aaa";
        PolicyTip tip = pp.check(pwd);
        logger.debug(tip.getTip());
        assertEquals("字符 a 重复出现4次，超过3次", tip.getTip());
        assertFalse(tip.isPass());
    }

    /**
     * 最少特殊字符次数测试
     */
    @Test
    public void testMinNonAlphanumericViolate() {
        assertEquals(1, pp.getConstraint().getMinNonAlphanumeric().intValue());

        String pwd = "Aa123b";
        PolicyTip tip = pp.check(pwd);
        logger.debug(tip.getTip());
        assertEquals("至少包含1位特殊字符", tip.getTip());
        assertFalse(tip.isPass());
    }

    /**
     * 最少数字次数测试
     */
    @Test
    public void testMinDigitsViolate() {
        assertEquals(1, pp.getConstraint().getMinDigits().intValue());

        String pwd = "Aa.asdf";
        PolicyTip tip = pp.check(pwd);
        logger.debug(tip.getTip());
        assertEquals("至少包含1位数字", tip.getTip());
        assertFalse(tip.isPass());
    }

    /**
     * 最少小写字母次数测试
     */
    @Test
    public void testMinLowercaseViolate() {
        assertEquals(1, pp.getConstraint().getMinLowercase().intValue());

        String pwd = "AA123.";
        PolicyTip tip = pp.check(pwd);
        logger.debug(tip.getTip());
        assertEquals("至少包含1位小写字母", tip.getTip());
        assertFalse(tip.isPass());
    }

    /**
     * 最少大写字母次数测试
     */
    @Test
    public void testMinUppercaseViolate() {
        assertEquals(1, pp.getConstraint().getMinUppercase().intValue());

        String pwd = "aa123.";
        PolicyTip tip = pp.check(pwd);
        logger.debug(tip.getTip());
        assertEquals("至少包含1位大写字母", tip.getTip());
        assertFalse(tip.isPass());
    }

    /**
     * 测试允许包含空格
     */
    @Test
    public void testAllowBlank() {
        assertFalse(pp.getConstraint().getNoBlank());

        String pwd = "Aa1 23.";
        PolicyTip tip = pp.check(pwd);
        logger.debug(tip.getTip());
        assertTrue(tip.isPass());
    }

    /**
     * 测试不允许包含空格
     */
    @Test
    public void testNotBlankViolate() {
        pp.getConstraint().setNoBlank(true);

        String pwd = "Aa1 23.";
        PolicyTip tip = pp.check(pwd);
        logger.debug(tip.getTip());
        assertEquals("密码中包含有空字符", tip.getTip());
        assertFalse(tip.isPass());
    }

    /**
     * 测试不允许包含空格通过
     */
    @Test
    public void testNotAllowBlankViolate() {
        pp.getConstraint().setNoBlank(true);

        String pwd = "Aa123.";
        PolicyTip tip = pp.check(pwd);
        logger.debug(tip.getTip());
        assertTrue(tip.isPass());
    }

    /**
     * 测试密码包含于黑名单
     */
    @Test
    public void testBannedSetViolate() {
        pp.setBanned(true);
        pp.getConstraint().setMinLowercase(0);
        pp.getConstraint().setMinUppercase(0);
        pp.getConstraint().setMinDigits(0);
        pp.getConstraint().setMinNonAlphanumeric(0);

        String pwd = "123456";
        PolicyTip tip = pp.check(pwd);
        logger.debug(tip.getTip());
        assertEquals("密码已列入黑名单", tip.getTip());
        assertFalse(tip.isPass());
    }

    /**
     * 测试关闭黑名单，密码属于黑名单
     */
    @Test
    public void testBannedDisabled() {
        pp.setBanned(false);
        pp.getConstraint().setMinLowercase(0);
        pp.getConstraint().setMinUppercase(0);
        pp.getConstraint().setMinDigits(0);
        pp.getConstraint().setMinNonAlphanumeric(0);

        String pwd = "123456";
        PolicyTip tip = pp.check(pwd);
        logger.debug(tip.getTip());
        assertTrue(tip.isPass());
    }

    /**
     * 测试开启黑名单，但无黑名单
     */
    @Test
    public void testNonBanned() {
        pp.setBanned(true);
        pp.setBannedSet(new HashSet<String>());
        pp.getConstraint().setMinLowercase(0);
        pp.getConstraint().setMinUppercase(0);
        pp.getConstraint().setMinDigits(0);
        pp.getConstraint().setMinNonAlphanumeric(0);

        String pwd = "Aa123456.jd";
        PolicyTip tip = pp.check(pwd);
        logger.debug(tip.getTip());
        assertTrue(tip.isPass());
    }

    /**
     * 测试开启黑名单，密码中包含黑名单中德项
     */
    @Test
    public void testBannedWordViolate() {
        pp.setBanned(true);
        pp.getConstraint().setMinLowercase(0);
        pp.getConstraint().setMinUppercase(0);
        pp.getConstraint().setMinDigits(0);
        pp.getConstraint().setMinNonAlphanumeric(0);

        String pwd = "Aa123456.jd";
        PolicyTip tip = pp.check(pwd);
        logger.debug(tip.getTip());
        assertEquals("密码中【123456】已列入黑名单", tip.getTip());
        assertFalse(tip.isPass());
    }

    /**
     * 测试密码策略约束提示
     */
    @Test
    public void testPolicyTip() {
        pp.setEnable(false);
        PolicyTip tip = pp.policyTip();
        assertTrue(tip.isPass());

        tip = pp.check("Aa123.");
        assertTrue(tip.isPass());

        pp.setEnable(true);
        tip = pp.policyTip();
        logger.debug(tip.getTip());
        assertEquals("为保证安全，密码有以下限制：最小长度6，最大长度20，最多包含3个重复字符，至少包含1位特殊字符(如:!@&*,.)，至少包含1位数字，至少包含1位小写字母，至少包含1位大写字母。", tip.getTip());

        pp.setConstraint(null);
        tip = pp.policyTip();
        assertTrue(tip.isPass());
    }

    /**
     * 过期测试
     */
    @Test
    public void testExpired() {
        Expiration expiration = pp.getExpiration();
        expiration.setEnable(true);
        expiration.setExpiredDay(30);

        //测试已过期
        DateTime lastDate = DateTime.now().minusDays(31); //最后一次修改时间，应该小于当前时间
        boolean expired = pp.isExpired(lastDate);
        assertTrue(expired);

        // 测试未过期
        lastDate = DateTime.now().minusDays(29);
        expired = pp.isExpired(lastDate);
        assertFalse(expired);

        // 已过期，未激活
        expiration.setEnable(false);
        lastDate = DateTime.now().minusDays(31);
        expired = pp.isExpired(lastDate);
        assertFalse(expired);

        // lastDate为空
        expiration.setEnable(true);
        expired = pp.isExpired(null);
        assertFalse(expired);

        // 密码策略未激活，超过30天
        pp.setEnable(false);
        lastDate = DateTime.now().minusDays(31);
        expired = pp.isExpired(lastDate);
        assertFalse(expired);

        // expiration不存在，超过30天
        pp.setEnable(true);
        pp.setExpiration(null);
        lastDate = DateTime.now().minusDays(31);
        expired = pp.isExpired(lastDate);
        assertFalse(expired);
    }

    /**
     * 测试是否需要通知用户过期
     */
    @Test
    public void testNeedNotification() {
        Expiration expiration = pp.getExpiration();
        expiration.setExpiredDay(30);
        expiration.setWaringBeforeDay(10);
        boolean notify;
        DateTime lastDate = null;

        // 不需要通知
        assertTrue(pp.getEnable());
        assertNotNull(pp.getExpiration());
        assertTrue(pp.getExpiration().getEnable());
        notify = pp.needNotification(null);
        assertFalse(notify);

        // 需要通知
        assertTrue(pp.getEnable());
        assertNotNull(pp.getExpiration());
        assertTrue(pp.getExpiration().getEnable());
        lastDate = DateTime.now().minusDays(20);
        notify = pp.needNotification(lastDate);
        assertTrue(notify);

        // 不需要通知
        assertTrue(pp.getEnable());
        assertNotNull(pp.getExpiration());
        assertTrue(pp.getExpiration().getEnable());
        lastDate = DateTime.now().minusDays(19);
        notify = pp.needNotification(lastDate);
        assertFalse(notify);

        // 不需要通知，expiration未激活
        assertTrue(pp.getEnable());
        assertNotNull(pp.getExpiration());
        expiration.setEnable(false);
        lastDate = DateTime.now().minusDays(20);
        notify = pp.needNotification(lastDate);
        assertFalse(notify);
        expiration.setEnable(true);

        // 不需要通知，密码策略未激活
        assertNotNull(pp.getExpiration());
        assertTrue(pp.getExpiration().getEnable());
        pp.setEnable(false);
        lastDate = DateTime.now().minusDays(20);
        notify = pp.needNotification(lastDate);
        assertFalse(notify);
        pp.setEnable(true);

        // 不需要通知，expiration不存在
        assertTrue(pp.getEnable());
        pp.setExpiration(null);
        lastDate = DateTime.now().minusDays(20);
        notify = pp.needNotification(lastDate);
        assertFalse(notify);
    }

    /**
     * 测试获取将过期天数
     */
    @Test
    public void testExpiringDay() {
        Expiration expiration = pp.getExpiration();
        expiration.setExpiredDay(30);
        expiration.setWaringBeforeDay(10);
        int days = 0;
        DateTime lastDate = null;

        // 过期天数为0
        days = pp.getExpiringDay(lastDate);
        assertEquals(0, days);

        // 过期天数为5
        lastDate = DateTime.now().minusDays(25);
        days = pp.getExpiringDay(lastDate);
        assertEquals(5, days);

        lastDate = DateTime.now().minusDays(31);
        days = pp.getExpiringDay(lastDate);
        assertEquals(0, days);
    }

    /**
     * 测试获取将过期信息
     */
    @Test
    public void testExpiringTip() {
        Expiration expiration = pp.getExpiration();
        expiration.setExpiredDay(30);
        expiration.setWaringBeforeDay(10);
        ExpirationTip tip = null;
        DateTime lastDate = null;

        // 将过期
        lastDate = DateTime.now().minusDays(25);
        tip = pp.getExpirationTip(lastDate);
        logger.debug(ObjectUtils.toString(tip));
        assertEquals(5, tip.getD());
        assertEquals(ExpirationTip.Status.waring, tip.getStatus());

        // 未过期
        lastDate = DateTime.now().minusDays(19);
        tip = pp.getExpirationTip(lastDate);
        logger.debug(ObjectUtils.toString(tip));
        assertEquals(11, tip.getD());
        assertEquals(ExpirationTip.Status.normal, tip.getStatus());

        // 未过期,参数为空
        tip = pp.getExpirationTip(null);
        logger.debug(ObjectUtils.toString(tip));
        assertEquals(30, tip.getD());
        assertEquals(ExpirationTip.Status.normal, tip.getStatus());

        // 已过期
        lastDate = DateTime.now().minusDays(31);
        tip = pp.getExpirationTip(lastDate);
        logger.debug(ObjectUtils.toString(tip));
        assertEquals(1, tip.getD());
        assertEquals(ExpirationTip.Status.overdue, tip.getStatus());
    }
}
