package org.example.schoolmanagement.Persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.example.schoolmanagement.dto.Student;
import org.example.schoolmanagement.util.DatabaseExecutor;
import org.example.schoolmanagement.util.SQLExecutor;

public class StudentDAO implements CrudDAO<Student,Integer>{
    private final DatabaseExecutor queryExecutor;
    public StudentDAO(Connection connection,String executor){
        if (executor.equalsIgnoreCase("sql")) {
            this.queryExecutor = new SQLExecutor(connection);
        }else{
            this.queryExecutor = new SQLExecutor(connection);
        }
    }
    public boolean save(Student entity){
        String query = "INSERT INTO student (first_name, last_name, dob) VALUES (?, ?, ?)";
        try {
            return queryExecutor.executeUpdate(query, entity.getFirstName(),entity.getLastName(),entity.getDob()) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Student findById(Integer id){
            String query = "SELECT * FROM student WHERE student_id = ?";
            try{
                ResultSet rs = queryExecutor.executeQuery(query,id);
                if (rs.next()) {
                    return new Student(rs.getInt("student_id"),rs.getString("first_name"),rs.getString("last_name"),rs.getDate("dob"),rs.getDate("registered_date"));
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            return null;
    }
    public boolean update(Student entity){
        
            String sql = "UPDATE student SET first_name = ?, last_name = ?, dob = ? WHERE student_id = ?";
            try {
                return queryExecutor.executeUpdate(sql, entity.getFirstName(), entity.getLastName(), entity.getDob(),entity.getStudentID()) > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        
    }
    public boolean delete(Integer id){
        String sql = "DELETE FROM student WHERE id = ?";
        try {
            return queryExecutor.executeUpdate(sql, id) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Student> getAll(){
         String sql = "SELECT * FROM student";
        try {
            ResultSet rs = queryExecutor.executeQuery(sql);
            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                students.add(new Student(rs.getInt("student_id"), rs.getString("first_name"), rs.getString("last_name"),rs.getDate("dob"),rs.getDate("registered_date")));
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
