package ru.job4j.tracker;

public class Student {
    public int age;

    public Student() {

    }

    public Student(int age) {
        this.age = age;
    }

    public void music(String song) {
        System.out.println(song);
    }


    public static void main(String[] args) {
        Student student = new Student();
        Student studentFirst = new Student(5);
        student.music("Привет, Марина");
    }
}

