package com.example.common;

import java.util.List;
import java.util.Optional;

public interface CrudRepo<T> {
    public void save(T entity);
    public List<T> findAll();
    public Optional<T> findById(int id);
    public void update(T entity);
    public void deleteById(int id);
}
