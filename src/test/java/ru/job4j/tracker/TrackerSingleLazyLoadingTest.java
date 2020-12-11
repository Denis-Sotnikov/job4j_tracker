package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingleLazyLoadingTest {

    @Test
    public void when() {

        TrackerSingleLazyLoading one = TrackerSingleLazyLoading.getInstance();
        TrackerSingleLazyLoading two = TrackerSingleLazyLoading.getInstance();
        assertSame(one, two);
    }

}