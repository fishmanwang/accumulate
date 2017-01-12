package com.accumulate.service.authentication;

import com.accumulate.entity.UserEntity;
import com.accumulate.service.UserService;
import com.accumulate.utils.ValidatorHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PwdAuthenticator extends AbstractAuthenticator<UserLoginPwdCredential>  {

    @Resource
    private UserService userService;

    @Override
    protected UserEntity exchangeByCredential(UserLoginPwdCredential credential) {
        ValidatorHelper.validate(credential);

        String username = credential.getSubject();

        userService.findByUsername(username);

        return null;
    }

}
