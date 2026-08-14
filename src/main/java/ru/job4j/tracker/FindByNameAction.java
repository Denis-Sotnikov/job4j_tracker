package ru.job4j.tracker;

import ru.job4j.tracker.Interface.UserAction;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Найти заявку по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Вывод заявки по имени ===");
        String name = input.askStr("Введите имя: ");
        Item[] arrayOfItem = tracker.findByName(name);
        if (arrayOfItem.length > 0) {
            for (int i = 0; i < arrayOfItem.length; i++) {
                System.out.println(arrayOfItem[i]);
            }
        } else {
            System.out.println("Заявки с именем:" + name + " не найдены");
        }
        return true;
    }
}
