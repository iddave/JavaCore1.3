package com.Laliev.javacore.CRUD.controllers;

import com.Laliev.javacore.CRUD.models.Skill;
import com.Laliev.javacore.CRUD.repositories.GsonSkillRepositoryImpl;
import com.Laliev.javacore.CRUD.repositories.SkillRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SkillController extends GsonSkillRepositoryImpl {
    public SkillRepository skillR = new GsonSkillRepositoryImpl();

    @Override
    public Skill save(Skill entity) throws IOException {
        return skillR.save(entity);
    }

    @Override
    public Skill findById(Long id) throws IOException {
        return skillR.findById(id);
    }

    @Override
    public Skill findByName(String name) throws IOException {
        return skillR.findByName(name);
    }

    @Override
    public List<Skill> findAll() throws IOException {
        return skillR.findAll();
    }

    @Override
    public void deleteById(Long id) throws IOException {
        skillR.deleteById(id);
    }

    public List<Skill> findOrCreateSkillls(String skillsString) throws IOException {
        List<Skill> skills = new ArrayList<>();
        for(String skillName : skillsString.split(" ")){
            Skill skill = findOrCreateSkill(skillName);
            skills.add(skill);
        }
        return skills;
    }

    public Skill findOrCreateSkill(String skillName) throws IOException {
        Skill skill = findByName(skillName);
        if(skill == null){
            skill = new Skill(skillName);
            save(skill);
        }
        return skill;
    }

}
