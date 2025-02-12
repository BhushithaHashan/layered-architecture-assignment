package org.example.schoolmanagement.util;

import java.sql.Connection;

public interface DBConnectionInterface {
    public Connection getConnection();
    public void closeConnection();
}
