package com.accumulate.service;

import com.accumulate.base.BaseTest;
import com.accumulate.bo.PasswordPolicyBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tjwang on 2017/1/4.
 */
public class PasswordPolicyServiceTest extends BaseTest {

    private static Logger logger = LoggerFactory.getLogger(PasswordPolicyServiceTest.class);

    public static void main(String[] args) {
        PasswordPolicyBo bo = PasswordPolicyBo.buildDefault();

        logger.info(bo.toString());
    }

}
