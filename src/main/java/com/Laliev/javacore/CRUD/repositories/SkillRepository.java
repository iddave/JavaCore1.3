package com.Laliev.javacore.CRUD.repositories;

import com.Laliev.javacore.CRUD.models.Skill;

import java.io.IOException;

public interface SkillRepository extends GenericRepository<Skill, Long> {
    Skill findByName(String name) throws IOException;
}
