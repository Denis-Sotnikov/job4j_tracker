package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        MemTracker tracker = new MemTracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll().get(0);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void testEditItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), // id сохраненной заявки в объект tracker.
                "replaced item"
        };
        StartUI.editItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void testDeleteItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        StartUI.deleteItem(new StubInput(answers), tracker);
        assertThat(tracker.findAll().toArray(), is(new Item[0]));
    }

    @Test
    public void whenCreateItem() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat((out.toString()), Matchers.is("Menu." + System.lineSeparator() + "0. Create"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator()
                + "=== Create a new Item ====" + System.lineSeparator()
                + "Menu." + System.lineSeparator() + "0. Create"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenDeleteItem() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat((out.toString()), Matchers.is("Menu." + System.lineSeparator() + "0. Delete Item"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator()
                + "Item delete success" + System.lineSeparator()
                + "Menu." + System.lineSeparator() + "0. Delete Item"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenReplaceItem() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceItemAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat((out.toString()), Matchers.is("Menu."
                + System.lineSeparator()
                + "0. Replace item"
                + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Replace item ===="
                + System.lineSeparator()
                + "Item edit success"
                +  System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Replace item"
                +  System.lineSeparator()
                + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenExit() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllItem() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindAllAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat((out.toString()), Matchers.is("Menu."
                + System.lineSeparator()
                + "0. Show all items"
                + System.lineSeparator() + "1. Exit"
                + System.lineSeparator()
                + "=== Show all items ===="
                + System.lineSeparator()
                + item.toString() + System.lineSeparator()
                + "Menu." + System.lineSeparator() + "0. Show all items"
                +  System.lineSeparator()
                + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindById() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindById(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat((out.toString()), Matchers.is("Menu."
                + System.lineSeparator() + "0. Find item by Id"
                + System.lineSeparator() + "1. Exit" + System.lineSeparator()
                + "=== Find item by Id ===="
                + System.lineSeparator()
                + item.toString()
                + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Find item by Id"
                +  System.lineSeparator()
                + "1. Exit"
                + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() throws SQLException {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("New item name"));
        String name = "New item name";
        Input in = new StubInput(
                new String[] {"0", name, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByName(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat((out.toString()), Matchers.is("Menu."
                + System.lineSeparator() + "0. Find items by name"
                + System.lineSeparator() + "1. Exit" + System.lineSeparator()
                + "=== Find items by name ===="
                + System.lineSeparator()
                + item.toString()
                + System.lineSeparator()
                + "Menu." + System.lineSeparator() + "0. Find items by name"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() throws SQLException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"8", "0"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        MemTracker tracker = new MemTracker();
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}