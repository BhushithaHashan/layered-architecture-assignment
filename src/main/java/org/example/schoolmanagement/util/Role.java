package org.example.schoolmanagement.util;

public enum Role {
    STUDENT("student"),
    TEACHER("teacher"),
    PRINCIPAL("principal"),
    ADMIN("admin");

    private final String role;

    Role(String roleDesc){
        this.role = roleDesc;
    }

    public String getRole(){
        return this.role;
    }

}
