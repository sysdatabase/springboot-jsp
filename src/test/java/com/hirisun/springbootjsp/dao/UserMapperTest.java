package com.hirisun.springbootjsp.dao;

import com.hirisun.springbootjsp.domain.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testGetAll(){
        userMapper.getAll().forEach(user -> LOGGER.debug("==> user:{}",user));

    }

    @Test
    public void testSelectWhitParam(){
        Map<String,Object> param = new HashMap<>();
        param.put("id",4L);
        param.put("username","test");
        userMapper.selectWhitParam(param).forEach(user -> LOGGER.debug("==> user:{}",user));

    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("guest2");
        Object object = new SimpleHash("md5", "123456", "", 2);
        user.setPassword(object.toString());
        int count = userMapper.insertUser(user);
        LOGGER.debug("==> count:{}",count);
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(4L);
        user.setUsername("test");
        int count = userMapper.updateUser(user);
        LOGGER.debug("==> count:{}",count);

    }

    @Test
    public void testGetByUserName(){
        User user = userMapper.getByUserName("admin");
        LOGGER.debug("==> user:{}",user);
    }

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("guest");
        Object object = new SimpleHash("md5", "123456", "", 2);
        user.setPassword(object.toString());
        int count = userMapper.saveUser(user);
        LOGGER.debug("==> count:{}",count);

    }

    @Test
    public void testRemoveUser(){
        Long id = 2L;
        int count = userMapper.removeUser(id);
        LOGGER.debug("==> count:{}",count);

    }

}
