package com.Laliev.javacore.CRUD.views;

import com.Laliev.javacore.CRUD.controllers.DeveloperController;
import com.Laliev.javacore.CRUD.controllers.SkillController;
import com.Laliev.javacore.CRUD.controllers.SpecialtyController;
import com.Laliev.javacore.CRUD.models.Developer;
import com.Laliev.javacore.CRUD.models.Skill;
import com.Laliev.javacore.CRUD.models.Specialty;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DeveloperView {
    static Scanner sc = new Scanner(System.in);
    static DeveloperController devC = new DeveloperController();
    static SkillController skillC = new SkillController();
    static SpecialtyController specC = new SpecialtyController();
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
        System.out.println(devC.findById(id).toString());
    }

    public static void write() throws IOException {

        System.out.println("Введите firstName для Developer");
        String firstName = sc.nextLine();

        System.out.println("Введите lastName для Developer");
        String lastName = sc.nextLine();

        System.out.println("Введите specialty для Developer");
        String specialtyName = sc.nextLine();
        Specialty specialty = specC.findOrCreateSpecialty(specialtyName);

        System.out.println("Введите skills для Developer через пробел");
        String skillsNames = sc.nextLine();
        List<Skill> skills = skillC.findOrCreateSkillls(skillsNames);

        devC.save(new Developer(firstName, lastName, specialty, skills));
    }
    public static void findAll() throws IOException {
        List<Developer> devs = devC.findAll();
        for(Developer dev : devs){
            System.out.println(dev.toString());
        }
    }

    public static void deleteById() throws IOException {
        System.out.println("Введите id записи, которую нужно удалить ");
        Long id = Long.parseLong(sc.nextLine());
        devC.deleteById(id);
        System.out.println("запись удалена");
    }
}
