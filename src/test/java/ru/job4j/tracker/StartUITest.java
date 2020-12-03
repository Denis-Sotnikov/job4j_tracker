package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void testEditItem() {
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        StartUI.deleteItem(new StubInput(answers), tracker);
        assertThat(tracker.findAll(), is(new Item[0]));
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat((out.toString()), Matchers.is("Menu." + System.lineSeparator() + "0. Create"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator() +
                "=== Create a new Item ====" + System.lineSeparator() +
                "Menu." + System.lineSeparator() + "0. Create"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()),"1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat((out.toString()), Matchers.is("Menu." + System.lineSeparator() + "0. Delete Item"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator() +
                "Item delete success" + System.lineSeparator() +
                "Menu." + System.lineSeparator() + "0. Delete Item"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceItemAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat((out.toString()), Matchers.is("Menu." + System.lineSeparator() + "0. Replace item"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator() + "=== Replace item ===="
                +  System.lineSeparator() + "Item edit success" +  System.lineSeparator()
                + "Menu." + System.lineSeparator() + "0. Replace item"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat((out.toString()), Matchers.is("Menu." + System.lineSeparator() + "0. Show all items"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator() + "=== Show all items ===="
                + System.lineSeparator() + item.toString() + System.lineSeparator() +
                "Menu." + System.lineSeparator() + "0. Show all items"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindById(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat((out.toString()), Matchers.is("Menu." + System.lineSeparator() + "0. Find item by Id"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator() +
                "=== Find item by Id ====" + System.lineSeparator() + item.toString() +
                System.lineSeparator() +
                "Menu." + System.lineSeparator() + "0. Find item by Id"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item name"));
        String name = "New item name";
        Input in = new StubInput(
                new String[] {"0", name, "1"}
        );
        UserAction[] actions = {
                new FindByName(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat((out.toString()), Matchers.is("Menu." + System.lineSeparator() + "0. Find items by name"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator() +
                "=== Find items by name ====" + System.lineSeparator() +
                item.toString() + System.lineSeparator() +
                "Menu." + System.lineSeparator() + "0. Find items by name"
                +  System.lineSeparator() + "1. Exit" + System.lineSeparator()));
    }
}