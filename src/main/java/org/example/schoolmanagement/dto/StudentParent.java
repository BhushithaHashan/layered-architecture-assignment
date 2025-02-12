package org.example.schoolmanagement.dto;

public class StudentParent {
    private int studentId;
    private int parentId;

    // Constructor
    public StudentParent(int studentId, int parentId) {
        this.studentId = studentId;
        this.parentId = parentId;
    }

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
