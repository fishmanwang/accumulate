package com.accumulate.service;

import com.accumulate.base.BaseTest;
import com.accumulate.dto.PasswordPolicyConfigDto;
import com.accumulate.helpers.PasswordPolicyHelper;
import com.accumulate.utils.ObjectUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;

/**
 * Created by tjwang on 2017/1/4.
 */
public class PasswordPolicyServiceTest extends BaseTest {

    private static Logger logger = LoggerFactory.getLogger(PasswordPolicyServiceTest.class);

    @Resource
    private PasswordPolicyService passwordPolicyService;

    @Test
    @Ignore
    public void buildDefaultPasswordConfig() {
        PasswordPolicyConfigDto dto = PasswordPolicyHelper.buildDefaultConfigDto();
        int id = passwordPolicyService.save(dto);
        assertNotNull(id);
    }

    @Test
    public void testFindById() {
        Integer id = 1;
        PasswordPolicyConfigDto config = passwordPolicyService.findById(id);
        logger.info(ObjectUtils.toString(config));
        assertNotNull(config);

    }

    @Test
    public void testFindDefault() {
        PasswordPolicyConfigDto config = passwordPolicyService.findDefault();
        logger.info(ObjectUtils.toString(config));
        assertNotNull(config);
    }

}
