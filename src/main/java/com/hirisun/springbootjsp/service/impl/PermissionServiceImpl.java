package com.hirisun.springbootjsp.service.impl;

import com.hirisun.springbootjsp.dao.PermissionMapper;
import com.hirisun.springbootjsp.domain.Permission;
import com.hirisun.springbootjsp.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermissionByUserId(long id) {
        return permissionMapper.getByUserId(id);
    }
}
