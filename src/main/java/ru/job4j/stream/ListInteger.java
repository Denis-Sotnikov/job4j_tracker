package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListInteger {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(-34);
        list.add(65);
        list.add(87);
        list.add(-123);
        list.add(4435);
        List<Integer> result = list.stream().filter(lis -> lis > 0).collect(Collectors.toList());
        System.out.println(result.toString());
    }
}
