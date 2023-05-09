package com.Laliev.javacore.CRUD.controllers;

import com.Laliev.javacore.CRUD.models.Specialty;
import com.Laliev.javacore.CRUD.repositories.GsonSpecialityRepositoryImpl;
import com.Laliev.javacore.CRUD.repositories.SpecialityRepository;

import java.io.IOException;
import java.util.List;

public class SpecialtyController extends GsonSpecialityRepositoryImpl {
    public SpecialityRepository specR = new GsonSpecialityRepositoryImpl();

    @Override
    public List<Specialty> findAll() throws IOException {
        return specR.findAll();
    }

    @Override
    public Specialty findByName(String name) throws IOException {
        return super.findByName(name);
    }

    @Override
    public void deleteById(Long id) throws IOException {
        specR.deleteById(id);
    }

    @Override
    public Specialty save(Specialty entity) throws IOException {
        return specR.save(entity);
    }

    @Override
    public Specialty findById(Long id) throws IOException {
        return specR.findById(id);
    }

    public Specialty findOrCreateSpecialty(String name) throws IOException {
        Specialty spec = findByName(name);
        if(spec == null){
            spec = new Specialty(name);
            save(spec);
        }
        return spec;
    }
}
