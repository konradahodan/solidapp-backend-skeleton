package com.solidtech.zuulapigatewayserver.dao;

import com.solidtech.zuulapigatewayserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
