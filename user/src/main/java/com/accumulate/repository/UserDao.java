package com.accumulate.repository;

import com.accumulate.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by tjwang on 2016/8/10.
 */
public interface UserDao extends MongoRepository<UserEntity, String> {

    UserEntity findByName(String name);

}
