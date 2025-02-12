package org.example.schoolmanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.schoolmanagement.dto.StudentParent;
import org.example.schoolmanagement.util.DBConnection;

public class StudentParentModel {

    // Method to link a student with a parent
    public boolean addStudentParent(StudentParent studentParent) {
        String query = "INSERT INTO student_parent (student_id, parent_id) VALUES (?, ?)";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, studentParent.getStudentId());
            stmt.setInt(2, studentParent.getParentId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding student-parent relationship: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    public boolean deleteStudentParent(int studentId, int parentId) {
        String query = "DELETE FROM student_parent WHERE student_id = ? AND parent_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, studentId);
            stmt.setInt(2, parentId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting student-parent relationship: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
