package com.Laliev.javacore.CRUD.controllers;

import com.Laliev.javacore.CRUD.models.Developer;
import com.Laliev.javacore.CRUD.repositories.DeveloperRepository;
import java.io.*;
import java.nio.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.Laliev.javacore.CRUD.repositories.GsonDeveloperRepositoryImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DeveloperController extends GsonDeveloperRepositoryImpl {
     public DeveloperRepository devR = new GsonDeveloperRepositoryImpl();
    @Override
     public Developer findById(Long id) throws IOException{
         return devR.findById(id);
     }

    @Override
    public List<Developer> findAll() throws IOException {
        return devR.findAll();
    }

    @Override
    public Developer save(Developer entity) throws IOException {
        return devR.save(entity);
    }

    @Override
    public void deleteById(Long id) throws IOException {
        devR.deleteById(id);
    }
}
