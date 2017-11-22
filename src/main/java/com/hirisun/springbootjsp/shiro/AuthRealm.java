package com.hirisun.springbootjsp.shiro;

import com.hirisun.springbootjsp.domain.User;
import com.hirisun.springbootjsp.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AuthRealm extends AuthorizingRealm {

    public static final Logger LOGGER = LoggerFactory.getLogger(AuthRealm.class);

    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        LOGGER.debug("username:{}",username);
        String name = Optional.ofNullable(username).orElseThrow(UnknownAccountException::new);
        User user = userService.getByUserName(name);
        return null;
    }
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
