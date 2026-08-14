package ru.job4j.tracker;

import ru.job4j.tracker.Interface.UserAction;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "Найти все заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Вывод всех заявок ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
