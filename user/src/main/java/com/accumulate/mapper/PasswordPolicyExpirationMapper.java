package com.accumulate.mapper;

import com.accumulate.entity.PasswordPolicyExpiration;
import com.accumulate.entity.PasswordPolicyExpirationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PasswordPolicyExpirationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    long countByExample(PasswordPolicyExpirationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    int deleteByExample(PasswordPolicyExpirationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    int insert(PasswordPolicyExpiration record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    int insertSelective(PasswordPolicyExpiration record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    List<PasswordPolicyExpiration> selectByExample(PasswordPolicyExpirationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    PasswordPolicyExpiration selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    int updateByExampleSelective(@Param("record") PasswordPolicyExpiration record, @Param("example") PasswordPolicyExpirationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    int updateByExample(@Param("record") PasswordPolicyExpiration record, @Param("example") PasswordPolicyExpirationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    int updateByPrimaryKeySelective(PasswordPolicyExpiration record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    int updateByPrimaryKey(PasswordPolicyExpiration record);
}