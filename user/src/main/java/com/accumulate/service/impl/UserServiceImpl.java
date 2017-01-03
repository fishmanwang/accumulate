package com.accumulate.service.impl;

import com.accumulate.entity.User;
import com.accumulate.mapper.UserMapper;
import com.accumulate.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by tjwang on 2017/1/3.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserMapper userMapper;


    @Override
    public void add(User user) {
        logger.debug("Execute UserService.add");
        userMapper.insert(user);
    }
}
