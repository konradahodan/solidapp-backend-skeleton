package com.solidtech.zuulapigatewayserver.service;

import com.solidtech.zuulapigatewayserver.model.User;
import com.solidtech.zuulapigatewayserver.model.UserDto;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    User save(User user);

    // User findUserByUsername(String username);
    // void addRoleToUser(String username, String roleName);

    List<User> findAll();
    User findOne(String username);

    void addRoleToUser(String username, String roleName);
    void addRoleToUser(String username);

    boolean logout(String token);
}
