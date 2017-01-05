package com.accumulate.service;

import com.accumulate.dto.PasswordPolicyConfigDto;

/**
 * Created by tjwang on 2017/1/4.
 */
public interface PasswordPolicyService {
    /**
     * 保存密码策略
     * @param dto
     * @return
     */
    int save(PasswordPolicyConfigDto dto);

    /**
     * 查询密码配置
     * @param id
     * @return
     */
    PasswordPolicyConfigDto findById(Integer id);

    /**
     * 查找默认密码策略
     * @return
     */
    PasswordPolicyConfigDto findDefault();

}
