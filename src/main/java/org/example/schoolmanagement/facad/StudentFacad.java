package org.example.schoolmanagement.facad;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.example.schoolmanagement.Persistence.StudentParentDAO;
import org.example.schoolmanagement.dto.Parent;
import org.example.schoolmanagement.dto.Student;
import org.example.schoolmanagement.dto.StudentClassRecord;
import org.example.schoolmanagement.dto.StudentParent;
import org.example.schoolmanagement.service.ClassService;
import org.example.schoolmanagement.service.ServiceFactory;
import org.example.schoolmanagement.service.ServiceInterface;
import org.example.schoolmanagement.util.DATABASETYPES;
import org.example.schoolmanagement.util.DBConnectionInterface;
import org.example.schoolmanagement.util.DBFactory;
import org.example.schoolmanagement.util.SERVICES;
import org.example.schoolmanagement.util.TransactionKeyUtil;

public class StudentFacad implements StudentFacadInterface{
    ServiceInterface<Student, Integer> studentService;
    ServiceInterface<Parent, Integer> parentService;
    ServiceInterface<StudentParent, Integer> studentParentService;
    ServiceInterface<StudentClassRecord, Integer> studentClassService;

    private DBConnectionInterface dbconnection;
    private ClassService classService;

    public StudentFacad(){
        dbconnection = DBFactory.getDataBase(DATABASETYPES.MYSQL);
        studentService = ServiceFactory.getService(SERVICES.STUDENTSERVICE, dbconnection.getConnection(), "sql");
        parentService = ServiceFactory.getService(SERVICES.PARENTSERVICE, dbconnection.getConnection(), "sql");
        studentClassService = ServiceFactory.getService(SERVICES.STUDENTCLASSSERVICE, dbconnection.getConnection(), "sql");
        studentParentService = ServiceFactory.getService(SERVICES.STUDENTPARENTSERVICE, dbconnection.getConnection(), "sql");
        classService = ServiceFactory.getService(SERVICES.CLASSSERVICE, dbconnection.getConnection(), "sql");
        
    }

    @Override
    public boolean register(Student student, Parent parent, String classname) {
        Connection connection = null;
        int registeredStudentKey = 0;
        int registeredParentKey = 0;
        boolean success = false;

        try {
            // Initialize connection and start transaction
            connection = dbconnection.getConnection();
            connection.setAutoCommit(false); // Start the transaction

            // Register student
            if (studentService.register(student)) {
                registeredStudentKey = TransactionKeyUtil.getKeyInstance().getKey();
            } else {
                connection.rollback();
                return false;
            }

            // Register parent
            if (parentService.register(parent)) {
                registeredParentKey = TransactionKeyUtil.getKeyInstance().getKey();
            } else {
                connection.rollback();
                return false;
            }

            // Register Student-Parent relationship
            StudentParent stp = new StudentParent(registeredStudentKey, registeredParentKey);
            if (!studentParentService.register(stp)) {
                connection.rollback();
                return false;
            }

            // Find class ID and register Student-Class relationship
            int classId = classService.find(classname).getClassId();
            StudentClassRecord studentClassRecord = new StudentClassRecord(0, classId, registeredStudentKey, 2025);
            if (!studentClassService.register(studentClassRecord)) {
                connection.rollback();
                return false;
            }

            // Commit the transaction if all operations are successful
            connection.commit();
            success = true;

        } catch (Exception e) {
            // Handle any exception by rolling back the transaction
            try {
                if (connection != null) {
                    connection.rollback();  // Rollback all changes
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Cleanup: Set autoCommit to true and close connection
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);  // Restore auto-commit mode
                    connection.close();  // Close the connection
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return success;  // Return success status
    }


    @Override
    public boolean remove(int studentId) {
        return studentService.delete(studentId);
    }

    @Override
    public Student find(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public Student find(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public List<Student> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public boolean update(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    
}
