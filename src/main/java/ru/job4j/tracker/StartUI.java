package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item();
        item.setName("Заявление");
        Item item1 = new Item();
        item1.setName("Hello");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getCreated().format(formatter));
        Tracker way = new Tracker();
        way.add(item);
        way.add(item1);
        System.out.println(way.findById(1).getName());
        Item[] array = way.findAll();
        System.out.println(array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName());
        }
        Item[] array1 = way.findByName("Hello");
        System.out.println(array1.length);
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i].getName());
        }

    }
}
