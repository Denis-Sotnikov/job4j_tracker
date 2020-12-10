package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemSortTest {

    @Test
    public void whenSortByName(){
        List<Item> listItem = new ArrayList<>();
        listItem.add(new Item(5,"Aleksandra"));
        listItem.add(new Item(1,"Viktoria"));
        listItem.add(new Item(0,"Olga"));
        List<Item> listExpected = new ArrayList<>();
        listExpected.add(new Item(5,"Aleksandra"));
        listExpected.add(new Item(0,"Olga"));
        listExpected.add(new Item(1,"Viktoria"));
        Collections.sort(listItem, new ItemSort());
        assertThat(listItem, is(listExpected));
    }
    @Test
    public void whenSortById(){
        List<Item> listItem = new ArrayList<>();
        listItem.add(new Item(5,"Aleksandra"));
        listItem.add(new Item(1,"Viktoria"));
        listItem.add(new Item(0,"Olga"));
        List<Item> listExpected = new ArrayList<>();
        listExpected.add(new Item(0,"Olga"));
        listExpected.add(new Item(1,"Viktoria"));
        listExpected.add(new Item(5,"Aleksandra"));
        Collections.sort(listItem);
        assertThat(listItem, is(listExpected));
    }

    @Test
    public void whenSortByIdGoDown(){
        List<Item> listItem = new ArrayList<>();
        listItem.add(new Item(0,"Olga"));
        listItem.add(new Item(1,"Viktoria"));
        listItem.add(new Item(5,"Aleksandra"));
        List<Item> listExpected = new ArrayList<>();
        listExpected.add(new Item(5,"Aleksandra"));
        listExpected.add(new Item(1,"Viktoria"));
        listExpected.add(new Item(0,"Olga"));
        Collections.sort(listItem, Collections.reverseOrder());
        assertThat(listItem, is(listExpected));
    }
}