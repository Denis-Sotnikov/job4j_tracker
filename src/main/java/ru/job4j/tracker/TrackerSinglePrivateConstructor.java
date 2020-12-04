package ru.job4j.tracker;
import ru.job4j.tracker.Item;

public class TrackerSinglePrivateConstructor {
    private static TrackerSinglePrivateConstructor instance;

    private TrackerSinglePrivateConstructor() {
    }

    public static TrackerSinglePrivateConstructor getInstance() {
        if (instance == null) {
            instance = new TrackerSinglePrivateConstructor();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }
}
