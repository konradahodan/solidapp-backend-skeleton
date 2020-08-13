package com.solidtech.zuulapigatewayserver.service.impl;

import com.solidtech.zuulapigatewayserver.dao.RoleDao;
import com.solidtech.zuulapigatewayserver.dao.UserDao;
import com.solidtech.zuulapigatewayserver.model.Role;
import com.solidtech.zuulapigatewayserver.model.User;
import com.solidtech.zuulapigatewayserver.model.UserDto;
import com.solidtech.zuulapigatewayserver.service.RoleService;
import com.solidtech.zuulapigatewayserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public User save(UserDto user) {
        User nUser = user.getUserFromDto();

        User user1 = userDao.findByUsername(nUser.getUsername());
        if (user1 != null) throw new RuntimeException("This user already exists, try with an other username");

        nUser.setPassword(bcryptEncoder.encode(user.getPassword()));

        Role role = roleService.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        if(nUser.getEmail().split("@")[1].equals("admin.edu")){
            role = roleService.findByName("ADMIN");
            roleSet.add(role);
        }

        nUser.setRoles(roleSet);
        return userDao.save(nUser);
    }

    @Override
    public User save(User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));

        Role role = roleService.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        if(user.getEmail().split("@")[1].equals("admin.edu")){
            role = roleService.findByName("ADMIN");
            roleSet.add(role);
        }
        user.getRoles().addAll(roleSet);

        user.setRoles(roleSet);
        return userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findOne(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

    }

    @Override
    public void addRoleToUser(String username) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));

    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())); //
        });
        return authorities;
    }

    @Override
    public boolean logout(String token) {
        // Remove token on contexte
        // TODO
        return true;
    }
}
