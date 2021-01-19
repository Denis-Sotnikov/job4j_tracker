package ru.job4j.tracker;

import ru.job4j.tracker.*;

public class FindById implements UserAction {
    private final Output out;

    public FindById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find item by Id ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(String.valueOf(id));
        if (item != null) {
            out.println(item.toString());
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
