package org.example.schoolmanagement.Persistence;

import java.util.List;

import org.example.schoolmanagement.dto.UserDTO;

public interface CrudDAO<T, ID> {
    boolean save(T entity);
    T findById(ID id);
    boolean update(T entity);
    boolean delete(ID id);
    List<T> getAll();
    boolean isExist(T entity);
    T findByName(String name);
}

