package com.accumulate.service;

import com.accumulate.base.BaseTest;
import com.accumulate.entity.User;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by tjwang on 2017/1/3.
 */
public class UserServiceTest extends BaseTest {

    @Resource
    private UserService userService;

    @Test
    public void add() {
        User user = new User();
        user.setName("wang");
        user.setAge((short) 30);
        user.setPassword("123456");
        userService.add(user);
    }

}
