package org.example.schoolmanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.schoolmanagement.dto.ClassDTO;
import org.example.schoolmanagement.util.DBConnection;

public class ClassModel {

    public boolean addClass(ClassDTO classDTO) {
        String query = "INSERT INTO class (class_name, section, max_students, grade_id, stream_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, classDTO.getClassName());
            stmt.setString(2, classDTO.getSection());
            stmt.setInt(3, classDTO.getMaxStudents());
            stmt.setObject(4, classDTO.getGradeId());
            stmt.setObject(5, classDTO.getStreamId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding class: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public ClassDTO getClassById(int classId) {
        String query = "SELECT * FROM class WHERE class_id = ?";
        ClassDTO classDTO = null;
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, classId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    classDTO = new ClassDTO(
                            resultSet.getInt("class_id"),
                            resultSet.getString("class_name"),
                            resultSet.getString("section"),
                            resultSet.getInt("max_students"),
                            (Integer) resultSet.getObject("grade_id"),
                            (Integer) resultSet.getObject("stream_id")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving class by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return classDTO;
    }

    public List<ClassDTO> getAllClasses() {
        List<ClassDTO> classes = new ArrayList<>();
        String query = "SELECT * FROM class";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                ClassDTO classDTO = new ClassDTO(
                        resultSet.getInt("class_id"),
                        resultSet.getString("class_name"),
                        resultSet.getString("section"),
                        resultSet.getInt("max_students"),
                        (Integer) resultSet.getObject("grade_id"),
                        (Integer) resultSet.getObject("stream_id")
                );
                classes.add(classDTO);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving all classes: " + e.getMessage());
            e.printStackTrace();
        }
        return classes;
    }

    public boolean updateClass(ClassDTO classDTO) {
        String query = "UPDATE class SET class_name = ?, section = ?, max_students = ?, grade_id = ?, stream_id = ? WHERE class_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, classDTO.getClassName());
            stmt.setString(2, classDTO.getSection());
            stmt.setInt(3, classDTO.getMaxStudents());
            stmt.setObject(4, classDTO.getGradeId());
            stmt.setObject(5, classDTO.getStreamId());
            stmt.setInt(6, classDTO.getClassId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating class: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteClass(int classId) {
        String query = "DELETE FROM class WHERE class_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, classId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting class: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public Integer getClassIdByName(String className) {
        String query = "SELECT class_id FROM class WHERE class_name = ?";
        Integer classId = null;

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, className);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    classId = resultSet.getInt("class_id");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error fetching class ID: " + e.getMessage());
            e.printStackTrace();
        }

        return classId;
    }
}
