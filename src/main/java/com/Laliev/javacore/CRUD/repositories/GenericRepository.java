package com.Laliev.javacore.CRUD.repositories;

import com.Laliev.javacore.CRUD.models.Developer;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

public interface GenericRepository<T, ID> {
    T findById(ID id) throws IOException;
    List<T> findAll() throws IOException;
    T save(T entity) throws IOException;
    void deleteById(ID id) throws IOException;
}
