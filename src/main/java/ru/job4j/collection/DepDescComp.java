package ru.job4j.collection;

import java.util.*;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arrayLeft = left.split("/");
        String[] arrayRight = right.split("/");
        int result = arrayRight[0].compareTo(arrayLeft[0]);
        return result != 0 ? result : left.compareTo(right);
    }
}
