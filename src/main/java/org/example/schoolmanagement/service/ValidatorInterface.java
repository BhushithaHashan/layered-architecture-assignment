package org.example.schoolmanagement.service;

import java.time.LocalDate;

public interface ValidatorInterface {
    boolean validateName(String s);
    boolean validateEmail(String email);
    boolean validateAge(int age);
    boolean validateDate(LocalDate date);
    boolean validateDob(LocalDate date);
    boolean isEmpty(String s);
    boolean validatePasswordMatch(String password, String confirmPassword);
}

