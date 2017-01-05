package com.accumulate.bo.password;

import com.accumulate.bo.password.check.BannedConstraintCheck;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by tjwang on 2017/1/4.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class General {

    @NotBlank(message = "名称不能为空")
    @Size(min = 1, max = 20, message = "名称必须为{min}位到{max}个字符")
    private String name;
    @NotBlank(message = "描述不能为空")
    @Size(min = 1, max = 100, message = "描述必须为{min}位到{max}个字符")
    private String description;
    private boolean enable = true;
    private boolean banned = false;
    private String bannedUrl;

    private General() {
    }

    public General(String name, String description, boolean enable, boolean banned, String bannedUrl) {
        this.name = name;
        this.description = description;
        this.enable = enable;
        this.banned = banned;
        this.bannedUrl = bannedUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnable() {
        return enable;
    }

    public boolean isBanned() {
        return banned;
    }

    public String getBannedUrl() {
        return bannedUrl;
    }

    /**
     * 需排除的密码
     */
    private static final String WEAK_PASSWORD_25 = "000000 111111 11111111 112233 123123 123321 123456 " +
            "12345678 654321 666666 888888 abcdef abcabc abc123 a1b2c3 aaa111 123qwe qwerty qweasd " +
            "admin password p@ssword passwd iloveyou 5201314";

    public static General buildDefault() {
        General general = new General("default", "默认密码策略", true, true, WEAK_PASSWORD_25);
        return general;
    }

    public PolicyTip check(String password) {
        if (isBanned()) {
            BannedConstraintCheck bannedConstraintCheck = new BannedConstraintCheck(bannedUrl);
            return bannedConstraintCheck.check(password);
        }
        return PolicyTip.pass();
    }

}
