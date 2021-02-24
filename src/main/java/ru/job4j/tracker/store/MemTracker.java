package ru.job4j.tracker.store;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.store.Store;

import java.util.*;

public class MemTracker implements Store {
    private List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    @Override
    public void init() {

    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        return replace(Integer.parseInt(id), item);
    }

    @Override
    public boolean delete(String id) {
        return delete(Integer.parseInt(id));
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> itemsNames = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < this.items.size(); i++) {
                    if (this.items.get(i).getName().equals(key)) {
                        itemsNames.add(this.items.get(i));
                    }
        }
        return itemsNames;
    }

    @Override
    public Item findById(String id) {
        return findById(Integer.parseInt(id));
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (this.items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            this.items.set(index, item);
            return true;
        }
            return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public void close() throws Exception {

    }
}