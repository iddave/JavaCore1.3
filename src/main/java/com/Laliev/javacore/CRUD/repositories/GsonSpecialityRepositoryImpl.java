package com.Laliev.javacore.CRUD.repositories;

import com.Laliev.javacore.CRUD.models.Skill;
import com.Laliev.javacore.CRUD.models.Specialty;
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

public class GsonSpecialityRepositoryImpl implements SpecialityRepository{
    private final Path path = Paths.get("src/main/java/com/Laliev/javacore/CRUD/data/specialties.json");
    private final Gson gson = new Gson();
    @Override
    public Specialty findById(Long id) throws IOException {
        List<Specialty> specs = findAll();
        for(Specialty spec : specs)
        {
            if(spec.getId().equals(id))
                return spec;
        }
        return null;
    }

    @Override
    public List<Specialty> findAll() throws IOException {
        try{
            Type listType = new TypeToken<List<Specialty>>(){}.getType();
            String json = Files.readString(path);
            List<Specialty> result = gson.fromJson(json, listType);
            if(result == null)
                return new ArrayList<Specialty>();
            return result;
        }
        catch (IOException e){
            System.out.println("Ошибка извлечения из файла specialties:\n"+e);
        }
        return null;
    }

    @Override
    public Specialty save(Specialty entity) throws IOException {
        List<Specialty> specs = findAll();
        specs.add(entity);
        try(Writer w = new FileWriter(path.toFile()))
        {
            gson.toJson(specs, w);
        }
        return entity;
    }

    @Override
    public void deleteById(Long id) throws IOException {
        List<Specialty> specs = findAll();
        for (Specialty spec : specs) {
            if (spec.getId().equals(id)) {
                spec.setStatus(Status.DELETED);
                try (Writer writer = new FileWriter(path.toFile())) {
                    gson.toJson(specs, writer);
                }
                return;
            }
        }
    }

    @Override
    public Specialty findByName(String name) throws IOException {
        List<Specialty> specs = findAll();
        for(Specialty spec : specs)
            if(spec.getSpecialtyName() == name) return spec;
        return null;
    }
}
