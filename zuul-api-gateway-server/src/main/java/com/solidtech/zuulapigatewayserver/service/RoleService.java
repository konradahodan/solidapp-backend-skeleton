package com.solidtech.zuulapigatewayserver.service;

import com.solidtech.zuulapigatewayserver.model.Role;

public interface RoleService {
    Role findByName(String name);

    Role save(Role role);
}
