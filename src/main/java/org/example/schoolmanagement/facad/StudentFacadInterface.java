package org.example.schoolmanagement.facad;

import java.util.List;

import org.example.schoolmanagement.dto.Parent;
import org.example.schoolmanagement.dto.Student;

public interface StudentFacadInterface {
    boolean register(Student student,Parent parent,String classname);
    boolean remove(int studentId);
    Student find(String name);
    Student find(int id);
    List<Student> getAll();
    boolean update(Student student);

}
