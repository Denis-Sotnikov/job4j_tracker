package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

//    public Item findById(int id) {
//        Item rsl = null;
//        for (int index = 0; index < size; index++) {
//            Item item = items[index];
//            if (item.getId() == id) {
//                rsl = item;
//                break;
//            }
//        }
//        return rsl;
//    }

    public Item[] findAll() {
        Item[] rsl = new Item[size];
        rsl = Arrays.copyOf(items, size);
        return rsl;
    }

    public Item[] findByName(String name) {
        Item[] rsl = new Item[size];
        int index = 0;
        for (int i = 0; i < items.length - 1; i++) {
            if (items[i] != null && items[i].getName().equals(name)) {
                rsl[index] = items[i];
                index++;
            }
        }
        rsl = Arrays.copyOf(rsl, index);
        return rsl;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        Item buferItem = findById(id);
        int index = indexOf(id);
        if (buferItem != null) {
            item.setId(buferItem.getId());
            items[index] = item;
            return true;
        }
        return false;
    }
}