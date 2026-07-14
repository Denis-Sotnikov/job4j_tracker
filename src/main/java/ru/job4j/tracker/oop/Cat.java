package ru.job4j.tracker.oop;

public class Cat {
    private String name;

    public void takeName(String name) {
        this.name = name;
    }

    public String sound() {
        String voice = "Мяу-мяу";
        return voice;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        String voice = cat.sound();
        System.out.println(voice);
        cat.takeName("Mursik");
        System.out.println(cat.name);
    }
}
