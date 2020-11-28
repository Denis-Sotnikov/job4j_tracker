package ru.job4j.pojo;

import ru.job4j.pojo.Student;

import java.time.LocalDateTime;

public class College {
    public static void main(String[] args) {
        Student Ivan = new Student();
        Ivan.setFio("Ivanov Ivan Ivanovich");
        Ivan.setGroup(1);
        Ivan.setData(LocalDateTime.now());
        System.out.println(Ivan.getFio() + " " + Ivan.getGroup() + " group" + " " + Ivan.getData());
    }
}
