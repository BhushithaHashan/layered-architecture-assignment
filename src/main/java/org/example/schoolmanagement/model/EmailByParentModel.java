package org.example.schoolmanagement.model;

import org.example.schoolmanagement.dto.EmailByParent;
import org.example.schoolmanagement.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailByParentModel {

    public List<EmailByParent> getParentStudentList(int grade, String section) {
        String className = grade + section; // Combine grade and section to form class_name
        String query = "SELECT p.first_name AS parent_first_name, p.last_name AS parent_last_name, " +
                "s.first_name AS student_first_name, s.last_name AS student_last_name, " +
                "p.email AS parent_email " +
                "FROM parent p " +
                "JOIN student_parent sp ON p.parent_id = sp.parent_id " +
                "JOIN student s ON sp.student_id = s.student_id " +
                "JOIN student_class_record scr ON s.student_id = scr.student_id " +
                "JOIN class c ON scr.class_id = c.class_id " +
                "WHERE c.class_name = ?";

        List<EmailByParent> parentStudentList = new ArrayList<>();

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            // Bind the class_name parameter
            stmt.setString(1, className);

            // Execute the query
            ResultSet resultSet = stmt.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                EmailByParent emailByParent = new EmailByParent();

                // Add a space between first and last name for both parent and student
                emailByParent.setParentName(resultSet.getString("parent_first_name") + " " + resultSet.getString("parent_last_name"));

                emailByParent.setStudentName(resultSet.getString("student_first_name") + " " + resultSet.getString("student_last_name"));

                emailByParent.setEmail(resultSet.getString("parent_email"));

                parentStudentList.add(emailByParent);
                System.out.println(emailByParent.getParentName());
                System.out.println(emailByParent.getStudentName());
            }
        } catch (SQLException e) {
            System.err.println("Error fetching parent-student list: " + e.getMessage());
            e.printStackTrace();
        }

        return parentStudentList;
    }
}
