package org.example.schoolmanagement.dto;

public class EmailByParent {
    String parentName;
    String studentName;
    String email;

    //constructors
    public EmailByParent(){}
    public EmailByParent(String parentName,String studentName,String email){
        this.email = email;
        this.studentName = studentName;
        this.parentName = parentName;
    }


    //Getters and Setters

    public String getEmail() {
        return email;
    }

    public String getParentName() {
        return parentName;
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public void setParentName(String parentName){
        this.parentName = parentName;
    }
    public void setEmail(String email){
        this.email= email;
    }
}
