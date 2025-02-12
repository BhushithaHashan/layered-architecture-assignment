package org.example.schoolmanagement.dto;

import java.sql.Date;




public class Student {
    private int studentID;
    private String firstName;
    private  String lastName;
    private Date dob;
    private Date registeredDate;

    public Student(int studentID, String firstName, String lastName,Date dob,Date registeredDate) {
        
        this.dob = dob;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.registeredDate = registeredDate;
        
    }
    public Student(){};

    public int getStudentID() {
        return this.studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setRegisteredDate(Date registeredDate){this.registeredDate = registeredDate;}

    public Date getRegisteredDate(){return this.registeredDate;}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    

    
    


}
