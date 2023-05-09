package com.Laliev.javacore.CRUD.views;

import com.Laliev.javacore.CRUD.controllers.DeveloperController;
import com.Laliev.javacore.CRUD.controllers.SkillController;
import com.Laliev.javacore.CRUD.models.Developer;
import com.Laliev.javacore.CRUD.models.Skill;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SkillView {
    static Scanner sc = new Scanner(System.in);
    static SkillController skillC = new SkillController();
    public static void Run() throws IOException {
        String command = getCommand();
        switch (command){
            case "r":
                findById();
                break;
            case "w":
                write();
                break;
            case "all":
                findAll();
                break;
            default:
                deleteById();
                break;
        }
    }
    public static String getCommand()
    {
        String command;
        List<String> commands = Arrays.asList("r", "w", "all", "d");
        while(true) {
            System.out.println("r - найти по id \nall - вывести все записи \nw - добавить запись \nd - удалить запись");
            System.out.println("Введите команду ");
            command = sc.nextLine();
            if(commands.contains(command)) break;
        }
        return command;
    }

    public static void findById() throws IOException {
        System.out.println("Введите id записи, которую нужно найти ");
        Long id = Long.parseLong(sc.nextLine());
        System.out.println(skillC.findById(id).toString());
    }

    public static void write() throws IOException {
        System.out.println("Введите skill");
        Skill skill = new Skill(sc.nextLine());
        skillC.save(skill);
    }

    public static void findAll() throws IOException {
        List<Skill> skills = skillC.findAll();
        for(Skill skill : skills){
            System.out.println(skill.toString());
        }
    }

    public static void deleteById() throws IOException {
        System.out.println("Введите id записи, которую нужно удалить ");
        Long id = Long.parseLong(sc.nextLine());
        skillC.deleteById(id);
        System.out.println("запись удалена");
    }
}
