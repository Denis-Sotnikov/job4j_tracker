package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSinglePrivateConstructorTest {

    @Test
    public void when() {
        TrackerSinglePrivateConstructor one = TrackerSinglePrivateConstructor.getInstance();
        TrackerSinglePrivateConstructor two = TrackerSinglePrivateConstructor.getInstance();
        assertSame(one, two);
    }

}