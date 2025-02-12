package org.example.schoolmanagement.util;

public enum DAO {
    STUDENTDAO("studentDAO"),
    PARENTDAO("parentDAO"),
    USERDAO("userDAO"),
    CLASSDAO("classDAO"),
    STUDENTPARENTDAO("studentParentDao"),
    STUDENTCLASSDAO("studentclassDao");
    

    private final String dao;

    DAO(String daoDesc){
        this.dao = daoDesc;
    }

    public String getRole(){
        return this.dao;
    }

}