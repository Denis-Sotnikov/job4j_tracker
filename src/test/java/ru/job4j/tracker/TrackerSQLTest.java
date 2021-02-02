package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item(1, "desc"));
            assertThat(tracker.findByName("desc").size(), is(1));
        }
    }

    @Test
    public void deleteItem() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item it = tracker.add(new Item(1, "desc"));
            assertThat(tracker.findByName("desc").size(), is(1));
            assertThat(tracker.delete(String.valueOf(it.getId())), is(true));
        }
    }

    @Test
    public void replaceItem() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item it = tracker.add(new Item(1, "desc"));
            assertThat(tracker.findByName("desc").size(), is(1));
            System.out.println(tracker.replace(
                    String.valueOf(it.getId()), new Item(it.getId(), "Tonya")));
            assertThat(tracker.findByName("Tonya").get(0), is(new Item(it.getId(), "Tonya")));
        }
    }

    @Test
    public void findAllItems() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item(1, "desc"));
            tracker.add(new Item(2, "Tonya"));
            assertThat(tracker.findAll().size(), is(2));
        }
    }

    @Test
    public void findById() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item(1, "desc"));
            assertThat(tracker.findById(String.valueOf(item.getId())).getId(), is(item.getId()));
        }
    }
}