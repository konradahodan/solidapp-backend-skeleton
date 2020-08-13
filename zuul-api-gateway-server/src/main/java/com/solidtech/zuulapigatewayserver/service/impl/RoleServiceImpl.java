package com.solidtech.zuulapigatewayserver.service.impl;

import com.solidtech.zuulapigatewayserver.dao.RoleDao;
import com.solidtech.zuulapigatewayserver.model.Role;
import com.solidtech.zuulapigatewayserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findByName(String name) {
        Role role = roleDao.findByName(name);
        return role;
    }

    @Override
    public Role save(Role role) {
        return roleDao.save(role);
    }

}
