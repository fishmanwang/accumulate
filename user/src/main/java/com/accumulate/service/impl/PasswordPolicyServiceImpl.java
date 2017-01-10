package com.accumulate.service.impl;

import com.accumulate.dto.*;
import com.accumulate.entity.*;
import com.accumulate.exception.ApplicationException;
import com.accumulate.exception.UserErrorCode;
import com.accumulate.mapper.PasswordPolicyConfigMapper;
import com.accumulate.mapper.PasswordPolicyConstraintMapper;
import com.accumulate.mapper.PasswordPolicyExpirationMapper;
import com.accumulate.mapper.PasswordPolicyRetryMapper;
import com.accumulate.service.PasswordPolicyService;
import com.accumulate.utils.ObjectUtils;
import com.accumulate.utils.StringUtils;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
                constraintMapper.insert(constraint);
            } else {
                logger.debug("update constraint");
                int count = constraintMapper.updateByPrimaryKey(constraint);
                if (count == 0) {
                    throw new ApplicationException(UserErrorCode.PASSWORD_POLICY_CONSTRAINT_NOT_EXIST, id);
                }
            }
            passwordPolicy.setConstraintId(constraint.getId());
        }

        PasswordPolicyExpirationDto expirationDto = dto.getExpiration();
        if (expirationDto != null) {
            PasswordPolicyExpiration expiration = expirationDto.transfer();
            Integer id = expirationDto.getId();
            if (id == null) {
                logger.debug("insert expiration");
                expirationMapper.insert(expiration);
            } else {
                logger.debug("update expiration");
                int count = expirationMapper.updateByPrimaryKey(expiration);
                if (count == 0) {
                    throw new ApplicationException(UserErrorCode.PASSWORD_POLICY_EXPIRATION_NOT_EXIST, id);
                }
            }
            passwordPolicy.setExpirationId(expiration.getId());
        }

        PasswordPolicyRetryDto retryDto = dto.getRetry();
        if (retryDto != null) {
            PasswordPolicyRetry retry = retryDto.transfer();
            Integer id = retryDto.getId();
            if (id == null) {
                logger.debug("insert retry");
                retryMapper.insert(retry);
            } else {
                logger.debug("update retry");
                int count = retryMapper.updateByPrimaryKey(retry);
                if (count == 0) {
                    throw new ApplicationException(UserErrorCode.PASSWORD_POLICY_RETRY_NOT_EXIST, id);
                }
            }
            passwordPolicy.setRetryId(retry.getId());
        }

        if (dto.getId() == null) {
            logger.debug("insert password policy");
            configMapper.insert(passwordPolicy);
        } else {
            logger.debug("update password policy");
            configMapper.updateByPrimaryKey(passwordPolicy);
        }

        return passwordPolicy.getId();
    }

    public PasswordPolicyConfigDto findById(Integer id) {
        Preconditions.checkArgument(id != null);
        PasswordPolicyConfig config = configMapper.selectByPrimaryKey(id);
        if (config == null) {
            throw new ApplicationException(UserErrorCode.PASSWORD_POLICY_CONFIG_NOT_EXIST, id);
        }

        PasswordPolicyConfigDto configDto = buildPasswordPolicyConfigDto(config);

        return configDto;
    }

    @Override
    public PasswordPolicyConfigDto findEnabled() {
        PasswordPolicyConfigExample ex = new PasswordPolicyConfigExample();
        PasswordPolicyConfigExample.Criteria c = ex.createCriteria();
        c.andEnableEqualTo(true);
        List<PasswordPolicyConfig> coll = configMapper.selectByExample(ex);
        if (coll == null || coll.isEmpty()) {
            throw new ApplicationException(UserErrorCode.PASSWORD_POLICY_CONFIG_ENABLED_NOT_EXIST);
        }

        if (coll.size() > 1) {
            throw new ApplicationException(UserErrorCode.PASSWORD_POLICY_CONFIG_ENABLED_MORE_THAN_ONE);
        }

        PasswordPolicyConfigDto configDto = buildPasswordPolicyConfigDto(coll.get(0));

        return configDto;
    }

    /**
     * 通过PasswordPolicyConfig构建PasswordPolicyConfigDto
     * @param config
     * @return
     */
    private PasswordPolicyConfigDto buildPasswordPolicyConfigDto(PasswordPolicyConfig config) {
        PasswordPolicyConfigDto configDto = PasswordPolicyConfigDto.build(config);

        Integer constraintId = config.getConstraintId();
        if (constraintId != null && constraintId != 0) {
            PasswordPolicyConstraint constraint = findConstraint(constraintId);
            PasswordPolicyConstraintDto dto = PasswordPolicyConstraintDto.build(constraint);
            configDto.setConstraint(dto);
        }

        Integer expirationId = config.getExpirationId();
        if (expirationId != null && expirationId != 0) {
            PasswordPolicyExpiration expiration = findExpiration(expirationId);
            PasswordPolicyExpirationDto dto = PasswordPolicyExpirationDto.build(expiration);
            configDto.setExpiration(dto);
        }

        Integer retryId = config.getRetryId();
        if (retryId != null && retryId != 0) {
            PasswordPolicyRetry retry = findRetry(retryId);
            PasswordPolicyRetryDto dto = PasswordPolicyRetryDto.build(retry);
            configDto.setRetry(dto);
        }

        return configDto;
    }

    private PasswordPolicyConstraint findConstraint(Integer constraintId) {
        PasswordPolicyConstraint constraint = constraintMapper.selectByPrimaryKey(constraintId);
        if (constraint == null) {
            throw new ApplicationException(UserErrorCode.PASSWORD_POLICY_CONSTRAINT_NOT_EXIST, constraintId);
        }
        return constraint;
    }

    private PasswordPolicyExpiration findExpiration(Integer expirationId) {
        PasswordPolicyExpiration expiration = expirationMapper.selectByPrimaryKey(expirationId);
        if (expiration == null) {
            throw new ApplicationException(UserErrorCode.PASSWORD_POLICY_EXPIRATION_NOT_EXIST, expirationId);
        }
        return expiration;
    }

    private PasswordPolicyRetry findRetry(Integer retryId) {
        PasswordPolicyRetry retry = retryMapper.selectByPrimaryKey(retryId);
        if (retry == null) {
            throw new ApplicationException(UserErrorCode.PASSWORD_POLICY_RETRY_NOT_EXIST, retryId);
        }
        return retry;
    }

    @Transactional
    @Override
    public void delete(int id) {
        PasswordPolicyConfig config = configMapper.selectByPrimaryKey(id);
        if (config == null) {
            return ;
        }
        // constraintId,expirationId,retryId默认为0，所以不需要判空
        constraintMapper.deleteByPrimaryKey(config.getConstraintId());
        expirationMapper.deleteByPrimaryKey(config.getExpirationId());
        retryMapper.deleteByPrimaryKey(config.getRetryId());
    }

}
