package com.accumulate.mapper;

import com.accumulate.entity.UserEntity;

/**
 * Created by tjwang on 2017/1/3.
 */
public interface UserMapper {

    void save(UserEntity user);

    void update(UserEntity user);

    UserEntity find(String id);

    void delete(String id);

}
