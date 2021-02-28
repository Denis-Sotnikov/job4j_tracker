package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.UserAction;
import ru.job4j.tracker.store.Store;

import java.util.List;

public class FindByName implements UserAction {
    private final Output out;

    public FindByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        List<Item> array = tracker.findByName(name);
        if (array.size() > 0) {
            for (int i = 0; i < array.size(); i++) {
                out.println(array.get(i).toString());
            }
        } else {
                out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
