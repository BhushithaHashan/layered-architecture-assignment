package org.example.schoolmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements DBConnectionInterface{
    public static DBConnection connectionInitializer;
    private Connection connection;


    private DBConnection(){
        try {
            
            this.connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/schoolmanagementsystem","root", "Ijse1234");
            System.out.println("connection success");
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
    }

    public static DBConnection getConnectionInitializer(){
        try {
            if(connectionInitializer==null || !connectionInitializer.getConnection().isValid(0) ){
                connectionInitializer = new DBConnection();
            }
        } catch (SQLException ex) {
        }
        return connectionInitializer;
    }
    public Connection getConnection(){
        return this.connection;
    }
    public void closeConnection(){
        if(this.connection!=null){
            try {
                this.connection.close();
                
            } catch (SQLException e) {
                System.out.println("Connection not closed");
            }
        }
    }

}
