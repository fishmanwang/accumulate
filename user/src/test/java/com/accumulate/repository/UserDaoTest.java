package com.accumulate.repository;

import com.accumulate.base.BaseTest;
import com.accumulate.entity.UserEntity;
import com.mongodb.WriteResult;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;

/**
 * Created by tjwang on 2016/8/10.
 */
public class UserDaoTest extends BaseTest {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private UserDao userDao;

    @Before
    public void init() {
        WriteResult result = mongoTemplate.remove(Query.query(Criteria.where("name").is("wang")), UserEntity.class);
        System.out.println(result.toString());
        addUser();
    }

    private void addUser() {
        UserEntity user = new UserEntity();
        user.setName("wang");
        user.setAge(30);
        mongoTemplate.save(user);
    }

    @Test
    public void testFinUser() {
        UserEntity user = userDao.findByName("wang");
        System.out.println(user.toString());
    }

}
