package org.example.schoolmanagement.Persistence;

import java.sql.Connection;

import org.example.schoolmanagement.util.DAO;

public class DAOFactory {
    public static<T,ID> CrudDAO<T,ID> getDAO(DAO type,Connection connection,String executor){
        switch(type){
            case STUDENTDAO:
                return (CrudDAO<T, ID>) new StudentDAO(connection, executor);
            case PARENTDAO:
                return (CrudDAO<T, ID>) new ParentDAO(connection, executor);
            case CLASSDAO:
                return (CrudDAO<T, ID>) new ClassDAO(connection,executor);
            case USERDAO:
                return (CrudDAO<T,ID>) new UserDAO(connection, executor);    
            case STUDENTCLASSDAO:
                return (CrudDAO<T,ID>) new StudentClassRecordDAO(connection, executor);
            case STUDENTPARENTDAO:
                return(CrudDAO<T,ID>) new StudentParentDAO(connection, executor);  
            default:
                throw new IllegalArgumentException("Invalid DAO type: " + type);
        }
    }
}
