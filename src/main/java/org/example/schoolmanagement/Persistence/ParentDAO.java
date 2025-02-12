package org.example.schoolmanagement.Persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.example.schoolmanagement.dto.Parent;
import org.example.schoolmanagement.util.DatabaseExecutor;
import org.example.schoolmanagement.util.SQLExecutor;

public class ParentDAO implements CrudDAO<Parent,Integer>{
    private DatabaseExecutor executor;
    public ParentDAO(Connection connection,String executor){
        if (executor.equalsIgnoreCase("sql")) {
            this.executor = new SQLExecutor(connection);
        }else{
            this.executor = new SQLExecutor(connection);
        }
    }
    @Override
    public boolean save(Parent entity) {
        String sql = "INSERT INTO parent (first_name, last_name, email) VALUES (?, ?, ?)";
        try {
            return executor.executeUpdate(sql,entity.getFirstName(),entity.getLastName(),entity.getEmail())>0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Parent findById(Integer id) {
        String sql = "SELECT * FROM parent WHERE parent_id = ?";
        try {
            ResultSet rs= executor.executeQuery(sql, id);
            if (rs.next()) {
                return new Parent(rs.getInt("parent_id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("email"));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Parent entity) {
        String sql = "UPDATE parent SET first_name = ?, last_name = ?, email = ? WHERE parent_id = ?";
        try {
            return executor.executeUpdate(sql, entity.getFirstName(),entity.getLastName(),entity.getEmail(),entity.getParentId())>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM parent WHERE parent_id = ?";
        try {
            return executor.executeUpdate(sql, id)>0;
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Parent> getAll() {
        // TODO Auto-generated method stub
         String sql = "SELECT * FROM parent";
        try {
            ResultSet rs = executor.executeQuery(sql);
            List<Parent> parents = new ArrayList<>();
            while (rs.next()) {
                parents.add(new Parent(rs.getInt("parent_id"), rs.getString("first_name"), rs.getString("last_name"),rs.getString("emial")));
            }
            return parents;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    @Override
    public boolean isExist(Parent entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isExist'");
    }
    
    
    @Override
    public Parent findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }
    
}
