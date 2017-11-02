package com.hirisun.springbootjsp.dao;

import com.hirisun.springbootjsp.domain.Permission;
import com.hirisun.springbootjsp.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PermissionRepository extends JpaRepository<Permission,Long> {

    Set<Permission> findByRoles(Set<Role> roles);
}
