package com.Laliev.javacore.CRUD.views;

import com.Laliev.javacore.CRUD.controllers.DeveloperController;

public class DeveloperView {
    public void Run() {
        DeveloperController devC = new DeveloperController();
        commandsMsg();
    }
    public void commandsMsg()
    {
        System.out.println("r {путь к файлу} \nИмя\nФамилия\nСпециальность\nНавыки");
    }
}
