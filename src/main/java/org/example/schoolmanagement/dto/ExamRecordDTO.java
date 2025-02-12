package org.example.schoolmanagement.dto;

public class ExamRecordDTO {
    private int studentId;
    private int examId;
    private int marks;

    // Constructor
    public ExamRecordDTO(int studentId, int examId, int marks) {
        this.studentId = studentId;
        this.examId = examId;
        this.marks = marks;
    }
    public ExamRecordDTO(){}

    // Getters and setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

