package ru.job4j.tracker;

import ru.job4j.tracker.Interface.UserAction;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Завершить программу";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Завершение программы ===");
        return false;
    }
}