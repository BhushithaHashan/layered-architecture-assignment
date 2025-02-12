package org.example.schoolmanagement.service;

import java.sql.Connection;
import java.util.List;

import org.example.schoolmanagement.Persistence.CrudDAO;
import org.example.schoolmanagement.Persistence.ParentDAO;
import org.example.schoolmanagement.Persistence.StudentDAO;
import org.example.schoolmanagement.dto.Student;

public class StudentService implements ServiceInterface<Student,Integer>{
    private CrudDAO<Student,Integer> studentDAO;
    public StudentService(CrudDAO<Student,Integer> studentDAO){
        this.studentDAO = studentDAO;
    }
    public boolean register(Student student){
        return studentDAO.save(student);
    }
    public boolean delete(Integer ID){
        return studentDAO.delete(ID);
    }
    public Student find(Integer ID){
        return studentDAO.findById(ID);
    }
    public boolean update(Student student){
        return studentDAO.update(student);
    }
    public List<Student> getAll(){
        return studentDAO.getAll();
    }
    @Override
    public boolean isExist(Student entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExist'");
    }
    @Override
    public Student find(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }
    
    
    
}
