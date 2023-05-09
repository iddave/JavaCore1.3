package com.Laliev.javacore.CRUD.repositories;

import com.Laliev.javacore.CRUD.models.Developer;
import com.Laliev.javacore.CRUD.models.Status;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository{
    private final Path path = Paths.get("src/main/java/com/Laliev/javacore/CRUD/data/developers.json");
    private final Gson gson = new Gson();
    @Override
    public Developer findById(Long id) throws IOException {
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
            List<Developer> result = gson.fromJson(json, listType);
            if(result == null) return new ArrayList<Developer>();
            return result;
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
    public void deleteById(Long id) throws IOException{
        List<Developer> devs = findAll();
        for (Developer dev : devs) {
            if (dev.getId().equals(id)) {
                dev.setStatus(Status.DELETED);
                try (Writer writer = new FileWriter(path.toFile())) {
                    gson.toJson(devs, writer);
                }
                return;
            }
        }
    }
}
