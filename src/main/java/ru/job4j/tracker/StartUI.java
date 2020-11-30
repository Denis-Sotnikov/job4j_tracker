package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item();
        item.setName("Заявление");
        System.out.println(item);
        Tracker tracker = new Tracker();
        tracker.add(item);
        Item[] array = tracker.findAll();
        System.out.println(array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println();
    }
}
