package com.accumulate.service;

import com.accumulate.base.BaseTest;
import com.accumulate.dto.*;
import com.accumulate.entity.PasswordPolicyConfig;
import com.accumulate.exception.ApplicationException;
import com.accumulate.helpers.PasswordPolicyHelper;
import com.accumulate.mapper.PasswordPolicyConfigMapper;
import com.accumulate.utils.ObjectUtils;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by tjwang on 2017/1/4.
 */
@Transactional
@Rollback
public class PasswordPolicyServiceTest extends BaseTest {

    private static Logger logger = LoggerFactory.getLogger(PasswordPolicyServiceTest.class);

    @Resource
    private PasswordPolicyService passwordPolicyService;

    /**
     * 供测试造数据，不可直接用于逻辑
     */
    @Resource
    private PasswordPolicyConfigMapper configMapper;

    @Before
    public void before() {
        logger.debug("before");
    }

    @After
    public void after(){
        logger.debug("after");
    }

    @BeforeClass
    public static void beforeClass() {
        logger.debug("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        logger.debug("beforeClass");
    }

    private int prepareData() {
        PasswordPolicyConfigDto dto = buildCreateDto();
        return passwordPolicyService.save(dto);
    }

    @Test
    public void testBuildDefaultPasswordConfig() {
        int id = prepareData();
        assertNotNull(id);
    }

    @Test(expected = ApplicationException.class)
    public void testSaveNull() {
        PasswordPolicyConfigDto dto = null;
        int id = passwordPolicyService.save(dto);
        assertNotNull(id);
    }

    @Test
    public void testFindById() {
        int id = prepareData();

        PasswordPolicyConfigDto config = passwordPolicyService.findById(id);
        logger.info(ObjectUtils.toString(config));
        assertNotNull(config);
    }

    /**
     * 查询的ID在数据库中不存在
     */
    @Test(expected = ApplicationException.class)
    public void testFindNotExistsConfig() {
        passwordPolicyService.findById(-1);
    }


    /**
     * 测试constaint不存在
     */
    @Test
    public void testFindByIdWithoutConstraint() {
        PasswordPolicyConfigDto dto = buildCreateDto();
        dto.setName("no-constraint");
        dto.setConstraint(null);
        int id = passwordPolicyService.save(dto);
        PasswordPolicyConfigDto config = passwordPolicyService.findById(id);
        assertNotNull(config);
        assertNull(config.getConstraint());
    }

    /**
     * 测试expiration不存在
     */
    @Test
    public void testFindByIdWithoutExpiration() {
        PasswordPolicyConfigDto dto = buildCreateDto();
        dto.setName("no-expiration");
        dto.setExpiration(null);
        int id = passwordPolicyService.save(dto);
        PasswordPolicyConfigDto config = passwordPolicyService.findById(id);
        assertNotNull(config);
        assertNull(config.getExpiration());
    }

    /**
     * 测试retry不存在
     */
    @Test
    public void testFindByIdWithoutRetry() {
        PasswordPolicyConfigDto dto = buildCreateDto();
        dto.setName("no-retry");
        dto.setRetry(null);
        int id = passwordPolicyService.save(dto);
        PasswordPolicyConfigDto config = passwordPolicyService.findById(id);
        assertNotNull(config);
        assertNull(config.getRetry());
    }

    /**
     * 测试密码策略包含不存在的constraintId
     */
    @Test(expected = ApplicationException.class)
    public void testFindConfigWithWrongConstraint() {
        int id = prepareData();
        PasswordPolicyConfigDto dto = passwordPolicyService.findById(id);

        PasswordPolicyConfig config = dto.transfer();
        config.setConstraintId(-1);
        configMapper.updateByPrimaryKey(config);

        passwordPolicyService.findById(id);
    }

    /**
     * 测试密码策略包含不存在的expirationId
     */
    @Test(expected = ApplicationException.class)
    public void testFindConfigWithWrongExpiration() {
        int id = prepareData();
        PasswordPolicyConfigDto dto = passwordPolicyService.findById(id);

        PasswordPolicyConfig config = dto.transfer();
        config.setExpirationId(-2);
        configMapper.updateByPrimaryKey(config);

        passwordPolicyService.findById(id);
    }

    /**
     * 测试密码策略包含不存在的retry
     */
    @Test(expected = ApplicationException.class)
    public void testFindConfigWithWrongRetry() {
        int id = prepareData();
        PasswordPolicyConfigDto dto = passwordPolicyService.findById(id);

        PasswordPolicyConfig config = dto.transfer();
        config.setRetryId(-3);
        configMapper.updateByPrimaryKey(config);

        passwordPolicyService.findById(id);
    }

    /**
     * 查询默认密码策略
     */
    @Test
    public void testFindDefault() {
        prepareData();

        PasswordPolicyConfigDto config = passwordPolicyService.findEnabled();
        logger.info(ObjectUtils.toString(config));
        assertNotNull(config);
    }

    /**
     * 查询激活密码策略，该策略在数据库中不存在
     */
    @Test(expected = ApplicationException.class)
    public void testFindNotExistsDefault() {
        passwordPolicyService.findEnabled();
    }

    /**
     * 查询激活密码策略，激活策略大于一条
     */
    @Test(expected = ApplicationException.class)
    public void testDuplicateDefault() {
        PasswordPolicyConfigDto dto = PasswordPolicyHelper.buildDefaultConfigDto();
        passwordPolicyService.findEnabled();
    }

    /**
     * 测试删除密码策略及相关数据
     */
    @Test
    public void testDelete() {
        int id = prepareData();
        passwordPolicyService.delete(id);
    }

    /**
     * 测试删除不存在的密码策略
     */
    @Test
    public void testDeleteNotExisist() {
        passwordPolicyService.delete(-1);
    }

    /**
     * 更新密码策略本身。
     */
    @Test
    public void testUpdateConfig() {
        int id = prepareData();
        PasswordPolicyConfigDto config = passwordPolicyService.findById(id);

        Date now = new Date();
        config.setEnable(false);
        config.setName("test");
        config.setDescription("测试");
        config.setBanned(false);
        config.setBannedUrl("123");
        config.setCreateBy(100);
        config.setCreateTime(now);
        config.setUpdateBy(100);
        config.setUpdateTime(now);

        config.setConstraint(null);
        config.setExpiration(null);
        config.setRetry(null);

        passwordPolicyService.save(config);

        PasswordPolicyConfigDto c = passwordPolicyService.findById(id);

        assertEquals(config.getEnable(), c.getEnable());
        assertEquals(config.getName(), c.getName());
        assertEquals(config.getDescription(), c.getDescription());
        assertEquals(config.getBanned(), c.getBanned());
        assertEquals(config.getBannedUrl(), c.getBannedUrl());
        assertEquals(config.getCreateBy(), c.getCreateBy());
        //assertSame(config.getCreateTime().getTime(), c.getCreateTime().getTime());
        assertEquals(config.getUpdateBy(), c.getUpdateBy());
        //assertSame(config.getUpdateTime().getTime(), c.getUpdateTime().getTime());
        assertNull(c.getConstraint());
        assertNull(c.getExpiration());
        assertNull(c.getRetry());
    }

    /**
     * 更新constraint
     */
    @Test
    public void testUpdateConstraint() {
        int id = prepareData();
        PasswordPolicyConfigDto config = passwordPolicyService.findById(id);

        PasswordPolicyConstraintDto constraint = config.getConstraint();
        constraint.setId(null);

        constraint.setEnable(false);
        constraint.setMin(8);
        constraint.setMax(30);
        constraint.setMaxRepeatCharacter(5);
        constraint.setMinNonAlphanumeric(2);
        constraint.setMinDigits(2);
        constraint.setMinLowercase(3);
        constraint.setMinUppercase(4);
        constraint.setNotBlank(true);

        config.setConstraint(constraint);
        passwordPolicyService.save(config);

        PasswordPolicyConfigDto newConfig = passwordPolicyService.findById(id);
        PasswordPolicyConstraintDto c = newConfig.getConstraint();
        assertEquals(constraint.getEnable(), c.getEnable());
        assertEquals(constraint.getMin(), c.getMin());
        assertEquals(constraint.getMax(), c.getMax());
        assertEquals(constraint.getMaxRepeatCharacter(), c.getMaxRepeatCharacter());
        assertEquals(constraint.getMinNonAlphanumeric(), c.getMinNonAlphanumeric());
        assertEquals(constraint.getMinDigits(), c.getMinDigits());
        assertEquals(constraint.getMinLowercase(), c.getMinLowercase());
        assertEquals(constraint.getMinUppercase(), c.getMinUppercase());
        assertEquals(constraint.getNotBlank(), c.getNotBlank());
    }

    /**
     * 更新expiration
     */
    @Test
    public void testUpdateExpiration() {
        int id = prepareData();
        PasswordPolicyConfigDto config = passwordPolicyService.findById(id);

        PasswordPolicyExpirationDto expiration = config.getExpiration();
        expiration.setId(null);
        expiration.setEnable(false);
        expiration.setExpiredDay(60);
        expiration.setWaringBeforeDay(20);
        expiration.setWaringAction(2);
        expiration.setSubject("aaa");
        expiration.setEmailExpiringMessage("bbb");
        expiration.setEmailExpiredMessage("ccc");
        expiration.setSmsExpiringMessage("ddd");
        expiration.setSmsExpiredMessage("eee");

        config.setExpiration(expiration);
        passwordPolicyService.save(config);

        PasswordPolicyConfigDto newConfig = passwordPolicyService.findById(id);
        PasswordPolicyExpirationDto e = newConfig.getExpiration();
        assertEquals(expiration.getEnable(), e.getEnable());
        assertEquals(expiration.getExpiredDay(), e.getExpiredDay());
        assertEquals(expiration.getWaringBeforeDay(), e.getWaringBeforeDay());
        assertEquals(expiration.getWaringAction(), e.getWaringAction());
        assertEquals(expiration.getSubject(), e.getSubject());
        assertEquals(expiration.getEmailExpiringMessage(), e.getEmailExpiringMessage());
        assertEquals(expiration.getEmailExpiredMessage(), e.getEmailExpiredMessage());
        assertEquals(expiration.getSmsExpiringMessage(), e.getSmsExpiringMessage());
        assertEquals(expiration.getSmsExpiredMessage(), e.getSmsExpiredMessage());
    }

    /**
     * 更新retry
     */
    @Test
    public void testUpdateRetry() {
        int id = prepareData();
        PasswordPolicyConfigDto config = passwordPolicyService.findById(id);

        PasswordPolicyRetryDto retry = config.getRetry();
        retry.setId(null);
        retry.setEnable(false);
        retry.setNum(10);
        retry.setLockTime(5);
        config.setRetry(retry);
        passwordPolicyService.save(config);

        PasswordPolicyConfigDto newConfig = passwordPolicyService.findById(id);
        PasswordPolicyRetryDto r = newConfig.getRetry();
        assertEquals(retry.getEnable(), r.getEnable());
        assertEquals(retry.getNum(), r.getNum());
        assertEquals(retry.getLockTime(), r.getLockTime());

    }

    /**
     * 测试修改id不存在的constraint
     */
    @Test(expected = ApplicationException.class)
    public void testSaveNotExistConstaint() {
        int id = prepareData();
        PasswordPolicyConfigDto config = passwordPolicyService.findById(id);

        PasswordPolicyConstraintDto constraint = config.getConstraint();
        constraint.setId(-1);
        config.setConstraint(constraint);

        passwordPolicyService.save(config);
    }

    /**
     * 测试修改id不存在的expiration
     */
    @Test(expected = ApplicationException.class)
    public void testSaveNotExistExpiration() {
        int id = prepareData();
        PasswordPolicyConfigDto config = passwordPolicyService.findById(id);

        PasswordPolicyExpirationDto expiration = config.getExpiration();
        expiration.setId(-1);
        config.setExpiration(expiration);

        passwordPolicyService.save(config);
    }

    /**
     * 测试修改id不存在的retry
     */
    @Test(expected = ApplicationException.class)
    public void testSaveNotExistRetry() {
        int id = prepareData();
        PasswordPolicyConfigDto config = passwordPolicyService.findById(id);

        PasswordPolicyRetryDto retry = config.getRetry();
        retry.setId(-1);
        config.setRetry(retry);

        passwordPolicyService.save(config);
    }

    private PasswordPolicyConfigDto buildCreateDto() {
        String WEAK_PASSWORD_25 = "000000 111111 11111111 112233 123123 123321 123456 " +
                "12345678 654321 666666 888888 abcdef abcabc abc123 a1b2c3 aaa111 123qwe qwerty qweasd " +
                "admin password p@ssword passwd iloveyou 5201314";

        Date now = new Date();

        PasswordPolicyConfigDto createDto = new PasswordPolicyConfigDto();
        createDto.setName("default");
        createDto.setDescription("默认密码策略");
        createDto.setBanned(true);
        createDto.setBannedUrl(WEAK_PASSWORD_25);
        createDto.setCreateBy(0);
        createDto.setCreateTime(now);
        createDto.setUpdateBy(0);
        createDto.setUpdateTime(now);

        PasswordPolicyConstraintDto constraint = PasswordPolicyHelper.buildDefaultConstraint();
        createDto.setConstraint(constraint);

        PasswordPolicyExpirationDto expiration = PasswordPolicyHelper.buildDefaultExpiration();
        createDto.setExpiration(expiration);

        PasswordPolicyRetryDto retry = PasswordPolicyHelper.buildDefaultRetry();
        createDto.setRetry(retry);

        return createDto;
    }


}
