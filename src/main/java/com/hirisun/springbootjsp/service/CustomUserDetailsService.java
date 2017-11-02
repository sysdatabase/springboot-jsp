package com.hirisun.springbootjsp.service;

import com.alibaba.druid.util.StringUtils;
import com.hirisun.springbootjsp.dao.PermissionRepository;
import com.hirisun.springbootjsp.dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.debug("userName:{}",username);
        if (StringUtils.isEmpty(username)){
            throw new UsernameNotFoundException("UserName is blank!");
        }
        com.hirisun.springbootjsp.domain.User user = userRepository.getByUsername(username);
        Set<GrantedAuthority> authorities = new HashSet<>();
        return new User(username,user.getPassword(),true,true,true,true,authorities);
    }
}
