package ru.job4j.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] oneArray : list) {
            for (int s : oneArray) {
                rsl.add(s);
            }
        }
        return rsl;
    }
}