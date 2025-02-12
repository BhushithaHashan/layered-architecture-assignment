package org.example.schoolmanagement.service;

import java.util.List;

import org.checkerframework.checker.units.qual.s;
import org.example.schoolmanagement.Persistence.CrudDAO;
import org.example.schoolmanagement.dto.ClassDTO;
import org.example.schoolmanagement.dto.UserDTO;
import org.example.schoolmanagement.util.AlertMessage;
import org.example.schoolmanagement.util.SERVICES;

public class UserService implements ServiceInterface<UserDTO,Integer>{

    private CrudDAO<UserDTO,Integer> userDAO;
    private ValidatorInterface validator = ServiceFactory.getService(SERVICES.VALIDATESERVICE, null, null);

    public UserService(CrudDAO<UserDTO,Integer> userDAO){
        this.userDAO = userDAO;

    }


    @Override
    public boolean register(UserDTO entity) {
        if (validator.isEmpty(entity.getEmail())||validator.isEmpty(entity.getPassword())||validator.isEmpty(entity.getUsername())) {
            AlertMessage.getInstance().setMessage("null");
            return false;        
        }
        return userDAO.save(entity);
    }

    @Override
    public boolean delete(Integer id) {
        return userDAO.delete(id);
    }

    @Override
    public UserDTO find(Integer id) {
        if (userDAO.findById(id)==null) {
            AlertMessage.getInstance().setMessage("No User Found Under the ID");
        }
        return userDAO.findById(id);
    }
    public UserDTO find(String name){
        if (userDAO.findByName(name)==null) {
            AlertMessage.getInstance().setMessage("No User Found Under the Name");
        }
        return userDAO.findByName(name);
    }

    @Override
    public boolean update(UserDTO entity) {
        boolean state =userDAO.update(entity);
        if (state) {
            AlertMessage.getInstance().setMessage("Update Sucessfull");
            return state;
        }else{
            AlertMessage.getInstance().setMessage("Update Failed");
            return state;
        }
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> list = userDAO.getAll() ;
        if (list.isEmpty()) {
            AlertMessage.getInstance().setMessage("No results Found");
            return list;
        }else{
            return list;
        }
        
    }


    @Override
    public boolean isExist(UserDTO entity) {
        // TODO Auto-generated method stub
        boolean state = userDAO.isExist(entity);
        if (state) {
            AlertMessage.getInstance().setMessage("User Exist");
            return state;
        }else{
            AlertMessage.getInstance().setMessage("User Not Exist");
            return state;
        }
    }

}
