package com.accumulate.service;

import com.accumulate.dto.PasswordPolicyConfigCreateDto;
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
    int save(PasswordPolicyConfigCreateDto dto);

    /**
     * 查询密码配置
     * @param id
     * @return
     */
    PasswordPolicyConfigDto findById(Integer id);

    /**
     * 查找激活的密码策略
     * @return
     */
    PasswordPolicyConfigDto findEnabled();

    /**
     * 从数据库删除
     * @param id
     */
    void delete(int id);

}
