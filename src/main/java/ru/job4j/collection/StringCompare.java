package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int size = left.length() >= right.length() ? right.length() : left.length();
        int result = 0;
        for (int i = 0; i < size; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}