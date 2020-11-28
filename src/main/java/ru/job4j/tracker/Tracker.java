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
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
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
        System.out.println("=============");
        Item[] ItemsNames = new Item[this.items.length];
        int count=0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] !=null){
                if (this.items[i].getName() != null){
                    System.out.println(this.items[i].getName());
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
}