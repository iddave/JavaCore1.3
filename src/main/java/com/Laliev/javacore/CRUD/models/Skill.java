package com.Laliev.javacore.CRUD.models;

public class Skill {
    private String skillName;
    private Status status;

    public Skill(){}
    public Skill(String skillName){
        this.skillName = skillName;
        status = Status.ACTIVE;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
