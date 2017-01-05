package com.accumulate.service;

import com.accumulate.base.BaseTest;
import com.accumulate.dto.PasswordPolicyConfigDto;
import com.accumulate.helpers.PasswordPolicyHelper;
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
    public void buildDefaultPasswordConfig() {
        PasswordPolicyConfigDto dto = PasswordPolicyHelper.buildDefaultConfigDto();
        int id = passwordPolicyService.save(dto);
        assertNotNull(id);
    }

    /*public static void main(String[] args) {
        PasswordPolicyBo bo = PasswordPolicyBo.buildDefault();

        logger.info(bo.toString());
    }*/

}
