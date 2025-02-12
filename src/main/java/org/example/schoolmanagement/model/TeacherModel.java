package org.example.schoolmanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.schoolmanagement.dto.Teacher;
import org.example.schoolmanagement.util.DBConnection;

public class TeacherModel {

    // Method to add a new teacher
    public boolean addTeacher(Teacher teacher) {
        String query = "INSERT INTO teacher (first_name, last_name, subject_id, is_class_teacher) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, teacher.getFirstName());
            stmt.setString(2, teacher.getLastName());
            stmt.setInt(3, teacher.getSubjectID()); // Assumes subjectID is never null
            stmt.setBoolean(4, teacher.isAClassTeacher());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding teacher: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Method to get a teacher by ID
    public Teacher getTeacherById(int teacherId) {
        String query = "SELECT * FROM teacher WHERE teacher_id = ?";
        Teacher teacher = null;
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, teacherId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    teacher = new Teacher();
                    teacher.setTeacherID(resultSet.getInt("teacher_id"));
                    teacher.setFirstName(resultSet.getString("first_name"));
                    teacher.setLastName(resultSet.getString("last_name"));
                    teacher.setSubjectID(resultSet.getInt("subject_id"));
                    teacher.setIsAClassTeacher(resultSet.getBoolean("is_class_teacher"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving teacher by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return teacher;
    }

    // Method to get all teachers
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        String query = "SELECT * FROM teacher";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherID(resultSet.getInt("teacher_id"));
                teacher.setFirstName(resultSet.getString("first_name"));
                teacher.setLastName(resultSet.getString("last_name"));
                teacher.setSubjectID(resultSet.getInt("subject_id"));
                teacher.setIsAClassTeacher(resultSet.getBoolean("is_class_teacher"));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving all teachers: " + e.getMessage());
            e.printStackTrace();
        }
        return teachers;
    }

    // Method to update a teacher's information
    public boolean updateTeacher(Teacher teacher) {
        String query = "UPDATE teacher SET first_name = ?, last_name = ?, subject_id = ?, is_class_teacher = ? WHERE teacher_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, teacher.getFirstName());
            stmt.setString(2, teacher.getLastName());
            stmt.setInt(3, teacher.getSubjectID());
            stmt.setBoolean(4, teacher.isAClassTeacher());
            stmt.setInt(5, teacher.getTeacherID());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating teacher: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete a teacher by ID
    public boolean deleteTeacher(int teacherId) {
        String query = "DELETE FROM teacher WHERE teacher_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, teacherId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting teacher: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
