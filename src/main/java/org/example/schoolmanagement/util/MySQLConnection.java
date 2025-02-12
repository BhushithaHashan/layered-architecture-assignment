package org.example.schoolmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection implements DBConnectionInterface{
    private Connection connection;


    public MySQLConnection(){
        try {
            
            this.connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/schoolmanagementsystem","root", "Ijse1234");
            System.out.println("connection success");
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
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
