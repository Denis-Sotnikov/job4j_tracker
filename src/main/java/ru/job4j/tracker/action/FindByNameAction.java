package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class FindByNameAction implements UserAction {
    private final Output output;
    public FindByNameAction(Output output) {
        this.output = output;
    }
    @Override
    public String name() {
        return "Найти заявку по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Вывод заявки по имени ===");
        String name = input.askStr("Введите имя: ");
        Item[] arrayOfItem = tracker.findByName(name);
        if (arrayOfItem.length > 0) {
            for (int i = 0; i < arrayOfItem.length; i++) {
                output.println(arrayOfItem[i]);
            }
        } else {
            output.println("Заявки с именем:" + name + " не найдены");
        }
        return true;
    }
}
