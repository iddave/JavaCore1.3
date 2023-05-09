package com.Laliev.javacore.CRUD.repositories;

import com.Laliev.javacore.CRUD.models.Developer;
import com.Laliev.javacore.CRUD.models.Skill;
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

public class GsonSkillRepositoryImpl implements SkillRepository{
    private final Path path = Paths.get("src/main/java/com/Laliev/javacore/CRUD/data/skills.json");
    private final Gson gson = new Gson();
    @Override
    public Skill findById(Long id) throws IOException {
        List<Skill> skills = findAll();
        for(Skill skill : skills)
        {
            if(skill.getId().equals(id))
                return skill;
        }
        return null;
    }

    @Override
    public List<Skill> findAll() throws IOException {
        try{
            Type listType = new TypeToken<List<Skill>>(){}.getType();
            String json = Files.readString(path);
            List<Skill> result = gson.fromJson(json, listType);
            if(result == null) return new ArrayList<Skill>();
            return result;
        }
        catch (IOException e){
            System.out.println("Ошибка извлечения из файла skills:\n"+e);
        }
        return null;
    }

    @Override
    public Skill save(Skill entity) throws IOException {
        List<Skill> skills = findAll();
//        if(skills.contains(entity)) return entity;
        skills.add(entity);
        try(Writer w = new FileWriter(path.toFile()))
        {
            gson.toJson(skills, w);
        }
        return entity;
    }

    @Override
    public void deleteById(Long id) throws IOException {
        List<Skill> skills = findAll();
        for (Skill skill : skills) {
            if (skill.getId().equals(id)) {
                skill.setStatus(Status.DELETED);
                try (Writer writer = new FileWriter(path.toFile())) {
                    gson.toJson(skills, writer);
                }
                return;
            }
        }
    }

    @Override
    public Skill findByName(String name) throws IOException {
        List<Skill> skills = findAll();
        for(Skill skill : skills)
            if(skill.getSkillName() == name) return skill;
        return null;
    }
}
