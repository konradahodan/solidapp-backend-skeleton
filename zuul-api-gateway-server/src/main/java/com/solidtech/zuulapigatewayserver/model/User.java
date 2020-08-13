package com.solidtech.zuulapigatewayserver.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {

    // private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String fisrtName;

    @Column
    private String lastName;

    @Column
    private String businessTitle;

    @Column
    private Integer active=1;

    @Column
    private boolean isLoacked=false;

    @Column
    private boolean isExpired=false;

    @Column
    private boolean isEnabled=true;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id",
                            nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id",
                            nullable = false, updatable = false) })
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    public User(){}

    public User(String username, String password, String email, String phone, String fisrtName, String lastName, String businessTitle) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.businessTitle = businessTitle;

        this.active = getActive();
        this.isLoacked = isLoacked();
        this.isExpired = isExpired();
        this.isEnabled = isEnabled();
    }

    public User(long id, String username, String password, String email, String phone, String fisrtName, String lastName, String businessTitle, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.businessTitle = businessTitle;
        this.roles = roles;

        this.active = getActive();
        this.isLoacked = isLoacked();
        this.isExpired = isExpired();
        this.isEnabled = isEnabled();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", fisrtName='" + fisrtName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", businessTitle='" + businessTitle + '\'' +
                ", active=" + active +
                ", isLoacked=" + isLoacked +
                ", isExpired=" + isExpired +
                ", isEnabled=" + isEnabled +
                ", roles=" + roles +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public boolean isLoacked() {
        return isLoacked;
    }

    public void setLoacked(boolean loacked) {
        isLoacked = loacked;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getBusinessTitle() {
        return businessTitle;
    }

    public void setBusinessTitle(String businessTitle) {
        this.businessTitle = businessTitle;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}