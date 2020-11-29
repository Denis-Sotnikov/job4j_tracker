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
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }
    public Item[] findAll(){
        Item[] ItemsWithoutNull = new Item[this.items.length];
        Item buf = new Item();
        int size = 0;
        for (int index = 0; index < this.items.length; index++) {
            buf = items[index];
            if (buf != null) {
                ItemsWithoutNull[size] = buf;
                size++;
            }
        }
        ItemsWithoutNull = Arrays.copyOf(ItemsWithoutNull, size);
        return ItemsWithoutNull;
    }
    public Item[] findByName(String key){
        Item[] ItemsNames = new Item[this.items.length];
        int count=0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] !=null){
                if (this.items[i].getName() != null){
                    if (this.items[i].getName().equals(key)){
                        ItemsNames[count] = this.items[i];
                        count++;
                    }
                }
            }
        }
        ItemsNames = Arrays.copyOf(ItemsNames, count);
        return ItemsNames;
    }
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
    public boolean replace(int id, Item item) {
        if (indexOf(id)>=0){
            int index = indexOf(id);
            item.setId(this.items[index].getId());
            this.items[index] = item;
            return true;
        }
        else{
            return false;
        }

    }
}