package com.Laliev.javacore.CRUD.views;

import com.Laliev.javacore.CRUD.controllers.SpecialtyController;
import com.Laliev.javacore.CRUD.models.Skill;
import com.Laliev.javacore.CRUD.models.Specialty;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SpecialityView {
    static Scanner sc = new Scanner(System.in);
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
        System.out.println(specC.findById(id).toString());
    }

    public static void write() throws IOException {
        System.out.println("Введите specialty");
        Specialty specialty = new Specialty(sc.nextLine());
        specC.save(specialty);
    }

    public static void findAll() throws IOException {
        List<Specialty> specs = specC.findAll();
        for(Specialty spec : specs){
            System.out.println(spec.toString());
        }
    }

    public static void deleteById() throws IOException {
        System.out.println("Введите id записи, которую нужно удалить ");
        Long id = Long.parseLong(sc.nextLine());
        specC.deleteById(id);
        System.out.println("запись удалена");
    }
}
