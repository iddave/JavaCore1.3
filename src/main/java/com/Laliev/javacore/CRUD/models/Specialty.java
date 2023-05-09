package com.Laliev.javacore.CRUD.models;

public class Specialty {
    private static Long nextId = 0L;
    private Long id;
    private String specialtyName;
    private Status status;
    public Specialty(){}
    public Specialty(String specialtyName){
        this.id = nextId++;
        this.specialtyName = specialtyName;
        status = Status.ACTIVE;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", specName='" + specialtyName + '\'' +
                ", status=" + status +
                '}';
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
