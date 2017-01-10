package com.accumulate.service;

import com.accumulate.base.BaseTest;
import com.accumulate.entity.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by tjwang on 2017/1/3.
 */
public class UserServiceTest extends BaseTest {

    private static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Resource
    private UserService userService;

    @Test
    public void add() {
        Date now = new Date();

        User user = new User();
        user.setUsername("wang");
        user.setPassword("123456");
        user.setCreateBy(0);
        user.setCreateTime(now);
        user.setUpdateBy(0);
        user.setUpdateTime(now);
        userService.create(user);
        logger.debug("id : " + user.getId());

        user = new User();
        user.setUsername("chen");
        user.setPassword("111111");
        user.setPassword("123456");
        user.setCreateBy(0);
        user.setCreateTime(now);
        user.setUpdateBy(0);
        user.setUpdateTime(now);
        userService.create(user);
        logger.debug("id : " + user.getId());
    }

}
