package org.example.schoolmanagement.util;

public class DBFactory {
    private static DBConnectionInterface sqlConnection ; 
    private DBFactory(){}                                     
    public static DBConnectionInterface getDataBase(String type){
        if(type.equalsIgnoreCase("mysql")){
            sqlConnection = new MySQLConnection();
        }else if (type.equalsIgnoreCase("postgreSql")) {
            sqlConnection = new MySQLConnection();
        }else{
            return null;
        }
        return sqlConnection;
    }
}
