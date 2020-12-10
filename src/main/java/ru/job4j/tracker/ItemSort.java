package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ItemSort implements Comparator<Item> {

    ArrayList<Item> listItem = new ArrayList<>();
    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
