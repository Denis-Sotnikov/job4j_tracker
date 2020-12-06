package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingleEnumTest {

    @Test
    public void when() {
        TrackerSingleEnum one = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum two = TrackerSingleEnum.INSTANCE;
        assertSame(one,two);

}
}