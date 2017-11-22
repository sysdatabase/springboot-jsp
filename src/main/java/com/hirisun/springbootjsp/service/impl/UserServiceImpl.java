package com.hirisun.springbootjsp.service.impl;

import com.hirisun.springbootjsp.dao.UserRepository;
import com.hirisun.springbootjsp.domain.User;
import com.hirisun.springbootjsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getByUserName(String username) {
        return userRepository.getByUsername(username);
    }
}
