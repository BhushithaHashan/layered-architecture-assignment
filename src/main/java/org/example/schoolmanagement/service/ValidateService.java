package org.example.schoolmanagement.service;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ValidateService implements ValidatorInterface{
    public boolean validateName(String s){
        if (s.isEmpty()||s.length() > 50 || s.length() > 50) {
            return false;
        }else{
            return true;
        }
    }
    public boolean validateEmail(String email){
        String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (email.isEmpty()||!Pattern.matches(EMAIL_REGEX, email)) {
            return false;
        }else{
            return true;
        }
    }
    public boolean validateAge(int age){
        if (age>60||age<0) {
            return false;
        }else{
            return true;
        }
    }
    public boolean validateDate(LocalDate date){
        LocalDate currentDate = LocalDate.now();
        if (date.equals(currentDate)||date.isBefore(currentDate)) {
            return true;
        }else{
            return false;
        }
    }
    public boolean validateDob(LocalDate date){
        if (date.isBefore(LocalDate.now())) {
            return true;
        }else{
            return false;
        }
    }
    public boolean isEmpty(String s){
        if (s.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean validatePasswordMatch(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }


    
} 
