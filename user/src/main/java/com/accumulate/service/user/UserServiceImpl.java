package com.accumulate.service.user;

import com.accumulate.assembler.user.UserAssembler;
import com.accumulate.dto.user.UserDto;
import com.accumulate.entity.UserEntity;
import com.accumulate.entity.UserEntityExample;
import com.accumulate.exception.ApplicationException;
import com.accumulate.exception.UserErrorCode;
import com.accumulate.factory.PasswordPolicyFactory;
import com.accumulate.mapper.UserEntityMapper;
import com.accumulate.service.UserService;
import com.accumulate.service.password.PasswordPolicy;
import com.accumulate.service.password.encrypt.PwdHashPolicy;
import com.accumulate.service.password.encrypt.PwdHashPolicyLookup;
import com.accumulate.utils.StringUtils;
import com.accumulate.vo.password.PolicyTip;
import com.google.common.base.Preconditions;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户服务实现
 * Created by tjwang on 2017/1/3.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserEntityMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int create(UserEntity user) {
        logger.debug("Execute UserService.add");
        return userMapper.insert(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(String username, String password) {
        Preconditions.checkArgument(StringUtils.isNotBlank(username), "注册用户名不能为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(password), "注册密码不能为空");

        boolean exists = checkExists(username);
        if (exists) {
            throw new ApplicationException(UserErrorCode.USER_NAME_NOT_EXISITS, username);
        }

        PasswordPolicy pp = PasswordPolicyFactory.getDefault();
        PolicyTip tip = pp.check(password);
        if (!tip.isPass()) {
            throw new ApplicationException(UserErrorCode.USER_PASSWORD_VIOLATE, tip.getTip());
        }

        Date now = DateTime.now().toDate();

        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setDisplayName("王");
        user.setCreateTime(now);
        user.setUpdateTime(now);
        userMapper.insertSelective(user);

        PwdHashPolicy pwdHashPolicy = PwdHashPolicyLookup.getMD5();
        String encryptPwd = pwdHashPolicy.encryptPassword(password, String.valueOf(user.getId()));

        user.setPassword(encryptPwd);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public UserDto findByUsername(String username) {
        Preconditions.checkArgument(StringUtils.isNotBlank(username), "用户名不能为空");

        UserEntity user = findUser(username);
        UserDto dto = UserAssembler.transfer(user);

        return dto;
    }

    private UserEntity findUser(String username) {
        UserEntityExample example = new UserEntityExample();
        UserEntityExample.Criteria c = example.createCriteria();
        c.andUsernameEqualTo(username);

        List<UserEntity> users = userMapper.selectByExample(example);
        if (users.size() == 0) {
            throw new ApplicationException(UserErrorCode.USER_NAME_NOT_EXISITS, username);
        }
        if (users.size() > 1) {
            throw new ApplicationException(UserErrorCode.USER_NAME_DUPLICATE);
        }
        return users.get(0);
    }

    private boolean checkExists(String username) {
        UserEntityExample example = new UserEntityExample();
        UserEntityExample.Criteria c = example.createCriteria();
        c.andUsernameEqualTo(username);
        List<UserEntity> users = userMapper.selectByExample(example);
        if (users.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void delete(int id) {
        Preconditions.checkArgument(id != 0, "非法参数");
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByUsername(String username) {
        Preconditions.checkArgument(StringUtils.isNotBlank(username), "待删除用户名不能为空");

        UserEntityExample example = new UserEntityExample();
        UserEntityExample.Criteria c = example.createCriteria();
        c.andUsernameEqualTo(username);
        userMapper.deleteByExample(example);
    }

}
