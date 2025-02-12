package org.example.schoolmanagement.service;

import java.util.List;

import org.example.schoolmanagement.dto.Student;

public interface ServiceInterface<T,ID> {
    boolean register(T entity);
    boolean delete(ID id);
    T find(ID id);
    T find(String name);
    boolean update(T entity);
    List<T> getAll();
    boolean isExist(T entity);
}
