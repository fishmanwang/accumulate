package com.accumulate.mapper;

import com.accumulate.entity.PasswordPolicyConfig;
import com.accumulate.entity.PasswordPolicyConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PasswordPolicyConfigMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_config
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    long countByExample(PasswordPolicyConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_config
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    int deleteByExample(PasswordPolicyConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_config
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_config
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    int insert(PasswordPolicyConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_config
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    int insertSelective(PasswordPolicyConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_config
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    List<PasswordPolicyConfig> selectByExample(PasswordPolicyConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_config
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    PasswordPolicyConfig selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_config
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    int updateByExampleSelective(@Param("record") PasswordPolicyConfig record, @Param("example") PasswordPolicyConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_config
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    int updateByExample(@Param("record") PasswordPolicyConfig record, @Param("example") PasswordPolicyConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_config
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    int updateByPrimaryKeySelective(PasswordPolicyConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_config
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    int updateByPrimaryKey(PasswordPolicyConfig record);
}