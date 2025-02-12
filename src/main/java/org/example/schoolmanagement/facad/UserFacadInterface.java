package org.example.schoolmanagement.facad;

import org.example.schoolmanagement.dto.UserDTO;

public interface UserFacadInterface {
    boolean addUser(UserDTO user);
    boolean updateUser(UserDTO user);
    UserDTO getUserbyName(String username);
    public boolean deleteUser(int id);
    public boolean authenticate(UserDTO user);
    
}

