package org.example.schoolmanagement.util;

public class TransactionKeyUtil {
    private static TransactionKeyUtil keyUtil;
    private int key;
    
    private TransactionKeyUtil(){}
    public static TransactionKeyUtil getKeyInstance(){
        return keyUtil;
    }
    public int getKey(){
        return this.key;
    }
    public void setKey(int key){
        this.key = key;
    }

}
