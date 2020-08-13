package com.solidtech.zuulapigatewayserver.dao;

import com.solidtech.zuulapigatewayserver.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository <Role, Long> {
    Role findByName(String name);
}
