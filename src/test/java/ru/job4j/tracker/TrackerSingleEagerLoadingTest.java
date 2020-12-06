package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingleEagerLoadingTest {

    @Test
    public void when() {
        TrackerSingleEagerLoading one = TrackerSingleEagerLoading.getInstance();
        TrackerSingleEagerLoading two = TrackerSingleEagerLoading.getInstance();
        assertSame(one,two);
    }
}