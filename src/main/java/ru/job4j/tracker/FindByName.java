package ru.job4j.tracker;

import java.util.ArrayList;
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
    public boolean execute(Input input, Tracker tracker) {
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
