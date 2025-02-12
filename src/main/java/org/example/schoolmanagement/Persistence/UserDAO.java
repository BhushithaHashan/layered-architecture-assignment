package org.example.schoolmanagement.Persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.example.schoolmanagement.dto.UserDTO;
import org.example.schoolmanagement.util.DatabaseExecutor;
import org.example.schoolmanagement.util.Role;
import org.example.schoolmanagement.util.SQLExecutor;

public class UserDAO implements CrudDAO<UserDTO,Integer>{
    private DatabaseExecutor executor;
    public UserDAO(Connection connection,String executor){
        if(executor.equalsIgnoreCase("sql")){
            this.executor = new SQLExecutor(connection);
        }else{
            this.executor = new SQLExecutor(connection);
        }
    }
    @Override
    public boolean save(UserDTO entity) {
        String query = "INSERT INTO user (username, email, password, role, specific_attribute) VALUES (?, ?, ?, ?, ?)";
        try {
            return executor.executeUpdate(query,entity.getUsername(),entity.getEmail(),entity.getPassword(),Role.ADMIN.getRole(),null)>0;
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            System.err.println("Error adding user: " + e.getMessage());
            return false;
        }
    }

    @Override
    public UserDTO findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(UserDTO entity) {
        String query = "UPDATE user SET username = ?, email = ?, password = ?, role = ?, specific_attribute = ? WHERE user_id = ?";
        try {
            return executor.executeUpdate(query,entity.getUsername(),entity.getEmail(),entity.getPassword(),entity.getRole(),entity.getSpecificAttribute(),entity.getUserId())>0;
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        String query = "DELETE FROM user WHERE user_id = ?";
        try {
            return executor.executeUpdate(query,id)>0;
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<UserDTO> getAll() {
        String query = "SELECT * FROM user";
        try {
            ResultSet rs = executor.executeQuery(query);
            List<UserDTO> users = new ArrayList<>();
            while (rs.next()) {
                users.add(new UserDTO(rs.getInt("user_id"),rs.getString("username"),rs.getString("email"),rs.getString("password"),Role.ADMIN,null));
            }
            return users;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            
        }
        return Collections.emptyList();
    }
    @Override
    public boolean isExist(UserDTO entity) {
        // TODO Auto-generated method stub
        if(entity == null){
            return false;
        }
        String query = "SELECT COUNT(*) FROM user WHERE username = ?";
        try {
            ResultSet rs = executor.executeQuery(query, entity.getUsername());
            if (rs.next()) {
                return rs.getInt(1)>0;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public UserDTO findByName(String name) {
        String query ="SELECT * FROM user WHERE username = ?";
        try {
            ResultSet rs = executor.executeQuery(query, name);
            if (rs.next()) {
                return new UserDTO(rs.getInt("user_id"),rs.getString("username"),rs.getString("email"), rs.getString("password"),Role.ADMIN, null);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            
        }
        return null;
    }

}
