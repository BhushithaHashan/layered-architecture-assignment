package org.example.schoolmanagement.dto;

public class Teacher{
    
    private int teacherID;
    private String firstName;
    private String lastName;
    private boolean  isAClassTeacher;
    private int subjectID;

    public Teacher( int teacherID, String firstName, String lastName,boolean isAClassTeacher, int subjectID) {
        
        this.teacherID =teacherID;
        this.subjectID = subjectID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAClassTeacher = isAClassTeacher;
        
    }
    public Teacher(){}
    

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAClassTeacher() {
        return isAClassTeacher;
    }

    public void setIsAClassTeacher(boolean isAClassTeacher) {
        this.isAClassTeacher = isAClassTeacher;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }



    



}
