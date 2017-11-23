package com.hirisun.springbootjsp.service;

import com.hirisun.springbootjsp.domain.User;

public interface UserService {

    /**
     * 根据用户名获得用户信息
     * @param username 用户名
     * @return 用户信息
     */
    User getUserByUserName(String username);
}
