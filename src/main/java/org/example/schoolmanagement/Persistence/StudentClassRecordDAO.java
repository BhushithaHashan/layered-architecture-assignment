package org.example.schoolmanagement.Persistence;

import java.sql.Connection;
import java.util.List;

import org.example.schoolmanagement.dto.StudentClassRecord;
import org.example.schoolmanagement.util.DatabaseExecutor;
import org.example.schoolmanagement.util.SQLExecutor;

public class StudentClassRecordDAO implements CrudDAO<StudentClassRecord,Integer>{
    private final DatabaseExecutor queryExecutor;
    public StudentClassRecordDAO(Connection connection,String executor){
        if (executor.equalsIgnoreCase("sql")) {
            this.queryExecutor = new SQLExecutor(connection);
        }else{
            this.queryExecutor = new SQLExecutor(connection);
        }
    }

    @Override
    public boolean save(StudentClassRecord entity) {
        String sql = "INSERT INTO student_class_record (student_id, class_id) VALUES (?, ?)";
        try {
            return queryExecutor.executeUpdate(sql,entity.getStudentID(),entity.getClassID())>0;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
        
        
    }

    @Override
    public StudentClassRecord findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(StudentClassRecord entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<StudentClassRecord> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public boolean isExist(StudentClassRecord entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExist'");
    }

    @Override
    public StudentClassRecord findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

}
