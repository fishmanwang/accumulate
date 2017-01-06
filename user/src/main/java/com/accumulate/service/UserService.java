package com.accumulate.service;

import com.accumulate.entity.User;

/**
 * 用户服务
 * Created by tjwang on 2017/1/3.
 */
public interface UserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    int create(User user);

}
