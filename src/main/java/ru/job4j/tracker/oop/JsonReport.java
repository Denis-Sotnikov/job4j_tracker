package ru.job4j.tracker.oop;

import org.w3c.dom.ls.LSOutput;

public class JsonReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        return "name = " + name + "\n" + "body = " + body;
    }

    public static void main(String[] args) {
        JsonReport report = new JsonReport();
        String val = report.generate("auto", "Porsh");
        System.out.println(val);
    }
}
