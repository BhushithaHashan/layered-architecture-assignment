package org.example.schoolmanagement.Persistence;

import java.util.List;

public interface CrudDAO<T, ID> {
    boolean save(T entity);
    T findById(ID id);
    boolean update(T entity);
    boolean delete(ID id);
    List<T> getAll();
}

