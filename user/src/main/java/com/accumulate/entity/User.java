package com.accumulate.entity;

public class User extends BaseEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column acc_user.name
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column acc_user.age
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    private Short age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column acc_user.password
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column acc_user.name
     *
     * @return the value of acc_user.name
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column acc_user.name
     *
     * @param name the value for acc_user.name
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column acc_user.age
     *
     * @return the value of acc_user.age
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    public Short getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column acc_user.age
     *
     * @param age the value for acc_user.age
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    public void setAge(Short age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column acc_user.password
     *
     * @return the value of acc_user.password
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column acc_user.password
     *
     * @param password the value for acc_user.password
     *
     * @mbg.generated Fri Jan 06 11:30:00 CST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}