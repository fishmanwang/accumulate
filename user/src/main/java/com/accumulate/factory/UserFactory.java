package com.accumulate.factory;

import com.accumulate.entity.UserEntity;

/**
 * Created by tjwang on 2017/1/11.
 */
public class UserFactory {

    private UserFactory() {

    }

    public static UserFactory instance() {
        return new UserFactory();
    }

    public UserEntity create(String username, String password) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
//        user.setPassword();
        return null;
    }

}
