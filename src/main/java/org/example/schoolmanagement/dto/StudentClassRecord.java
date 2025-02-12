package org.example.schoolmanagement.dto;

public class StudentClassRecord {
    private int studentClassRecordID;
    private int studentID;
    private int classID;
    private int year;

    public StudentClassRecord( int studentClassRecordID,int classID, int studentID, int year) {
        this.classID = classID;
        this.studentClassRecordID = studentClassRecordID;
        this.studentID = studentID;
        this.year = year;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getStudentClassRecordID() {
        return studentClassRecordID;
    }

    public void setStudentClassRecordID(int studentClassRecordID) {
        this.studentClassRecordID = studentClassRecordID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
