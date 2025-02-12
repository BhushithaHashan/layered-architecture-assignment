package org.example.schoolmanagement;

import org.example.schoolmanagement.Persistence.CrudDAO;
import org.example.schoolmanagement.Persistence.ParentDAO;
import org.example.schoolmanagement.Persistence.StudentDAO;
import org.example.schoolmanagement.dto.EmailByParent;
import org.example.schoolmanagement.dto.Parent;
import org.example.schoolmanagement.dto.Student;
import org.example.schoolmanagement.model.EmailByParentModel;
import org.example.schoolmanagement.util.DBConnectionInterface;
import org.example.schoolmanagement.util.DBFactory;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        // EmailByParent e1 = new EmailByParent();
        // List<EmailByParent> list;
        // EmailByParentModel e2 = new EmailByParentModel();
        // list = e2.getParentStudentList(8,"A");
        // System.out.println(list.isEmpty());
        // System.out.println(list.get(0).getParentName());
        DBConnectionInterface dbConnection= DBFactory.getDataBase("mysql");
        CrudDAO<Student,Integer> studentDAO = new StudentDAO(dbConnection.getConnection(),"sql");
        Student st1 = studentDAO.findById(1);
        System.out.println(st1.getFirstName());
        st1.setFirstName("Yoshitha");
        System.out.println(st1.getLastName());
        studentDAO.update(st1);
        Student st2 = studentDAO.findById(1);
        System.out.println(st2.getFirstName());
        Parent p1;
        CrudDAO<Parent,Integer> parentDao= new ParentDAO(dbConnection.getConnection(), "sql");
        p1 = parentDao.findById(1);
        System.out.println(p1.getFirstName());
        p1.setFirstName("Mahinda");
        parentDao.update(p1);
        System.out.println(p1.getFirstName());

    }
}
