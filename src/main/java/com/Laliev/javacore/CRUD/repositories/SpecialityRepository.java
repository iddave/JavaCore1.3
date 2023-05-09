package com.Laliev.javacore.CRUD.repositories;
import com.Laliev.javacore.CRUD.models.Skill;
import com.Laliev.javacore.CRUD.models.Specialty;

import java.io.IOException;

public interface SpecialityRepository extends GenericRepository<Specialty, Long>{
    Specialty findByName(String name) throws IOException;
}
