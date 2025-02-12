package org.example.schoolmanagement.dto;

public class ExamDto {
    private int examId;
    private String examName;
    private int classId;
    private int termId;
    private int subjectId;

    // Default constructor
    public ExamDto() {}

    // Parameterized constructor
    public ExamDto(int examId, String examName, int classId, int termId, int subjectId) {
        this.examId = examId;
        this.examName = examName;
        this.classId = classId;
        this.termId = termId;
        this.subjectId = subjectId;
    }

    // Getters and Setters
    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
