package org.example.schoolmanagement.dto;

import org.example.schoolmanagement.util.Role;


public class SystemUser {
    private  final Integer userID;
    private String userName;
    private String password;
    private Role role;

    

    public SystemUser(String password, Role role, Integer userID, String userName) {
        this.password = password;
        this.role = role;
        this.userID = userID;
        this.userName = userName;
    }
   

    public Integer getUserID() {
        return userID;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    

    

}
