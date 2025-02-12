package org.example.schoolmanagement.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseExecutor {
    ResultSet executeQuery(String sql, Object... params) throws SQLException;
    int executeUpdate(String sql, Object... params) throws SQLException;
}
