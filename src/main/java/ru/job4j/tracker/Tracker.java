package ru.job4j.tracker;

import java.util.*;

public class Tracker {
    private List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);//тут добавление и возможно тут ошибка, может быть добавляет в начало, а может в конец
        return item;
    }
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }
    public List<Item> findAll(){
        return items;
    }
    public List<Item> findByName(String key){
        List<Item> itemsNames = new ArrayList<>();
        int count=0;
        for (int i = 0; i < this.items.size(); i++) {
                    if (this.items.get(i).getName().equals(key)){
                        itemsNames.add(this.items.get(i));
                    }
        }
        return itemsNames;
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
        if (rsl){
            item.setId(id);
            this.items.set(index, item);
            return true;
        }
            return false;
    }
    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl){
            items.remove(index);
            return true;
        }
        return false;
    }
}