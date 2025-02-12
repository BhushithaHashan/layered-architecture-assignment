package org.example.schoolmanagement.service;

import java.util.List;

import org.example.schoolmanagement.Persistence.CrudDAO;
import org.example.schoolmanagement.dto.StudentClassRecord;
import org.example.schoolmanagement.dto.StudentParent;

public class StudentParentService implements ServiceInterface<StudentParent,Integer>{
    private CrudDAO<StudentParent,Integer> StudentParentDAO;
    

    public StudentParentService(CrudDAO<StudentParent,Integer> studentParentDAO){
        this.StudentParentDAO = studentParentDAO;

    } 
    @Override
    public boolean register(StudentParent entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public StudentParent find(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public StudentParent find(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public boolean update(StudentParent entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<StudentParent> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public boolean isExist(StudentParent entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExist'");
    }

}
