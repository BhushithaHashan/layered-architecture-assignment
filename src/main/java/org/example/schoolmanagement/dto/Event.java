package org.example.schoolmanagement.dto;

public class Event {

    private int eventId;
    private Integer userId; // Associated user
    private String eventType; // Type of event
    private String eventTime; // Use String for UI display

    // Constructors
    public Event() {}

    public Event(Integer userId, String eventType) {
        this.userId = userId;
        this.eventType = eventType;
    }

    // Getters and setters for all fields
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }
}
