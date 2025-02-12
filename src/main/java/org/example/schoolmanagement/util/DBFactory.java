package org.example.schoolmanagement.util;

public class DBFactory {
    private static DBConnectionInterface sqlConnection; 
    private static DATABASETYPES databaseType;
    private DBFactory(){}                                     
    public static DBConnectionInterface getDataBase(DATABASETYPES type){
        if(type==DATABASETYPES.MYSQL){
            if (databaseType==DATABASETYPES.MYSQL && sqlConnection!=null) {
                return sqlConnection;
            }else if (databaseType!=DATABASETYPES.MYSQL || sqlConnection==null) {
                sqlConnection = new MySQLConnection();
                databaseType = DATABASETYPES.MYSQL;
            }
        }else if (type==DATABASETYPES.POSTGRESQL) {
            sqlConnection = new MySQLConnection();
        }else{
            sqlConnection = new MySQLConnection();
        }
        return sqlConnection;
    }
}
