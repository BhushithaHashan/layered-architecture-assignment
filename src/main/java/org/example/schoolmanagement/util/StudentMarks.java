package org.example.schoolmanagement.util;

public class StudentMarks {
    private String studentName;
    private Integer marks;

    // Constructor
    public StudentMarks(String studentName, Integer marks) {
        this.studentName = studentName;
        this.marks = marks;
    }

    // Getter and Setter methods
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }
}

