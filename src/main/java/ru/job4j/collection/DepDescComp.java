package ru.job4j.collection;

import java.util.*;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arrayLeft = left.split("/");
        String[] arrayRight = right.split("/");
        int size = arrayLeft.length > arrayRight.length ? arrayRight.length : arrayLeft.length;
        int result = 0;
        for (int i = 0; i < size; i++) {
            if (i==0) {
                result = arrayRight[i].compareTo(arrayLeft[i]);
                if (result != 0) {
                    return result;
                }
            }
            result = arrayLeft[i].compareTo(arrayRight[i]);
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(arrayLeft.length, arrayRight.length);
    }
}
