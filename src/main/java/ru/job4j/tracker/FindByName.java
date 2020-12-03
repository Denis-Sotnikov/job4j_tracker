package ru.job4j.tracker;

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
        Item[] array = tracker.findByName(name);
        if (array.length>0) {
            for (int i = 0; i < array.length; i++) {
                out.println(array[i].toString());
            }
        } else {
                out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
