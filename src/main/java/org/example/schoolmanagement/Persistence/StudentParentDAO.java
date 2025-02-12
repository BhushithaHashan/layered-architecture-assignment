package org.example.schoolmanagement.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.example.schoolmanagement.dto.StudentParent;
import org.example.schoolmanagement.util.DBConnection;
import org.example.schoolmanagement.util.DatabaseExecutor;
import org.example.schoolmanagement.util.SQLExecutor;

public class StudentParentDAO implements CrudDAO<StudentParent,Integer>{

    private final DatabaseExecutor queryExecutor;
    public StudentParentDAO(Connection connection,String executor){
        if (executor.equalsIgnoreCase("sql")) {
            this.queryExecutor = new SQLExecutor(connection);
        }else{
            this.queryExecutor = new SQLExecutor(connection);
        }
    }
    @Override
    public boolean save(StudentParent entity) {
        String sql = "INSERT INTO student_parent (student_id, parent_id) VALUES (?, ?)";
        try{
            return queryExecutor.executeUpdate(sql,entity.getStudentId(),entity.getParentId())>0;
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return false;
    }
    @Override
    public StudentParent findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    @Override
    public boolean update(StudentParent entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
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
    @Override
    public StudentParent findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }
    

}
