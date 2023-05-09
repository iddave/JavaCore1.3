package com.Laliev.javacore.CRUD.views;

import java.io.IOException;
import java.util.Scanner;

public class AppView {
    public void Run() throws IOException {
        String command = getCommand();
        switch (command) {
            case "dev":
                DeveloperView.Run();
                break;
            case "skill":
                SkillView.Run();
                break;
            default:
                SpecialityView.Run();
                break;
            }
        }


    public String getCommand()
    {
        System.out.println("dev - работать с Developer \nskill - работать с Skill  \nspec - работать с Speciality");
        System.out.println("Введите команду ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
