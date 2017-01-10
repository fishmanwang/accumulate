package com.accumulate.Assembler;

import com.accumulate.aggregation.PasswordPolicy;
import com.accumulate.dto.PasswordPolicyConfigDto;
import com.accumulate.factory.PasswordPolicyFactory;
import com.accumulate.utils.ObjectUtils;

/**
 * 负责domain和dto的转换
 * Created by tjwang on 2017/1/10.
 */
public class PasswordAsm {

    public PasswordPolicyConfigDto transfer(PasswordPolicy pp) {
        PasswordPolicyConfigDto dto = new PasswordPolicyConfigDto();
        return dto;
    }

    public static void main(String[] args) {
        PasswordPolicy pp = PasswordPolicyFactory.createDefaut();
        System.out.println(ObjectUtils.toString(pp));
    }

}
