package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        byte[] arrayLeft = left.getBytes();
        byte[] arrayRight = right.getBytes();
        int size = left.length()>=right.length() ? right.length() : left.length();
        for (int i = 0; i < size; i++) {
            if (arrayLeft[i]<arrayRight[i])
                return -1;
            if (arrayLeft[i] == arrayRight[i]){
                if (i != size-1)
                    continue;
                else
                    if (left.length() == right.length())
                        return 0;
                    else
                        return left.length()>right.length() ? 1 : -1;
            }
            if (arrayLeft[i]>arrayRight[i])
                return 1;
        }
        return 0;
    }
}