package com.accumulate.dto.user;

/**
 * 代表一个用户的全部信息
 * Created by tjwang on 2017/1/6.
 */
public class UserDto {
    private Integer id;
    private String username;
    private String displayName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }
}