package com.hirisun.springbootjsp.dao;

import com.hirisun.springbootjsp.domain.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionMapperTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionMapperTest.class);

    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    public void testGetByUserId(){
        List<Permission> permission = permissionMapper.getByUserId(1L);
        LOGGER.debug("<== permission:{}",permission);
    }
}
