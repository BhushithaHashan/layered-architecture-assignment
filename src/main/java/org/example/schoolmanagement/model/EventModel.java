package org.example.schoolmanagement.model;

import org.example.schoolmanagement.dto.Event;
import org.example.schoolmanagement.util.DBConnection;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EventModel {

    // Method to add a new event to the database
    public boolean addEvent(Event event) {
        String query = "INSERT INTO event (user_id, event_type) VALUES (?, ?)";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            if (event.getUserId() == null) {
                stmt.setNull(1, Types.INTEGER); // Handle null userId
            } else {
                stmt.setInt(1, event.getUserId());
            }
            stmt.setString(2, event.getEventType());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            logError("Error adding event", e);
            return false;
        }
    }

    // Method to retrieve paginated events from the database
    public List<Event> getEvents(int offset, int limit) {
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM event ORDER BY event_time DESC LIMIT ? OFFSET ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, limit);
            stmt.setInt(2, offset);

            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    Event event = new Event();
                    event.setEventId(resultSet.getInt("event_id"));
                    event.setUserId(resultSet.getInt("user_id"));
                    event.setEventType(resultSet.getString("event_type"));
                    event.setEventTime(resultSet.getTimestamp("event_time").toString());
                    events.add(event);
                }
            }
        } catch (SQLException e) {
            logError("Error retrieving events", e);
        }
        return events;
    }

    // Method to retrieve all events from the database (without pagination)
    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String query = "SELECT * FROM event ORDER BY event_time DESC";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Event event = new Event();
                event.setEventId(resultSet.getInt("event_id"));
                event.setUserId(resultSet.getInt("user_id"));
                event.setEventType(resultSet.getString("event_type"));
                event.setEventTime(resultSet.getTimestamp("event_time").toString());
                events.add(event);
            }
        } catch (SQLException e) {
            logError("Error retrieving all events", e);
        }
        return events;
    }

    // Utility for logging errors
    private void logError(String message, Exception e) {
        System.err.println(message + ": " + e.getMessage());
        // Replace with proper logging framework if available
    }
}
