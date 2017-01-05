package com.accumulate.entity;

import java.util.ArrayList;
import java.util.List;

public class PasswordPolicyExpirationExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    public PasswordPolicyExpirationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Boolean value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Boolean value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Boolean value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Boolean value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Boolean value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Boolean> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Boolean> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Boolean value1, Boolean value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enable not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andExpiredDayIsNull() {
            addCriterion("expired_day is null");
            return (Criteria) this;
        }

        public Criteria andExpiredDayIsNotNull() {
            addCriterion("expired_day is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredDayEqualTo(Integer value) {
            addCriterion("expired_day =", value, "expiredDay");
            return (Criteria) this;
        }

        public Criteria andExpiredDayNotEqualTo(Integer value) {
            addCriterion("expired_day <>", value, "expiredDay");
            return (Criteria) this;
        }

        public Criteria andExpiredDayGreaterThan(Integer value) {
            addCriterion("expired_day >", value, "expiredDay");
            return (Criteria) this;
        }

        public Criteria andExpiredDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("expired_day >=", value, "expiredDay");
            return (Criteria) this;
        }

        public Criteria andExpiredDayLessThan(Integer value) {
            addCriterion("expired_day <", value, "expiredDay");
            return (Criteria) this;
        }

        public Criteria andExpiredDayLessThanOrEqualTo(Integer value) {
            addCriterion("expired_day <=", value, "expiredDay");
            return (Criteria) this;
        }

        public Criteria andExpiredDayIn(List<Integer> values) {
            addCriterion("expired_day in", values, "expiredDay");
            return (Criteria) this;
        }

        public Criteria andExpiredDayNotIn(List<Integer> values) {
            addCriterion("expired_day not in", values, "expiredDay");
            return (Criteria) this;
        }

        public Criteria andExpiredDayBetween(Integer value1, Integer value2) {
            addCriterion("expired_day between", value1, value2, "expiredDay");
            return (Criteria) this;
        }

        public Criteria andExpiredDayNotBetween(Integer value1, Integer value2) {
            addCriterion("expired_day not between", value1, value2, "expiredDay");
            return (Criteria) this;
        }

        public Criteria andWaringBeforeDayIsNull() {
            addCriterion("waring_before_day is null");
            return (Criteria) this;
        }

        public Criteria andWaringBeforeDayIsNotNull() {
            addCriterion("waring_before_day is not null");
            return (Criteria) this;
        }

        public Criteria andWaringBeforeDayEqualTo(Integer value) {
            addCriterion("waring_before_day =", value, "waringBeforeDay");
            return (Criteria) this;
        }

        public Criteria andWaringBeforeDayNotEqualTo(Integer value) {
            addCriterion("waring_before_day <>", value, "waringBeforeDay");
            return (Criteria) this;
        }

        public Criteria andWaringBeforeDayGreaterThan(Integer value) {
            addCriterion("waring_before_day >", value, "waringBeforeDay");
            return (Criteria) this;
        }

        public Criteria andWaringBeforeDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("waring_before_day >=", value, "waringBeforeDay");
            return (Criteria) this;
        }

        public Criteria andWaringBeforeDayLessThan(Integer value) {
            addCriterion("waring_before_day <", value, "waringBeforeDay");
            return (Criteria) this;
        }

        public Criteria andWaringBeforeDayLessThanOrEqualTo(Integer value) {
            addCriterion("waring_before_day <=", value, "waringBeforeDay");
            return (Criteria) this;
        }

        public Criteria andWaringBeforeDayIn(List<Integer> values) {
            addCriterion("waring_before_day in", values, "waringBeforeDay");
            return (Criteria) this;
        }

        public Criteria andWaringBeforeDayNotIn(List<Integer> values) {
            addCriterion("waring_before_day not in", values, "waringBeforeDay");
            return (Criteria) this;
        }

        public Criteria andWaringBeforeDayBetween(Integer value1, Integer value2) {
            addCriterion("waring_before_day between", value1, value2, "waringBeforeDay");
            return (Criteria) this;
        }

        public Criteria andWaringBeforeDayNotBetween(Integer value1, Integer value2) {
            addCriterion("waring_before_day not between", value1, value2, "waringBeforeDay");
            return (Criteria) this;
        }

        public Criteria andWaringActionIsNull() {
            addCriterion("waring_action is null");
            return (Criteria) this;
        }

        public Criteria andWaringActionIsNotNull() {
            addCriterion("waring_action is not null");
            return (Criteria) this;
        }

        public Criteria andWaringActionEqualTo(Integer value) {
            addCriterion("waring_action =", value, "waringAction");
            return (Criteria) this;
        }

        public Criteria andWaringActionNotEqualTo(Integer value) {
            addCriterion("waring_action <>", value, "waringAction");
            return (Criteria) this;
        }

        public Criteria andWaringActionGreaterThan(Integer value) {
            addCriterion("waring_action >", value, "waringAction");
            return (Criteria) this;
        }

        public Criteria andWaringActionGreaterThanOrEqualTo(Integer value) {
            addCriterion("waring_action >=", value, "waringAction");
            return (Criteria) this;
        }

        public Criteria andWaringActionLessThan(Integer value) {
            addCriterion("waring_action <", value, "waringAction");
            return (Criteria) this;
        }

        public Criteria andWaringActionLessThanOrEqualTo(Integer value) {
            addCriterion("waring_action <=", value, "waringAction");
            return (Criteria) this;
        }

        public Criteria andWaringActionIn(List<Integer> values) {
            addCriterion("waring_action in", values, "waringAction");
            return (Criteria) this;
        }

        public Criteria andWaringActionNotIn(List<Integer> values) {
            addCriterion("waring_action not in", values, "waringAction");
            return (Criteria) this;
        }

        public Criteria andWaringActionBetween(Integer value1, Integer value2) {
            addCriterion("waring_action between", value1, value2, "waringAction");
            return (Criteria) this;
        }

        public Criteria andWaringActionNotBetween(Integer value1, Integer value2) {
            addCriterion("waring_action not between", value1, value2, "waringAction");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andEmailExpiringMessageIsNull() {
            addCriterion("email_expiring_message is null");
            return (Criteria) this;
        }

        public Criteria andEmailExpiringMessageIsNotNull() {
            addCriterion("email_expiring_message is not null");
            return (Criteria) this;
        }

        public Criteria andEmailExpiringMessageEqualTo(String value) {
            addCriterion("email_expiring_message =", value, "emailExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiringMessageNotEqualTo(String value) {
            addCriterion("email_expiring_message <>", value, "emailExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiringMessageGreaterThan(String value) {
            addCriterion("email_expiring_message >", value, "emailExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiringMessageGreaterThanOrEqualTo(String value) {
            addCriterion("email_expiring_message >=", value, "emailExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiringMessageLessThan(String value) {
            addCriterion("email_expiring_message <", value, "emailExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiringMessageLessThanOrEqualTo(String value) {
            addCriterion("email_expiring_message <=", value, "emailExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiringMessageLike(String value) {
            addCriterion("email_expiring_message like", value, "emailExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiringMessageNotLike(String value) {
            addCriterion("email_expiring_message not like", value, "emailExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiringMessageIn(List<String> values) {
            addCriterion("email_expiring_message in", values, "emailExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiringMessageNotIn(List<String> values) {
            addCriterion("email_expiring_message not in", values, "emailExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiringMessageBetween(String value1, String value2) {
            addCriterion("email_expiring_message between", value1, value2, "emailExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiringMessageNotBetween(String value1, String value2) {
            addCriterion("email_expiring_message not between", value1, value2, "emailExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiredMessageIsNull() {
            addCriterion("email_expired_message is null");
            return (Criteria) this;
        }

        public Criteria andEmailExpiredMessageIsNotNull() {
            addCriterion("email_expired_message is not null");
            return (Criteria) this;
        }

        public Criteria andEmailExpiredMessageEqualTo(String value) {
            addCriterion("email_expired_message =", value, "emailExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiredMessageNotEqualTo(String value) {
            addCriterion("email_expired_message <>", value, "emailExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiredMessageGreaterThan(String value) {
            addCriterion("email_expired_message >", value, "emailExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiredMessageGreaterThanOrEqualTo(String value) {
            addCriterion("email_expired_message >=", value, "emailExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiredMessageLessThan(String value) {
            addCriterion("email_expired_message <", value, "emailExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiredMessageLessThanOrEqualTo(String value) {
            addCriterion("email_expired_message <=", value, "emailExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiredMessageLike(String value) {
            addCriterion("email_expired_message like", value, "emailExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiredMessageNotLike(String value) {
            addCriterion("email_expired_message not like", value, "emailExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiredMessageIn(List<String> values) {
            addCriterion("email_expired_message in", values, "emailExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiredMessageNotIn(List<String> values) {
            addCriterion("email_expired_message not in", values, "emailExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiredMessageBetween(String value1, String value2) {
            addCriterion("email_expired_message between", value1, value2, "emailExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andEmailExpiredMessageNotBetween(String value1, String value2) {
            addCriterion("email_expired_message not between", value1, value2, "emailExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiringMessageIsNull() {
            addCriterion("sms_expiring_message is null");
            return (Criteria) this;
        }

        public Criteria andSmsExpiringMessageIsNotNull() {
            addCriterion("sms_expiring_message is not null");
            return (Criteria) this;
        }

        public Criteria andSmsExpiringMessageEqualTo(String value) {
            addCriterion("sms_expiring_message =", value, "smsExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiringMessageNotEqualTo(String value) {
            addCriterion("sms_expiring_message <>", value, "smsExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiringMessageGreaterThan(String value) {
            addCriterion("sms_expiring_message >", value, "smsExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiringMessageGreaterThanOrEqualTo(String value) {
            addCriterion("sms_expiring_message >=", value, "smsExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiringMessageLessThan(String value) {
            addCriterion("sms_expiring_message <", value, "smsExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiringMessageLessThanOrEqualTo(String value) {
            addCriterion("sms_expiring_message <=", value, "smsExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiringMessageLike(String value) {
            addCriterion("sms_expiring_message like", value, "smsExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiringMessageNotLike(String value) {
            addCriterion("sms_expiring_message not like", value, "smsExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiringMessageIn(List<String> values) {
            addCriterion("sms_expiring_message in", values, "smsExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiringMessageNotIn(List<String> values) {
            addCriterion("sms_expiring_message not in", values, "smsExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiringMessageBetween(String value1, String value2) {
            addCriterion("sms_expiring_message between", value1, value2, "smsExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiringMessageNotBetween(String value1, String value2) {
            addCriterion("sms_expiring_message not between", value1, value2, "smsExpiringMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiredMessageIsNull() {
            addCriterion("sms_expired_message is null");
            return (Criteria) this;
        }

        public Criteria andSmsExpiredMessageIsNotNull() {
            addCriterion("sms_expired_message is not null");
            return (Criteria) this;
        }

        public Criteria andSmsExpiredMessageEqualTo(String value) {
            addCriterion("sms_expired_message =", value, "smsExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiredMessageNotEqualTo(String value) {
            addCriterion("sms_expired_message <>", value, "smsExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiredMessageGreaterThan(String value) {
            addCriterion("sms_expired_message >", value, "smsExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiredMessageGreaterThanOrEqualTo(String value) {
            addCriterion("sms_expired_message >=", value, "smsExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiredMessageLessThan(String value) {
            addCriterion("sms_expired_message <", value, "smsExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiredMessageLessThanOrEqualTo(String value) {
            addCriterion("sms_expired_message <=", value, "smsExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiredMessageLike(String value) {
            addCriterion("sms_expired_message like", value, "smsExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiredMessageNotLike(String value) {
            addCriterion("sms_expired_message not like", value, "smsExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiredMessageIn(List<String> values) {
            addCriterion("sms_expired_message in", values, "smsExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiredMessageNotIn(List<String> values) {
            addCriterion("sms_expired_message not in", values, "smsExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiredMessageBetween(String value1, String value2) {
            addCriterion("sms_expired_message between", value1, value2, "smsExpiredMessage");
            return (Criteria) this;
        }

        public Criteria andSmsExpiredMessageNotBetween(String value1, String value2) {
            addCriterion("sms_expired_message not between", value1, value2, "smsExpiredMessage");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated do_not_delete_during_merge Thu Jan 05 16:45:06 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table acc_password_policy_expiration
     *
     * @mbg.generated Thu Jan 05 16:45:06 CST 2017
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}