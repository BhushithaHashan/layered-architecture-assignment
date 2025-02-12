package org.example.schoolmanagement.util;

public enum SERVICES {
    AUTHSERVICE("authService"),
    LOGSERVICE("logService"),
    VALIDATESERVICE("validateService"),
    CLASSSERVICE("classService"),
    STUDENTSERVICE("studentService"),
    PARENTSERVICE("parentService"),
    USERSERVICE("userService"),
    MAILSERVICE("mailService"),
    STUDENTCLASSSERVICE("studentclassservice"),
    STUDENTPARENTSERVICE("studentparentservice");

    private final String serviceName;

    SERVICES(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return this.serviceName;
    }
}
