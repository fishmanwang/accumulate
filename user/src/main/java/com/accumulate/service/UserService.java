package com.accumulate.service;

import com.accumulate.dto.user.UserDto;
import com.accumulate.entity.UserEntity;

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
    int create(UserEntity user);

    /**
     * 注册用户
     * @param username 用户名
     * @param password 密码
     */
    void register(String username, String password);

    /**
     * 通过用户名查询用户
     * @param username
     */
    UserDto findByUsername(String username);

    /**
     * 通过ID删除用户
     * @param id
     */
    void delete(int id);

    /**
     * 通过用户名删除用户
     * @param username
     */
    void deleteByUsername(String username);

}
