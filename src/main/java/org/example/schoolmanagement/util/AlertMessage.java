package org.example.schoolmanagement.util;

public class AlertMessage {
    private String message;
    private static AlertMessage instance;

    private AlertMessage(){}

    public static AlertMessage getInstance(){
        if (instance==null) {
            instance = new AlertMessage();
        }
        return instance;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }

    
}
