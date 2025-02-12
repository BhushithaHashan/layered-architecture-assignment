package org.example.schoolmanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.schoolmanagement.dto.UserDTO;
import org.example.schoolmanagement.util.DBConnection;
import org.example.schoolmanagement.util.Role;

public class UserModel {

    // Method to retrieve user by username (for login purposes)
    public UserDTO getUserByUsername(String username) {
        String query = "SELECT * FROM user WHERE username = ?";
        UserDTO userDTO = null;

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, username);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    Role role = Role.valueOf(resultSet.getString("role").toUpperCase()); // Convert to enum
                    userDTO = new UserDTO(
                            resultSet.getInt("user_id"),
                            resultSet.getString("username"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            role, // Set the role as enum
                            resultSet.getObject("specific_attribute", Integer.class) // Nullable
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching user: " + e.getMessage());
            e.printStackTrace();
        }

        return userDTO;
    }

    // Method to verify user credentials during login
    public boolean verifyCredentials(String username, String password) {
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet resultSet = stmt.executeQuery()) {
                return resultSet.next(); // If there's a result, credentials are valid
            }
        } catch (SQLException e) {
            System.err.println("Error verifying credentials: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    // Method to add a new user
    public boolean addUser(UserDTO userDTO) {
        String query = "INSERT INTO user (username, email, password, role, specific_attribute) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, userDTO.getUsername());
            stmt.setString(2, userDTO.getEmail());
            stmt.setString(3, userDTO.getPassword());
            stmt.setString(4, userDTO.getRole().getRole()); // Convert Role to String for DB
            stmt.setObject(5, userDTO.getSpecificAttribute()); // Nullable

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding user: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    // Method to delete a user by user_id
    public boolean deleteUser(int userId) {
        String query = "DELETE FROM user WHERE user_id = ?";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, userId);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting user: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    // Method to update a user
    public boolean updateUser(UserDTO userDTO) {
        String query = "UPDATE user SET username = ?, email = ?, password = ?, role = ?, specific_attribute = ? WHERE user_id = ?";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, userDTO.getUsername());
            stmt.setString(2, userDTO.getEmail());
            stmt.setString(3, userDTO.getPassword());
            stmt.setString(4, userDTO.getRole().getRole()); // Convert Role to String for DB
            stmt.setObject(5, userDTO.getSpecificAttribute()); // Nullable
            stmt.setInt(6, userDTO.getUserId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating user: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    // Method to retrieve all users
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        String query = "SELECT * FROM user";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Role role = Role.valueOf(resultSet.getString("role").toUpperCase()); // Convert to enum
                UserDTO userDTO = new UserDTO(
                        resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        role, // Set the role as enum
                        resultSet.getObject("specific_attribute", Integer.class) // Nullable
                );
                users.add(userDTO);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving all users: " + e.getMessage());
            e.printStackTrace();
        }

        return users;
    }
}

