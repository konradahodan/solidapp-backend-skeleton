package com.solidtech.zuulapigatewayserver.model;


public class UserDto {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String businessTitle;
    private String fisrtName;
    private String lastName;
    private Integer active;
    private boolean isLoacked;
    private boolean isExpired;
    private boolean isEnabled;

    public UserDto() {}

    public UserDto(String username, String password, String email, String phone, String businessTitle, String fisrtName, String lastName, Integer active, boolean isLoacked, boolean isExpired, boolean isEnabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.businessTitle = businessTitle;
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.active = active;
        this.isLoacked = isLoacked;
        this.isExpired = isExpired;
        this.isEnabled = isEnabled;
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

    public String getBusinessTitle() {
        return businessTitle;
    }

    public void setBusinessTitle(String businessTitle) {
        this.businessTitle = businessTitle;
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

    public User getUserFromDto(){
        User user = new User();

        user.setActive(active);
        user.setEnabled(isEnabled);
        user.setExpired(isExpired);
        user.setLoacked(isLoacked);

        user.setUsername(username);
        user.setPassword(password);
        user.setFisrtName(fisrtName);
        user.setLastName(lastName);
        user.setBusinessTitle(businessTitle);
        user.setEmail(email);
        user.setPhone(phone);

        return user;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", businessTitle='" + businessTitle + '\'' +
                ", fisrtName='" + fisrtName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                ", isLoacked=" + isLoacked +
                ", isExpired=" + isExpired +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
