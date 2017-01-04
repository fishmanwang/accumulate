package com.accumulate.service.impl;

import com.accumulate.bo.PasswordPolicyBo;
import com.accumulate.mapper.PasswordPolicyMapper;
import com.accumulate.service.PasswordPolicyService;

import javax.annotation.Resource;

/**
 * Created by tjwang on 2017/1/4.
 */
public class PasswordPolicyServiceImpl implements PasswordPolicyService {

    @Resource
    PasswordPolicyMapper passwordPolicyMapper;

    @Override
    public int save(PasswordPolicyBo bo) {

        return 0;
    }

}
