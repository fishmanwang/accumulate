package com.accumulate.service.impl;

import com.accumulate.entity.User;
import com.accumulate.mapper.UserMapper;
import com.accumulate.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户服务实现
 * Created by tjwang on 2017/1/3.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int create(User user) {
        logger.debug("Execute UserService.add");
        return userMapper.insert(user);
    }

}
