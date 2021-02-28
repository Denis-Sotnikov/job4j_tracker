package ru.job4j.tracker.actions;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.UserAction;
import ru.job4j.tracker.store.Store;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Show all items ====");
        List<Item> array = tracker.findAll();
        for (int i = 0; i < array.size(); i++) {
            out.println(array.get(i));
        }
        return true;
    }
}