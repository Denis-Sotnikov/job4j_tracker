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
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }
    public Item[] findAll(){
        return Arrays.copyOf(this.items, size);
    }
    public Item[] findByName(String key){
        Item[] itemsNames = new Item[this.items.length];
        int count=0;
        for (int i = 0; i < this.size; i++) {
                    if (this.items[i].getName().equals(key)){
                        itemsNames[count] = this.items[i];
                        count++;
                    }
        }
        return Arrays.copyOf(itemsNames, count);
    }
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (this.items[index].getId() == id) {
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
            this.items[index] = item;
            return true;
        }
            return false;
    }
    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl){
            System.arraycopy(this.items, index+1, this.items, index, this.items.length-index-1);
            size--;
            return true;
        }
        return false;

    }
}