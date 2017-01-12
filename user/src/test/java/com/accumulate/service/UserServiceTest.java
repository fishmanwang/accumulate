package com.accumulate.service;

import com.accumulate.base.BaseTest;
import com.accumulate.dto.user.UserDto;
import com.accumulate.entity.UserEntity;
import com.accumulate.utils.ObjectUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by tjwang on 2017/1/3.
 */
@Transactional
public class UserServiceTest extends BaseTest {

    private static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Resource
    private UserService userService;

    @Test
    @Ignore
    public void add() {
        Date now = new Date();

        UserEntity user = new UserEntity();
        user.setUsername("wang");
        user.setPassword("123456");
        user.setCreateBy(0);
        user.setCreateTime(now);
        user.setUpdateBy(0);
        user.setUpdateTime(now);
        userService.create(user);
        logger.debug("id : " + user.getId());

        user = new UserEntity();
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

    @Test
    @Rollback
    public void testRegister() {
        String username = "wang";
        String password = "Aa123.";

        userService.deleteByUsername(username);

        userService.register(username, password);
    }

    @Test
    public void testFindByUsername() {
        String username = "wang";
        UserDto user = userService.findByUsername(username);
        assertNotNull(user);
        logger.debug(ObjectUtils.toString(user));
    }

}
