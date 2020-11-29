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
        way.replace(1, item1);
        for (int i = 0; i < way.findAll().length; i++) {
            System.out.println(way.findAll()[i].getName());
        }
    }
}
