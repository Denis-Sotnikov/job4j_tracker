package ru.job4j.tracker;

public class TrackerSingleLazyLoading {
    private TrackerSingleLazyLoading() {
    }

    public static TrackerSingleLazyLoading getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingleLazyLoading INSTANCE = new TrackerSingleLazyLoading();
    }

    public static void main(String[] args) {
        TrackerSingleLazyLoading tracker = TrackerSingleLazyLoading.getInstance();
    }
}