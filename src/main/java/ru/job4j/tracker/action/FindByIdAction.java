package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

public class FindByIdAction implements UserAction {
    private final Output output;
    public FindByIdAction(Output output) {
        this.output = output;
    }
    @Override
    public String name() {
        return "Найти заявку по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Вывод заявки ===");
        int id = input.askInt("Введите id: ");
        if (tracker.findById(id) != null) {
            output.println("Ваша заявка: " + tracker.findById(id));
        } else {
            output.println("Такой заявки не существует");
        }
        return true;
    }
}
