package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] array = tracker.findAll();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        return true;
    }
}