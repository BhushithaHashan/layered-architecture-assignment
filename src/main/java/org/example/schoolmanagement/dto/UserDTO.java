package org.example.schoolmanagement.dto;

import org.example.schoolmanagement.util.Role;

public class UserDTO {
    private int userId;
    private String username;
    private String email;
    private String password;
    private Role role;  
    private Integer specificAttribute; 

    // Constructor for initializing UserDTO object
    public UserDTO(int userId, String username, String email, String password, Role role, Integer specificAttribute) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.specificAttribute = specificAttribute;
    }
    public UserDTO(){}

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getSpecificAttribute() {
        return specificAttribute;
    }

    public void setSpecificAttribute(Integer specificAttribute) {
        this.specificAttribute = specificAttribute;
    }
}
