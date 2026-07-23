package ru.job4j.tracker.oop;

public class TextReport {
    public String generate(String name, String body){
        return name + System.lineSeparator() + body;
    }
}
