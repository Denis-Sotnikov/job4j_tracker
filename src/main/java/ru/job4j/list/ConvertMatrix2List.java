package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] oneArray : array) {
            for (int x : oneArray) {
                list.add(x);
            }
        }
        return list;
    }
}