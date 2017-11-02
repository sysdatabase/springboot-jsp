package com.hirisun.springbootjsp.dao;

import com.hirisun.springbootjsp.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
