package org.example.schoolmanagement.facad;

import org.example.schoolmanagement.dto.UserDTO;
import org.example.schoolmanagement.service.AuthserviceInterface;
import org.example.schoolmanagement.service.ServiceFactory;
import org.example.schoolmanagement.service.ServiceInterface;
import org.example.schoolmanagement.util.AlertMessage;
import org.example.schoolmanagement.util.DATABASETYPES;
import org.example.schoolmanagement.util.DBConnectionInterface;
import org.example.schoolmanagement.util.DBFactory;
import org.example.schoolmanagement.util.SERVICES;

public class UserFacad implements UserFacadInterface{
    private final DBConnectionInterface dbconnection;
    private final ServiceInterface<UserDTO,Integer> userService;
    private final AuthserviceInterface authservice;
    public UserFacad(){
        System.out.println("error one");
        this.dbconnection = DBFactory.getDataBase(DATABASETYPES.MYSQL);
        System.out.println("error two");
        this.userService = ServiceFactory.getService(SERVICES.USERSERVICE, dbconnection.getConnection(), "sql");
        System.out.println("error three");
        this.authservice =ServiceFactory.getService(SERVICES.AUTHSERVICE, dbconnection.getConnection(), "sql");
        System.out.println("error 4");
    }
    public boolean addUser(UserDTO user){
        if (authservice.isUsernameTaken(user)) {
            AlertMessage.getInstance().setMessage("User Name Already Taken");
            return false;
        }else{
            try {
                userService.register(user);
                return true;
            } catch (Exception e) {
                // TODO: handle exception
                AlertMessage.getInstance().setMessage("User Registration failed");
                e.printStackTrace();
                return false;
            }
        }
        
    }
    public boolean updateUser(UserDTO user){
        try {
            return userService.update(user);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    public UserDTO getUserbyName(String username){
        return userService.find(username);
    }
    public boolean deleteUser(int id){
        try {
            return userService.delete(id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    public boolean authenticate(UserDTO user){
        return authservice.authenticateUser(user);
    }
    
}
