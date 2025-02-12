package org.example.schoolmanagement.service;

import java.util.List;

import org.example.schoolmanagement.Persistence.CrudDAO;
import org.example.schoolmanagement.dto.ClassDTO;

public class ClassService implements ServiceInterface<ClassDTO,Integer>{
    private CrudDAO<ClassDTO,Integer> classDAO;
    public ClassService(CrudDAO<ClassDTO,Integer> classDao){
        this.classDAO = classDao;
    }
    @Override
    public boolean register(ClassDTO entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }
    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @Override
    public ClassDTO find(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }
    @Override
    public boolean update(ClassDTO entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public List<ClassDTO> getAll() {
        return classDAO.getAll();
    }
    @Override
    public boolean isExist(ClassDTO entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExist'");
    }
    @Override
    public ClassDTO find(String name) {
        return classDAO.findByName(name);
    }
    
}
