package org.example.schoolmanagement.service;

import org.example.schoolmanagement.dto.UserDTO;

public interface AuthserviceInterface {
    boolean authenticateUser(UserDTO user);
    boolean isUsernameTaken(UserDTO user);
}
