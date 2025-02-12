package org.example.schoolmanagement.service;

import java.sql.Connection;

import org.example.schoolmanagement.Persistence.DAOFactory;
import org.example.schoolmanagement.util.DAO;
import org.example.schoolmanagement.util.SERVICES;

public class ServiceFactory {
    public static <T, ID, S extends ServiceInterface<T, ID>> S getService(SERVICES type,Connection connection,String executor){
        switch (type) {
            case USERSERVICE:
                return (S) new UserService(DAOFactory.getDAO(DAO.USERDAO, connection, executor));                       
            case AUTHSERVICE:
                return (S) new AuthService(ServiceFactory.getService(SERVICES.USERSERVICE, connection, executor));
            case STUDENTSERVICE:
                return (S) new StudentService(DAOFactory.getDAO(DAO.STUDENTDAO, connection, executor));
            case PARENTSERVICE:
                return (S) new ParentService(DAOFactory.getDAO(DAO.PARENTDAO, connection, executor));
            case VALIDATESERVICE:
                return (S) new ValidateService();
            case CLASSSERVICE:
                return (S) new ClassService(DAOFactory.getDAO(DAO.CLASSDAO, connection, executor));
            case STUDENTCLASSSERVICE:
                return (S) new StudentClassService(null);
            case STUDENTPARENTSERVICE:
                return (S) new StudentParentService(null);
            default:
                throw new IllegalArgumentException("Invalid service type: " + type);
        }
    }
}
