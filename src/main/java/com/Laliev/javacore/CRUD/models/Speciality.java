package com.Laliev.javacore.CRUD.models;

public class Speciality {
    private String specialityName;
    private Status status;
    public Speciality(){}
    public Speciality(String specialityName){
        this.specialityName = specialityName;
        status = Status.ACTIVE;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
