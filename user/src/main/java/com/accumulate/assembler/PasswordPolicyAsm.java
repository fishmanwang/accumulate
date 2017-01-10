package com.accumulate.assembler;

import com.accumulate.aggregation.PasswordPolicy;
import com.accumulate.dto.PasswordPolicyDto;
import com.accumulate.factory.PasswordPolicyFactory;
import com.accumulate.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * 负责domain和dto的转换
 * Created by tjwang on 2017/1/10.
 */
public class PasswordPolicyAsm {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public PasswordPolicyDto transfer(PasswordPolicy pp) {
        logger.debug(ObjectUtils.toString(pp));

        PasswordPolicyDto dto = new PasswordPolicyDto();
        BeanUtils.copyProperties(pp, dto);

        PasswordPolicyDto.ConstraintDto constraint = new PasswordPolicyDto.ConstraintDto();
        BeanUtils.copyProperties(pp.getConstraint(), constraint);
        dto.setConstraint(constraint);

        PasswordPolicyDto.ExpirationDto expiration = new PasswordPolicyDto.ExpirationDto();
        BeanUtils.copyProperties(pp.getExpiration(), expiration);
        dto.setExpiration(expiration);

        logger.debug(ObjectUtils.toString(dto));
        return dto;
    }

    public static void main(String[] args) {
        PasswordPolicy pp = PasswordPolicyFactory.createDefaut();

        PasswordPolicyAsm asm = new PasswordPolicyAsm();
        PasswordPolicyDto dto = asm.transfer(pp);
    }

}
