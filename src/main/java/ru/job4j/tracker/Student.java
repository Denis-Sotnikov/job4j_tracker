package ru.job4j.tracker;

public class Student {
    public void music(String song){
        System.out.println(song);
    }
    public static void main(String[] args) {
        Student student = new Student();
        student.music("Fire");
    }
}
