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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DeveloperController implements DeveloperRepository {
    private final Path path = Paths.get("data/developers.json");
    private final Gson gson = new Gson();
    @Override
    public Developer findById(Long id) throws IOException{
        List<Developer> devs = findAll();
        for(Developer dev : devs)
        {
            if(dev.getId().equals(id))
                return dev;
        }
        return null;
    }

    @Override
    public List<Developer> findAll() throws IOException {
        try{
            Type listType = new TypeToken<List<Developer>>(){}.getType();
            String json = Files.readString(path);
            return gson.fromJson(json, listType);
        }
        catch (IOException e){
            System.out.println("Ошибка извлечения из файла developers:\n"+e);
        }
        return null;
    }

    @Override
    public Developer save(Developer entity) throws IOException {
        List<Developer> devs = findAll();
        devs.add(entity);
        try(Writer w = new FileWriter(path.toFile()))
        {
            gson.toJson(devs, w);
        }
        return entity;
    }

    @Override
    public void delete(Developer entity) throws IOException{
        List<Developer> devs = findAll();
        devs.remove(entity);
        try(Writer w = new FileWriter(path.toFile()))
        {
            gson.toJson(devs, w);
        }
    }

    @Override
    public void deleteById(Long id) throws IOException{
        List<Developer> devs = findAll();
        for (Developer dev : devs) {
            if (dev.getId().equals(id)) {
                devs.remove(dev);
                try (Writer writer = new FileWriter(path.toFile())) {
                    gson.toJson(devs, writer);
                }
                return;
            }
        }
    }
}
