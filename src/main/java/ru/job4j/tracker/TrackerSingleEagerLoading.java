package ru.job4j.tracker;

public class TrackerSingleEagerLoading {
    private static final TrackerSingleEagerLoading INSTANCE = new TrackerSingleEagerLoading();

    private TrackerSingleEagerLoading() {
    }

    public static TrackerSingleEagerLoading getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingleEagerLoading tracker = TrackerSingleEagerLoading.getInstance();
    }
}