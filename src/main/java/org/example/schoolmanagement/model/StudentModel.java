package org.example.schoolmanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.schoolmanagement.dto.Student;
import org.example.schoolmanagement.dto.Parent;
import org.example.schoolmanagement.util.DBConnection;

public class StudentModel {

    // Method to insert a new student
    public boolean addStudent(Student student) {
        String query = "INSERT INTO student (first_name, last_name, dob) VALUES (?, ?, ?)";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, student.getFirstName());
            stmt.setString(2, student.getLastName());
            stmt.setDate(3, student.getDob());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Method to get a student by ID
    public Student getStudentById(int studentID) {
        String query = "SELECT * FROM student WHERE student_id = ?";
        Student student = null;
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentID);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    student = new Student();
                    student.setStudentID(resultSet.getInt("student_id"));
                    student.setFirstName(resultSet.getString("first_name"));
                    student.setLastName(resultSet.getString("last_name"));
                    student.setDob(resultSet.getDate("dob"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving student by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return student;
    }

    // Method to get all students (uncommented version)
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Student student = new Student();
                student.setStudentID(resultSet.getInt("student_id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setDob(resultSet.getDate("dob"));
                student.setRegisteredDate(resultSet.getDate("registered_date"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving all students: " + e.getMessage());
            e.printStackTrace();
        }
        return students;
    }

    // Method to update a student's information
    public boolean updateStudent(Student student) {
        String query = "UPDATE student SET first_name = ?, last_name = ?, dob = ? WHERE student_id = ?";

        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, student.getFirstName());
            stmt.setString(2, student.getLastName());
            stmt.setDate(3, student.getDob());
            stmt.setInt(4, student.getStudentID());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete a student by ID
    public boolean deleteStudent(int studentID) {
        String query = "DELETE FROM student WHERE student_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentID);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting student: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    public boolean addStudentTransaction(Student student, Parent parent, String className) {
        String studentQuery = "INSERT INTO student (first_name, last_name, dob) VALUES (?, ?, ?)";
        String parentQuery = "INSERT INTO parent (first_name, last_name, email) VALUES (?, ?, ?)";
        String studentParentQuery = "INSERT INTO student_parent (student_id, parent_id) VALUES (?, ?)";
        String classQuery = "SELECT class_id FROM class WHERE class_name = ?";  // Query to get class_id from class name
        String studentClassRecordQuery = "INSERT INTO student_class_record (student_id, class_id) VALUES (?, ?)";

        Connection connection = null;

        try {
            connection = DBConnection.getConnectionInitializer().getConnection();
            connection.setAutoCommit(false); // Start transaction

            // Add student
            int studentId;
            try (PreparedStatement studentStmt = connection.prepareStatement(studentQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
                studentStmt.setString(1, student.getFirstName());
                studentStmt.setString(2, student.getLastName());
                studentStmt.setDate(3, student.getDob());

                int rowsAffected = studentStmt.executeUpdate();
                if (rowsAffected == 0) {
                    throw new SQLException("Failed to add student. No rows affected.");
                }

                try (var generatedKeys = studentStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        studentId = generatedKeys.getInt(1);
                    } else {
                        throw new SQLException("Failed to retrieve student ID.");
                    }
                }
            }

            // Add parent
            int parentId;
            try (PreparedStatement parentStmt = connection.prepareStatement(parentQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
                parentStmt.setString(1, parent.getFirstName());
                parentStmt.setString(2, parent.getLastName());
                parentStmt.setString(3, parent.getEmail());

                int rowsAffected = parentStmt.executeUpdate();
                if (rowsAffected == 0) {
                    throw new SQLException("Failed to add parent. No rows affected.");
                }

                try (var generatedKeys = parentStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        parentId = generatedKeys.getInt(1);
                    } else {
                        throw new SQLException("Failed to retrieve parent ID.");
                    }
                }
            }

            // Link student and parent
            try (PreparedStatement studentParentStmt = connection.prepareStatement(studentParentQuery)) {
                studentParentStmt.setInt(1, studentId);
                studentParentStmt.setInt(2, parentId);

                int rowsAffected = studentParentStmt.executeUpdate();
                if (rowsAffected == 0) {
                    throw new SQLException("Failed to link student and parent.");
                }
            }

            // Get class_id from class name
            int classId;
            try (PreparedStatement classStmt = connection.prepareStatement(classQuery)) {
                classStmt.setString(1, className);

                try (var rs = classStmt.executeQuery()) {
                    if (rs.next()) {
                        classId = rs.getInt("class_id");
                    } else {
                        throw new SQLException("Class not found with the name: " + className);
                    }
                }
            }

            // Insert into student_class_record
            try (PreparedStatement studentClassStmt = connection.prepareStatement(studentClassRecordQuery)) {
                studentClassStmt.setInt(1, studentId);
                studentClassStmt.setInt(2, classId);

                int rowsAffected = studentClassStmt.executeUpdate();
                if (rowsAffected == 0) {
                    throw new SQLException("Failed to link student with class.");
                }
            }

            // Commit the transaction
            connection.commit();
            return true;

        } catch (SQLException e) {
            // Rollback on any failure
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            System.err.println("Transaction failed: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            // Restore auto-commit mode and close connection
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public boolean deleteStudentTransaction(int studentId) {
        String getParentIdQuery = "SELECT parent_id FROM student_parent WHERE student_id = ?";
        String deleteStudentParentQuery = "DELETE FROM student_parent WHERE student_id = ?";
        String deleteParentQuery = "DELETE FROM parent WHERE parent_id = ?";
        String deleteStudentQuery = "DELETE FROM student WHERE student_id = ?";

        Connection connection = null;
        int parentId = -1;

        try {
            connection = DBConnection.getConnectionInitializer().getConnection();
            connection.setAutoCommit(false);


            try (PreparedStatement parentIdStmt = connection.prepareStatement(getParentIdQuery)) {
                parentIdStmt.setInt(1, studentId);
                ResultSet resultSet = parentIdStmt.executeQuery();
                if (resultSet.next()) {
                    parentId = resultSet.getInt("parent_id");
                }
            }

            if (parentId == -1) {
                throw new SQLException("No parent found for student with ID: " + studentId);
            }


            try (PreparedStatement studentParentStmt = connection.prepareStatement(deleteStudentParentQuery)) {
                studentParentStmt.setInt(1, studentId);
                studentParentStmt.executeUpdate();
            }


            try (PreparedStatement parentStmt = connection.prepareStatement(deleteParentQuery)) {
                parentStmt.setInt(1, parentId);
                parentStmt.executeUpdate();
            }


            try (PreparedStatement studentStmt = connection.prepareStatement(deleteStudentQuery)) {
                studentStmt.setInt(1, studentId);
                studentStmt.executeUpdate();
            }


            connection.commit();
            return true;

        } catch (SQLException e) {

            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            System.err.println("Transaction failed: " + e.getMessage());
            return false;
        } finally {

            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public boolean isStudentExist(int studentId) {
        String query = "SELECT COUNT(*) FROM student WHERE student_id = ?";
        try (Connection connection = DBConnection.getConnectionInitializer().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;  // If count is greater than 0, student exists
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }





}


