package com.hirisun.springbootjsp.shiro;

import com.hirisun.springbootjsp.domain.User;
import com.hirisun.springbootjsp.service.PermissionService;
import com.hirisun.springbootjsp.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class AuthRealm extends AuthorizingRealm {

    public static final Logger LOGGER = LoggerFactory.getLogger(AuthRealm.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        LOGGER.debug("==> username:{}",username);
        Optional<User> user = Optional.ofNullable(userService.getUserByUserName(username));
        user.orElseThrow(UnknownAccountException::new);
        LOGGER.debug("<== user:{}",user.get());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.get(),user.get().getPassword(),getName());
        return authenticationInfo;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        LOGGER.debug("<== user:{}",user);
        Set<String> permissionSet = permissionService.getPermissionByUserId(user.getId()).stream().map(permission -> permission.getName()).collect(Collectors.toSet());
        LOGGER.debug("<== permissionSet:{}",permissionSet);
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }


}
