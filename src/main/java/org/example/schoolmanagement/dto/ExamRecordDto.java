package org.example.schoolmanagement.dto;

public class ExamRecordDto {
    private int recordId;
    private int studentId;
    private int examId;
    private int marks;


    public ExamRecordDto() {}


    public ExamRecordDto(int recordId, int studentId, int examId, int marks) {
        this.recordId = recordId;
        this.studentId = studentId;
        this.examId = examId;
        this.marks = marks;
    }

    // Getters and Setters
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

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

