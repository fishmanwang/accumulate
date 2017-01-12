package com.accumulate.assembler.user;

import com.accumulate.dto.user.UserDto;
import com.accumulate.entity.UserEntity;
import org.springframework.beans.BeanUtils;

/**
 * 转换User的dto、entity等，用于不同层的交互
 * Created by tjwang on 2017/1/12.
 */
public class UserAssembler {

    public static UserDto transfer(UserEntity user) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

}
