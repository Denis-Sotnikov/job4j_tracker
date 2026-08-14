package ru.job4j.tracker;

import ru.job4j.tracker.Interface.UserAction;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Удаление заявки ===");
        int id = input.askInt("Введите id: ");
        if (tracker.findById(id) != null) {
            tracker.delete(id);
            System.out.println("Заявка удалена успешно");
        } else {
            System.out.println("Такой заявки не существует");
        }
        return true;
    }
}
