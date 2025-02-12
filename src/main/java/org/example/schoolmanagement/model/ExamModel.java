package org.example.schoolmanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.example.schoolmanagement.dto.ExamDto;
import org.example.schoolmanagement.util.DBConnection;

public class ExamModel {


    public boolean addExam(ExamDto exam) {
        String query = "INSERT INTO exam (exam_name, class_id, term_id, subject_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, exam.getExamName());
            stmt.setInt(2, exam.getClassId());
            stmt.setInt(3, exam.getTermId());
            stmt.setInt(4, exam.getSubjectId());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error adding exam: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    public List<ExamDto> getAllExams() {
        String query = "SELECT * FROM exam";
        List<ExamDto> exams = new ArrayList<>();
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                ExamDto exam = new ExamDto();
                exam.setExamId(rs.getInt("exam_id"));
                exam.setExamName(rs.getString("exam_name"));
                exam.setClassId(rs.getInt("class_id"));
                exam.setTermId(rs.getInt("term_id"));
                exam.setSubjectId(rs.getInt("subject_id"));
                exams.add(exam);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving all exams: " + e.getMessage());
            e.printStackTrace();
        }
        return exams;
    }


    public Integer getExamIdByClassSubjectAndTerm(int classId, int subjectId, int termId) {
        String query = "SELECT exam_id FROM exam WHERE class_id = ? AND subject_id = ? AND term_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, classId);
            stmt.setInt(2, subjectId);
            stmt.setInt(3, termId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("exam_id");
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving exam ID: " + e.getMessage());
            e.printStackTrace();
        }
        return null; // Return null if no matching exam is found
    }
}
