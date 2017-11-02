package com.hirisun.springbootjsp.dao;

import com.hirisun.springbootjsp.domain.Permission;
import com.hirisun.springbootjsp.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionRepositoryTest {

    @Autowired
    private PermissionRepository permissionRepository;

    @Test
    @Transactional
    public void testFindByRoles(){
        Set<Role> roles = new HashSet<>();
        Set<Permission> byRoles = permissionRepository.findByRoles(roles);
        System.out.println(byRoles);

    }
}
