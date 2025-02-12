package org.example.schoolmanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.schoolmanagement.dto.StudentClassRecord;
import org.example.schoolmanagement.util.DBConnection;

public class StudentClassRecordModel {

    // Method to add a new student-class record
    public boolean addStudentClassRecord(StudentClassRecord record) {
        String query = "INSERT INTO student_class_record (student_id, class_id) VALUES (?, ?)";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, record.getStudentID());
            stmt.setInt(2, record.getClassID());


            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding student-class record: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Method to get a student-class record by student_class_record_id
    public StudentClassRecord getStudentClassRecordById(int studentClassRecordID) {
        String query = "SELECT * FROM student_class_record WHERE student_class_record_id = ?";
        StudentClassRecord record = null;
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentClassRecordID);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    record = new StudentClassRecord(
                            resultSet.getInt("student_class_record_id"),
                            resultSet.getInt("student_id"),
                            resultSet.getInt("class_id"),
                            resultSet.getInt("year")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving student-class record by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return record;
    }

    // Method to get all student-class records
    public List<StudentClassRecord> getAllStudentClassRecords() {
        List<StudentClassRecord> records = new ArrayList<>();
        String query = "SELECT * FROM student_class_record";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                StudentClassRecord record = new StudentClassRecord(
                        resultSet.getInt("student_class_record_id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("class_id"),
                        resultSet.getInt("year")
                );
                records.add(record);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving all student-class records: " + e.getMessage());
            e.printStackTrace();
        }
        return records;
    }

    // Method to update a student-class record
    public boolean updateStudentClassRecord(StudentClassRecord record) {
        String query = "UPDATE student_class_record SET student_id = ?, class_id = ?, year = ? WHERE student_class_record_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, record.getStudentID());
            stmt.setInt(2, record.getClassID());
            stmt.setInt(3, record.getYear());
            stmt.setInt(4, record.getStudentClassRecordID());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating student-class record: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete a student-class record
    public boolean deleteStudentClassRecord(int studentClassRecordID) {
        String query = "DELETE FROM student_class_record WHERE student_class_record_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentClassRecordID);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting student-class record: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // New method: Get records by student ID
    public List<StudentClassRecord> getRecordsByStudentID(int studentID) {
        List<StudentClassRecord> records = new ArrayList<>();
        String query = "SELECT student_class_record_id, student_id, class_id, year FROM student_class_record WHERE student_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentID);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                records.add(new StudentClassRecord(
                        resultSet.getInt("student_class_record_id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("class_id"),
                        resultSet.getInt("year")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching records by student ID: " + e.getMessage());
            e.printStackTrace();
        }
        return records;
    }

    // New method: Get records by class ID
    public List<StudentClassRecord> getRecordsByClassID(int classID) {
        List<StudentClassRecord> records = new ArrayList<>();
        String query = "SELECT student_class_record_id, student_id, class_id, year FROM student_class_record WHERE class_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, classID);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                records.add(new StudentClassRecord(
                        resultSet.getInt("student_class_record_id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("class_id"),
                        resultSet.getInt("year")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching records by class ID: " + e.getMessage());
            e.printStackTrace();
        }
        return records;
    }

    // New method: Get records by class ID and year
    public List<StudentClassRecord> getRecordsByClassIDAndYear(int classID, int year) {
        List<StudentClassRecord> records = new ArrayList<>();
        String query = "SELECT student_class_record_id, student_id, class_id, year FROM student_class_record WHERE class_id = ? AND year = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, classID);
            stmt.setInt(2, year);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                records.add(new StudentClassRecord(
                        resultSet.getInt("student_class_record_id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("class_id"),
                        resultSet.getInt("year")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching records by class ID and year: " + e.getMessage());
            e.printStackTrace();
        }
        return records;
    }
}
