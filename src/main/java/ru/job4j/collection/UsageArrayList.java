package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        array.add("Petr");
        array.add("Ivan");
        array.add("Stepan");
        for (String s : array) {
            System.out.println(s);
        }
    }
}
