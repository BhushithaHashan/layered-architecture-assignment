package org.example.schoolmanagement.model;

import org.example.schoolmanagement.util.DBConnection;
import org.example.schoolmanagement.dto.TermDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TermModel {

    /**
     * Fetches a list of terms for a specific year.
     *
     * @param year The year for which terms are fetched.
     * @return A list of TermDTO objects.
     */
    public List<TermDTO> getTermsByYear(int year) {
        List<TermDTO> terms = new ArrayList<>();
        String query = "SELECT * FROM term WHERE year = ?";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, year);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int termId = resultSet.getInt("term_id");
                String termName = resultSet.getString("term_name");
                terms.add(new TermDTO(termId, termName, year));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching terms for year " + year + ": " + e.getMessage());
        }

        return terms;
    }

    /**
     * Fetches all terms in the database.
     *
     * @return A list of TermDTO objects.
     */
    public List<TermDTO> getAllTerms() {
        List<TermDTO> terms = new ArrayList<>();
        String query = "SELECT * FROM term";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int termId = resultSet.getInt("term_id");
                String termName = resultSet.getString("term_name");
                int year = resultSet.getInt("year");
                terms.add(new TermDTO(termId, termName, year));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching all terms: " + e.getMessage());
        }

        return terms;
    }

    /**
     * Inserts a new term into the database.
     *
     * @param termDTO The TermDTO object to insert.
     * @return True if the insertion was successful, otherwise false.
     */
    public boolean addTerm(TermDTO termDTO) {
        String query = "INSERT INTO term (term_name, year) VALUES (?, ?)";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, termDTO.getTermName());
            preparedStatement.setInt(2, termDTO.getYear());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error adding term: " + e.getMessage());
        }

        return false;
    }
}
