package ru.job4j.tracker;

import ru.job4j.tracker.Interface.UserAction;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Найти заявку по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Вывод заявки ===");
        int id = input.askInt("Введите id: ");
        if (tracker.findById(id) != null) {
            System.out.println("Ваша заявка: " + tracker.findById(id));
        } else {
            System.out.println("Такой заявки не существует");
        }
        return true;
    }
}
