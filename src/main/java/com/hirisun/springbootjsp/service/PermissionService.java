package com.hirisun.springbootjsp.service;

import com.hirisun.springbootjsp.domain.Permission;

import java.util.List;

public interface PermissionService {

    /**
     * 根据用户ID获得权限信息
     * @param id 用户Id
     * @return
     */
    List<Permission> getPermissionByUserId(long id);
}
