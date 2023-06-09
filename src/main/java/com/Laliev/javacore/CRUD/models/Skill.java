package com.Laliev.javacore.CRUD.models;

public class Skill {
    private static Long nextId = 0L;
    private Long id;
    private String skillName;
    private Status status;

    public Skill(){}
    public Skill(String skillName){
        this.id = nextId++;
        this.skillName = skillName;
        status = Status.ACTIVE;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + skillName + '\'' +
                ", status=" + status +
                '}';
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
