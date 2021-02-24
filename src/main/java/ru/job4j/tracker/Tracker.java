package ru.job4j.tracker;

import ru.job4j.tracker.store.Store;

import java.sql.SQLException;
import java.util.List;

public class Tracker implements Store {
    @Override
    public void init() {

    }

    @Override
    public Item add(Item item) throws SQLException {
        return null;
    }

    @Override
    public boolean replace(String id, Item item) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public List<Item> findByName(String key) {
        return null;
    }

    @Override
    public Item findById(String id) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
