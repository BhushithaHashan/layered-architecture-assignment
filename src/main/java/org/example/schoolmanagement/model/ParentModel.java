package org.example.schoolmanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.schoolmanagement.dto.Parent;
import org.example.schoolmanagement.util.DBConnection;

public class ParentModel {

    // Method to get a parent by ID
    public Parent getParentById(int parentId) {
        String query = "SELECT * FROM parent WHERE parent_id = ?";
        Parent parent = null;
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, parentId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    parent = new Parent(
                            resultSet.getInt("parent_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving parent by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return parent;
    }

    // Method to insert a new parent
    public boolean addParent(Parent parent) {
        String query = "INSERT INTO parent (first_name, last_name, email) VALUES (?, ?, ?)";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, parent.getFirstName());
            stmt.setString(2, parent.getLastName());
            stmt.setString(3, parent.getEmail());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding parent: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Method to update a parent’s information
    public boolean updateParent(Parent parent) {
        String query = "UPDATE parent SET first_name = ?, last_name = ?, email = ? WHERE parent_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, parent.getFirstName());
            stmt.setString(2, parent.getLastName());
            stmt.setString(3, parent.getEmail());
            stmt.setInt(4, parent.getParentId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating parent: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete a parent
    public boolean deleteParent(int parentId) {
        String query = "DELETE FROM parent WHERE parent_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, parentId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting parent: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Method to get all parents
    public List<Parent> getAllParents() {
        String query = "SELECT * FROM parent";
        List<Parent> parents = new ArrayList<>();
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Parent parent = new Parent(
                        resultSet.getInt("parent_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email")
                );
                parents.add(parent);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving all parents: " + e.getMessage());
            e.printStackTrace();
        }
        return parents;
    }
}
