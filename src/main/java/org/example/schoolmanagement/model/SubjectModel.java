package org.example.schoolmanagement.model;

import org.example.schoolmanagement.dto.SubjectDTO;
import org.example.schoolmanagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SubjectModel {


    public List<SubjectDTO> getAllSubjects() {
        List<SubjectDTO> subjects = new ArrayList<>();
        String query = "SELECT * FROM subject";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int subjectId = resultSet.getInt("subject_id");
                String subjectName = resultSet.getString("subject_name");
                subjects.add(new SubjectDTO(subjectId, subjectName));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching all subjects: " + e.getMessage());
        }

        return subjects;
    }


    public SubjectDTO getSubjectById(int subjectId) {
        String query = "SELECT * FROM subject WHERE subject_id = ?";
        SubjectDTO subject = null;

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, subjectId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String subjectName = resultSet.getString("subject_name");
                subject = new SubjectDTO(subjectId, subjectName);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching subject by ID: " + e.getMessage());
        }

        return subject;
    }

    /**
     * Adds a new subject to the database.
     *
     * @param subjectDTO The SubjectDTO object to add.
     * @return True if the insertion was successful, otherwise false.
     */
    public boolean addSubject(SubjectDTO subjectDTO) {
        String query = "INSERT INTO subject (subject_name) VALUES (?)";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, subjectDTO.getSubjectName());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error adding subject: " + e.getMessage());
        }

        return false;
    }

    /**
     * Updates an existing subject in the database.
     *
     * @param subjectDTO The SubjectDTO object with updated data.
     * @return True if the update was successful, otherwise false.
     */
    public boolean updateSubject(SubjectDTO subjectDTO) {
        String query = "UPDATE subject SET subject_name = ? WHERE subject_id = ?";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, subjectDTO.getSubjectName());
            preparedStatement.setInt(2, subjectDTO.getSubjectId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error updating subject: " + e.getMessage());
        }

        return false;
    }

    /**
     * Deletes a subject from the database by its ID.
     *
     * @param subjectId The ID of the subject to delete.
     * @return True if the deletion was successful, otherwise false.
     */
    public boolean deleteSubject(int subjectId) {
        String query = "DELETE FROM subject WHERE subject_id = ?";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, subjectId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting subject: " + e.getMessage());
        }

        return false;
    }
}
