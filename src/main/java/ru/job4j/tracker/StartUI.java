package ru.job4j.tracker;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item();
        System.out.println("Текущая дата = " + item.getCreated());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dateOfCreated = item.getCreated().format(formatter);
        System.out.println("Текущая дата = " + dateOfCreated);
    }
}
