package main.java.model;

import java.sql.Date;

public class User {
    private int id;
    private int roleId;
    private String tempRole;
    private String firstName;
    private String lastName;
    private boolean gender;
    private String tempGender;
    private Date dateOfBirth;
    private String phone;
    private String email;
    private int status;
    private String tempStatus;
    private String address;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, int roleId, String firstName, String lastName, boolean gender, Date dateOfBirth, String phone, String address, String email, String username, String password, int status) {
        this.id = id;
        this.roleId = roleId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public User(int roleId, String firstName, String lastName, boolean gender, Date dateOfBirth, String phone, String address, String email, String username, String password, int status) {
        this.roleId = roleId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public User(int id, String tempRole, String firstName, String lastName, String tempGender, Date dateOfBirth, String phone, String email, String tempStatus, String address, String username, String password) {
        this.id = id;
        this.tempRole = tempRole;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tempGender = tempGender;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
        this.tempStatus = tempStatus;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public User(int id, String firstName, int roleId, int status) {
        this.id = id;
        this.firstName = firstName;
        this.roleId = roleId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTempRole() {
        return tempRole;
    }

    public void setTempRole(String tempRole) {
        this.tempRole = tempRole;
    }

    public boolean isGender() {
        return gender;
    }

    public String getTempGender() {
        return tempGender;
    }

    public void setTempGender(String tempGender) {
        this.tempGender = tempGender;
    }

    public String getTempStatus() {
        return tempStatus;
    }

    public void setTempStatus(String tempStatus) {
        this.tempStatus = tempStatus;
    }
}