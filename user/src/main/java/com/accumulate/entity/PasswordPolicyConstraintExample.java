package com.accumulate.entity;

import java.util.ArrayList;
import java.util.List;

public class PasswordPolicyConstraintExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
     */
    public PasswordPolicyConstraintExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
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
     * This method corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
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

        public Criteria andMinIsNull() {
            addCriterion("min is null");
            return (Criteria) this;
        }

        public Criteria andMinIsNotNull() {
            addCriterion("min is not null");
            return (Criteria) this;
        }

        public Criteria andMinEqualTo(Integer value) {
            addCriterion("min =", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotEqualTo(Integer value) {
            addCriterion("min <>", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinGreaterThan(Integer value) {
            addCriterion("min >", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("min >=", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinLessThan(Integer value) {
            addCriterion("min <", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinLessThanOrEqualTo(Integer value) {
            addCriterion("min <=", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinIn(List<Integer> values) {
            addCriterion("min in", values, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotIn(List<Integer> values) {
            addCriterion("min not in", values, "min");
            return (Criteria) this;
        }

        public Criteria andMinBetween(Integer value1, Integer value2) {
            addCriterion("min between", value1, value2, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotBetween(Integer value1, Integer value2) {
            addCriterion("min not between", value1, value2, "min");
            return (Criteria) this;
        }

        public Criteria andMaxIsNull() {
            addCriterion("max is null");
            return (Criteria) this;
        }

        public Criteria andMaxIsNotNull() {
            addCriterion("max is not null");
            return (Criteria) this;
        }

        public Criteria andMaxEqualTo(Integer value) {
            addCriterion("max =", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxNotEqualTo(Integer value) {
            addCriterion("max <>", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxGreaterThan(Integer value) {
            addCriterion("max >", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("max >=", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxLessThan(Integer value) {
            addCriterion("max <", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxLessThanOrEqualTo(Integer value) {
            addCriterion("max <=", value, "max");
            return (Criteria) this;
        }

        public Criteria andMaxIn(List<Integer> values) {
            addCriterion("max in", values, "max");
            return (Criteria) this;
        }

        public Criteria andMaxNotIn(List<Integer> values) {
            addCriterion("max not in", values, "max");
            return (Criteria) this;
        }

        public Criteria andMaxBetween(Integer value1, Integer value2) {
            addCriterion("max between", value1, value2, "max");
            return (Criteria) this;
        }

        public Criteria andMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("max not between", value1, value2, "max");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCharacterIsNull() {
            addCriterion("max_repeat_character is null");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCharacterIsNotNull() {
            addCriterion("max_repeat_character is not null");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCharacterEqualTo(Integer value) {
            addCriterion("max_repeat_character =", value, "maxRepeatCharacter");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCharacterNotEqualTo(Integer value) {
            addCriterion("max_repeat_character <>", value, "maxRepeatCharacter");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCharacterGreaterThan(Integer value) {
            addCriterion("max_repeat_character >", value, "maxRepeatCharacter");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCharacterGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_repeat_character >=", value, "maxRepeatCharacter");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCharacterLessThan(Integer value) {
            addCriterion("max_repeat_character <", value, "maxRepeatCharacter");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCharacterLessThanOrEqualTo(Integer value) {
            addCriterion("max_repeat_character <=", value, "maxRepeatCharacter");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCharacterIn(List<Integer> values) {
            addCriterion("max_repeat_character in", values, "maxRepeatCharacter");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCharacterNotIn(List<Integer> values) {
            addCriterion("max_repeat_character not in", values, "maxRepeatCharacter");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCharacterBetween(Integer value1, Integer value2) {
            addCriterion("max_repeat_character between", value1, value2, "maxRepeatCharacter");
            return (Criteria) this;
        }

        public Criteria andMaxRepeatCharacterNotBetween(Integer value1, Integer value2) {
            addCriterion("max_repeat_character not between", value1, value2, "maxRepeatCharacter");
            return (Criteria) this;
        }

        public Criteria andMinNonAlphanumericIsNull() {
            addCriterion("min_non_alphanumeric is null");
            return (Criteria) this;
        }

        public Criteria andMinNonAlphanumericIsNotNull() {
            addCriterion("min_non_alphanumeric is not null");
            return (Criteria) this;
        }

        public Criteria andMinNonAlphanumericEqualTo(Integer value) {
            addCriterion("min_non_alphanumeric =", value, "minNonAlphanumeric");
            return (Criteria) this;
        }

        public Criteria andMinNonAlphanumericNotEqualTo(Integer value) {
            addCriterion("min_non_alphanumeric <>", value, "minNonAlphanumeric");
            return (Criteria) this;
        }

        public Criteria andMinNonAlphanumericGreaterThan(Integer value) {
            addCriterion("min_non_alphanumeric >", value, "minNonAlphanumeric");
            return (Criteria) this;
        }

        public Criteria andMinNonAlphanumericGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_non_alphanumeric >=", value, "minNonAlphanumeric");
            return (Criteria) this;
        }

        public Criteria andMinNonAlphanumericLessThan(Integer value) {
            addCriterion("min_non_alphanumeric <", value, "minNonAlphanumeric");
            return (Criteria) this;
        }

        public Criteria andMinNonAlphanumericLessThanOrEqualTo(Integer value) {
            addCriterion("min_non_alphanumeric <=", value, "minNonAlphanumeric");
            return (Criteria) this;
        }

        public Criteria andMinNonAlphanumericIn(List<Integer> values) {
            addCriterion("min_non_alphanumeric in", values, "minNonAlphanumeric");
            return (Criteria) this;
        }

        public Criteria andMinNonAlphanumericNotIn(List<Integer> values) {
            addCriterion("min_non_alphanumeric not in", values, "minNonAlphanumeric");
            return (Criteria) this;
        }

        public Criteria andMinNonAlphanumericBetween(Integer value1, Integer value2) {
            addCriterion("min_non_alphanumeric between", value1, value2, "minNonAlphanumeric");
            return (Criteria) this;
        }

        public Criteria andMinNonAlphanumericNotBetween(Integer value1, Integer value2) {
            addCriterion("min_non_alphanumeric not between", value1, value2, "minNonAlphanumeric");
            return (Criteria) this;
        }

        public Criteria andMinDigitsIsNull() {
            addCriterion("min_digits is null");
            return (Criteria) this;
        }

        public Criteria andMinDigitsIsNotNull() {
            addCriterion("min_digits is not null");
            return (Criteria) this;
        }

        public Criteria andMinDigitsEqualTo(Integer value) {
            addCriterion("min_digits =", value, "minDigits");
            return (Criteria) this;
        }

        public Criteria andMinDigitsNotEqualTo(Integer value) {
            addCriterion("min_digits <>", value, "minDigits");
            return (Criteria) this;
        }

        public Criteria andMinDigitsGreaterThan(Integer value) {
            addCriterion("min_digits >", value, "minDigits");
            return (Criteria) this;
        }

        public Criteria andMinDigitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_digits >=", value, "minDigits");
            return (Criteria) this;
        }

        public Criteria andMinDigitsLessThan(Integer value) {
            addCriterion("min_digits <", value, "minDigits");
            return (Criteria) this;
        }

        public Criteria andMinDigitsLessThanOrEqualTo(Integer value) {
            addCriterion("min_digits <=", value, "minDigits");
            return (Criteria) this;
        }

        public Criteria andMinDigitsIn(List<Integer> values) {
            addCriterion("min_digits in", values, "minDigits");
            return (Criteria) this;
        }

        public Criteria andMinDigitsNotIn(List<Integer> values) {
            addCriterion("min_digits not in", values, "minDigits");
            return (Criteria) this;
        }

        public Criteria andMinDigitsBetween(Integer value1, Integer value2) {
            addCriterion("min_digits between", value1, value2, "minDigits");
            return (Criteria) this;
        }

        public Criteria andMinDigitsNotBetween(Integer value1, Integer value2) {
            addCriterion("min_digits not between", value1, value2, "minDigits");
            return (Criteria) this;
        }

        public Criteria andMinLowercaseIsNull() {
            addCriterion("min_lowercase is null");
            return (Criteria) this;
        }

        public Criteria andMinLowercaseIsNotNull() {
            addCriterion("min_lowercase is not null");
            return (Criteria) this;
        }

        public Criteria andMinLowercaseEqualTo(Integer value) {
            addCriterion("min_lowercase =", value, "minLowercase");
            return (Criteria) this;
        }

        public Criteria andMinLowercaseNotEqualTo(Integer value) {
            addCriterion("min_lowercase <>", value, "minLowercase");
            return (Criteria) this;
        }

        public Criteria andMinLowercaseGreaterThan(Integer value) {
            addCriterion("min_lowercase >", value, "minLowercase");
            return (Criteria) this;
        }

        public Criteria andMinLowercaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_lowercase >=", value, "minLowercase");
            return (Criteria) this;
        }

        public Criteria andMinLowercaseLessThan(Integer value) {
            addCriterion("min_lowercase <", value, "minLowercase");
            return (Criteria) this;
        }

        public Criteria andMinLowercaseLessThanOrEqualTo(Integer value) {
            addCriterion("min_lowercase <=", value, "minLowercase");
            return (Criteria) this;
        }

        public Criteria andMinLowercaseIn(List<Integer> values) {
            addCriterion("min_lowercase in", values, "minLowercase");
            return (Criteria) this;
        }

        public Criteria andMinLowercaseNotIn(List<Integer> values) {
            addCriterion("min_lowercase not in", values, "minLowercase");
            return (Criteria) this;
        }

        public Criteria andMinLowercaseBetween(Integer value1, Integer value2) {
            addCriterion("min_lowercase between", value1, value2, "minLowercase");
            return (Criteria) this;
        }

        public Criteria andMinLowercaseNotBetween(Integer value1, Integer value2) {
            addCriterion("min_lowercase not between", value1, value2, "minLowercase");
            return (Criteria) this;
        }

        public Criteria andMinUppercaseIsNull() {
            addCriterion("min_uppercase is null");
            return (Criteria) this;
        }

        public Criteria andMinUppercaseIsNotNull() {
            addCriterion("min_uppercase is not null");
            return (Criteria) this;
        }

        public Criteria andMinUppercaseEqualTo(Integer value) {
            addCriterion("min_uppercase =", value, "minUppercase");
            return (Criteria) this;
        }

        public Criteria andMinUppercaseNotEqualTo(Integer value) {
            addCriterion("min_uppercase <>", value, "minUppercase");
            return (Criteria) this;
        }

        public Criteria andMinUppercaseGreaterThan(Integer value) {
            addCriterion("min_uppercase >", value, "minUppercase");
            return (Criteria) this;
        }

        public Criteria andMinUppercaseGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_uppercase >=", value, "minUppercase");
            return (Criteria) this;
        }

        public Criteria andMinUppercaseLessThan(Integer value) {
            addCriterion("min_uppercase <", value, "minUppercase");
            return (Criteria) this;
        }

        public Criteria andMinUppercaseLessThanOrEqualTo(Integer value) {
            addCriterion("min_uppercase <=", value, "minUppercase");
            return (Criteria) this;
        }

        public Criteria andMinUppercaseIn(List<Integer> values) {
            addCriterion("min_uppercase in", values, "minUppercase");
            return (Criteria) this;
        }

        public Criteria andMinUppercaseNotIn(List<Integer> values) {
            addCriterion("min_uppercase not in", values, "minUppercase");
            return (Criteria) this;
        }

        public Criteria andMinUppercaseBetween(Integer value1, Integer value2) {
            addCriterion("min_uppercase between", value1, value2, "minUppercase");
            return (Criteria) this;
        }

        public Criteria andMinUppercaseNotBetween(Integer value1, Integer value2) {
            addCriterion("min_uppercase not between", value1, value2, "minUppercase");
            return (Criteria) this;
        }

        public Criteria andNotBlankIsNull() {
            addCriterion("not_blank is null");
            return (Criteria) this;
        }

        public Criteria andNotBlankIsNotNull() {
            addCriterion("not_blank is not null");
            return (Criteria) this;
        }

        public Criteria andNotBlankEqualTo(Boolean value) {
            addCriterion("not_blank =", value, "notBlank");
            return (Criteria) this;
        }

        public Criteria andNotBlankNotEqualTo(Boolean value) {
            addCriterion("not_blank <>", value, "notBlank");
            return (Criteria) this;
        }

        public Criteria andNotBlankGreaterThan(Boolean value) {
            addCriterion("not_blank >", value, "notBlank");
            return (Criteria) this;
        }

        public Criteria andNotBlankGreaterThanOrEqualTo(Boolean value) {
            addCriterion("not_blank >=", value, "notBlank");
            return (Criteria) this;
        }

        public Criteria andNotBlankLessThan(Boolean value) {
            addCriterion("not_blank <", value, "notBlank");
            return (Criteria) this;
        }

        public Criteria andNotBlankLessThanOrEqualTo(Boolean value) {
            addCriterion("not_blank <=", value, "notBlank");
            return (Criteria) this;
        }

        public Criteria andNotBlankIn(List<Boolean> values) {
            addCriterion("not_blank in", values, "notBlank");
            return (Criteria) this;
        }

        public Criteria andNotBlankNotIn(List<Boolean> values) {
            addCriterion("not_blank not in", values, "notBlank");
            return (Criteria) this;
        }

        public Criteria andNotBlankBetween(Boolean value1, Boolean value2) {
            addCriterion("not_blank between", value1, value2, "notBlank");
            return (Criteria) this;
        }

        public Criteria andNotBlankNotBetween(Boolean value1, Boolean value2) {
            addCriterion("not_blank not between", value1, value2, "notBlank");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated do_not_delete_during_merge Fri Jan 06 11:29:43 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table acc_password_policy_constraint
     *
     * @mbg.generated Fri Jan 06 11:29:43 CST 2017
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