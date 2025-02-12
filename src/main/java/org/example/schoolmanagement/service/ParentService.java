package org.example.schoolmanagement.service;

import java.util.List;

import org.example.schoolmanagement.Persistence.CrudDAO;
import org.example.schoolmanagement.dto.Parent;
import org.example.schoolmanagement.dto.Student;

public class ParentService implements ServiceInterface<Parent,Integer>{
    private CrudDAO<Parent,Integer> parentDao;

    public ParentService(CrudDAO<Parent,Integer> dao){
        this.parentDao = dao;
    }

    @Override
    public boolean register(Parent entity) {
        // TODO Auto-generated method stub
        return parentDao.save(entity);
    }

    @Override
    public boolean delete(Integer id) {
       return parentDao.delete(id);
    }

    @Override
    public Parent find(Integer id) {
        return parentDao.findById(id);
                                                                                                                    }

    @Override
    public boolean update(Parent entity) {
        return parentDao.update(entity);
    }

    @Override
    public List<Parent> getAll() {
        return parentDao.getAll();
    }

    @Override
    public boolean isExist(Parent entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExist'");
    }

    @Override
    public Parent find(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

}
