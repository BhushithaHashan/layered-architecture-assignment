package org.example.schoolmanagement.service;

import org.example.schoolmanagement.dto.UserDTO;

public class AuthService implements AuthserviceInterface{
    private ServiceInterface<UserDTO,Integer> userService;
    public AuthService(ServiceInterface<UserDTO,Integer> userService){
        this.userService = userService;
    };
    @Override
    public boolean authenticateUser(UserDTO user) {
        if (isUserExist(user)) {
            return user.getPassword().equalsIgnoreCase(userService.find(user.getUsername()).getPassword());
        }else{
            return false;
        }
    }
    public boolean isUsernameTaken(UserDTO user){
        return this.userService.isExist(user);
    }
    private boolean isUserExist(UserDTO user){
        return this.userService.isExist(user);
    }
    
}
