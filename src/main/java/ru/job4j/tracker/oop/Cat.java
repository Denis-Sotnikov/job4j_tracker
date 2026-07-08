package ru.job4j.tracker.oop;

public class Cat {
    public String Sound(){
     String voice = "Мяу-мяу";
     return voice;
    };

    public static void main(String[] args) {
        Cat cat = new Cat();
        String voice = cat.Sound();
        System.out.println(voice);
    }
}
