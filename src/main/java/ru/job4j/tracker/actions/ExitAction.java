package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.UserAction;
import ru.job4j.tracker.store.Store;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}
