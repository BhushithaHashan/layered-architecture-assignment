package org.example.schoolmanagement.util;

import java.sql.*;

public class SQLExecutor implements DatabaseExecutor{
    private final Connection connection;

    public SQLExecutor(Connection connection) {
        this.connection = connection;
    }

    // Executes SELECT queries and returns a ResultSet
    public ResultSet executeQuery(String sql, Object... params) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(sql);
        setParameters(stmt, params);
        return stmt.executeQuery(); // Returns results
    }

    // Executes INSERT, UPDATE, DELETE queries and returns the affected row count
    public int executeUpdate(String sql, Object... params) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(sql);
        setParameters(stmt, params);
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    TransactionKeyUtil.getKeyInstance().setKey(generatedKeys.getInt(1)); // Get the first column of the generated keys (e.g., student_id)
                }
            }
        }
        return rowsAffected;// Returns the number of affected rows
    }

    // Handles setting parameters in PreparedStatement
    private void setParameters(PreparedStatement stmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]); // Dynamically assigns parameters
        }
    }

    // Closes resources to prevent memory leaks
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
