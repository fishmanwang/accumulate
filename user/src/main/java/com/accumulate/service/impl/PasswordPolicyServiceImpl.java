package com.accumulate.service.impl;

import com.accumulate.dto.PasswordPolicyConfigDto;
import com.accumulate.dto.PasswordPolicyConstraintDto;
import com.accumulate.dto.PasswordPolicyExpirationDto;
import com.accumulate.dto.PasswordPolicyRetryDto;
import com.accumulate.entity.PasswordPolicyConfig;
import com.accumulate.entity.PasswordPolicyConstraint;
import com.accumulate.entity.PasswordPolicyExpiration;
import com.accumulate.entity.PasswordPolicyRetry;
import com.accumulate.exception.ApplicationException;
import com.accumulate.exception.UserErrorCode;
import com.accumulate.mapper.PasswordPolicyConfigMapper;
import com.accumulate.mapper.PasswordPolicyConstraintMapper;
import com.accumulate.mapper.PasswordPolicyExpirationMapper;
import com.accumulate.mapper.PasswordPolicyRetryMapper;
import com.accumulate.service.PasswordPolicyService;
import com.accumulate.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by tjwang on 2017/1/4.
 */
@Service
public class PasswordPolicyServiceImpl implements PasswordPolicyService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private PasswordPolicyConfigMapper configMapper;

    @Resource
    private PasswordPolicyConstraintMapper constraintMapper;

    @Resource
    private PasswordPolicyExpirationMapper expirationMapper;

    @Resource
    private PasswordPolicyRetryMapper retryMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(PasswordPolicyConfigDto dto) {
        logger.debug(ObjectUtils.toString(dto));

        if (dto == null) {
            throw new ApplicationException(UserErrorCode.PASSOWRD_POLICY_CANT_BE_NULL);
        }

        PasswordPolicyConfig passwordPolicy = dto.transfer();

        PasswordPolicyConstraintDto constraintDto = dto.getConstraint();
        if (constraintDto != null) {
            PasswordPolicyConstraint constraint = constraintDto.transfer();
            Integer id = constraintDto.getId();
            if (id == null) {
                logger.debug("insert constraint");
                id = constraintMapper.insert(constraint);
            } else {
                logger.debug("update constraint");
                constraintMapper.updateByPrimaryKey(constraint);
            }
            passwordPolicy.setConstraintId(id);
        }

        PasswordPolicyExpirationDto expirationDto = dto.getExpiration();
        if (expirationDto != null) {
            PasswordPolicyExpiration expiration = expirationDto.transfer();
            Integer id = expirationDto.getId();
            if (id == null) {
                logger.debug("insert expiration");
                id = expirationMapper.insert(expiration);
            } else {
                logger.debug("update expiration");
                expirationMapper.updateByPrimaryKey(expiration);
            }
            passwordPolicy.setExpirationId(id);
        }

        PasswordPolicyRetryDto retryDto = dto.getRetry();
        if (retryDto != null) {
            PasswordPolicyRetry retry = retryDto.transfer();
            Integer id = retry.getId();
            if (id == null) {
                logger.debug("insert retry");
                id = retryMapper.insert(retry);
            } else {
                logger.debug("update retry");
                retryMapper.updateByPrimaryKey(retry);
            }
            passwordPolicy.setRetryId(id);
        }

        Integer id = dto.getId();
        if (id == null) {
            logger.debug("insert password policy");
            id = configMapper.insert(passwordPolicy);
        } else {
            logger.debug("update password policy");
            configMapper.updateByPrimaryKey(passwordPolicy);
        }

        return id;
    }

}
