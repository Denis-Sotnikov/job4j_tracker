package ru.job4j.collection;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class UserSort implements Comparator<User> {
    @Override
    public int compare(User first, User second) {
        return first.getName().compareTo(second.getName());
    }
}
