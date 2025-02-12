package org.example.schoolmanagement.dto;

public class TermDTO {
    private int termId;
    private String termName;
    private int year;

    // Constructor
    public TermDTO(int termId, String termName, int year) {
        this.termId = termId;
        this.termName = termName;
        this.year = year;
    }

    // Getters and Setters
    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "TermDTO{" +
                "termId=" + termId +
                ", termName='" + termName + '\'' +
                ", year=" + year +
                '}';
    }
}
