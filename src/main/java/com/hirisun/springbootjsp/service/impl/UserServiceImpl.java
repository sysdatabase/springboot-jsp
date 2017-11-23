package com.hirisun.springbootjsp.service.impl;

import com.hirisun.springbootjsp.dao.UserMapper;
import com.hirisun.springbootjsp.domain.User;
import com.hirisun.springbootjsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String username) {
        return userMapper.getByUserName(username);
    }
}
