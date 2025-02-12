package org.example.schoolmanagement.Persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.example.schoolmanagement.dto.ClassDTO;
import org.example.schoolmanagement.dto.UserDTO;
import org.example.schoolmanagement.util.DatabaseExecutor;
import org.example.schoolmanagement.util.Role;
import org.example.schoolmanagement.util.SQLExecutor;

public class ClassDAO implements CrudDAO<ClassDTO,Integer>{
    private final DatabaseExecutor executor;

    public ClassDAO(Connection connection, String executor) {
        if(executor.equalsIgnoreCase("sql")){
            this.executor = new SQLExecutor(connection);
        }else{
            this.executor = new SQLExecutor(connection);
        }
    }

    @Override
    public boolean save(ClassDTO entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public ClassDTO findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(ClassDTO entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<ClassDTO> getAll() {
        String query = "SELECT * FROM class";
        try {
            ResultSet rs = executor.executeQuery(query);
            List<ClassDTO> classes = new ArrayList<>();
            while (rs.next()) {
                //(int classId, String className, String section, int maxStudents, Integer gradeId, Integer streamId)
                classes.add(new ClassDTO(rs.getInt("class_id"),rs.getString("class_name"),rs.getString("section"),rs.getInt("max_students"),rs.getInt("grade_id"),rs.getInt("stream_id")));
            }
            return classes;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            
        }
        return Collections.emptyList();
    }

    @Override
    public boolean isExist(ClassDTO entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExist'");
    }

    @Override
    public ClassDTO findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

}
