package com.hirisun.springbootjsp.dao;

import com.hirisun.springbootjsp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    /**
     *
     * @param username
     * @return
     */
    User getByUsername(String username);
}
