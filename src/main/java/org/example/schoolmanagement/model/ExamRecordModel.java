package org.example.schoolmanagement.model;

import org.example.schoolmanagement.dto.ExamRecordDTO;
import org.example.schoolmanagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamRecordModel {


    public List<ExamRecordDTO> getExamMarks(int year, int classId, int termId, int subjectId) {
        List<ExamRecordDTO> records = new ArrayList<>();
        String query = "SELECT sr.student_id, er.exam_id, er.marks " +
                "FROM exam_record er " +
                "JOIN exam e ON er.exam_id = e.exam_id " +
                "JOIN student_class_record sr ON sr.student_id = er.student_id " +
                "WHERE e.year = ? AND e.class_id = ? AND e.term_id = ? AND e.subject_id = ?";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, year);
            preparedStatement.setInt(2, classId);
            preparedStatement.setInt(3, termId);
            preparedStatement.setInt(4, subjectId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                int examId = resultSet.getInt("exam_id");
                int marks = resultSet.getInt("marks");
                records.add(new ExamRecordDTO(studentId, examId, marks));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching exam marks: " + e.getMessage());
        }
        return records;
    }


    public boolean updateExamMarks(ExamRecordDTO examRecordDTO) {
        String query = "UPDATE exam_record SET marks = ? WHERE student_id = ? AND exam_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, examRecordDTO.getMarks());
            preparedStatement.setInt(2, examRecordDTO.getStudentId());
            preparedStatement.setInt(3, examRecordDTO.getExamId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error updating exam marks: " + e.getMessage());
        }
        return false;
    }


    public boolean deleteExamMarks(int studentId, int examId) {
        String query = "DELETE FROM exam_record WHERE student_id = ? AND exam_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, examId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting exam marks: " + e.getMessage());
        }
        return false;
    }


    public boolean setExamMarks(int examId, List<ExamRecordDTO> examRecords) {
        String query = "INSERT INTO exam_record (student_id, exam_id, marks) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (ExamRecordDTO record : examRecords) {
                preparedStatement.setInt(1, record.getStudentId());
                preparedStatement.setInt(2, examId);
                preparedStatement.setInt(3, record.getMarks());
                preparedStatement.addBatch();
            }

            int[] results = preparedStatement.executeBatch();
            return results.length > 0;

        } catch (SQLException e) {
            System.out.println("Error setting exam marks: " + e.getMessage());
        }
        return false;
    }
}
