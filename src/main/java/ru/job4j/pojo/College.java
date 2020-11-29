package ru.job4j.pojo;

import ru.job4j.pojo.Student;

import java.time.LocalDateTime;

public class College {
    public static void main(String[] args) {
        Student ivan = new Student();
        ivan.setFio("Ivanov ivan Ivanovich");
        ivan.setGroup(1);
        ivan.setData(LocalDateTime.now());
        System.out.println(ivan.getFio() + " " + ivan.getGroup() + " group" + " " + ivan.getData());
    }
}
