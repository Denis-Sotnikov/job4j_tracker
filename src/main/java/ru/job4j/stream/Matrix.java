package ru.job4j.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Matrix {

    public static List<Integer> change(Integer[][] array) {
        return Arrays.stream(array)
                .flatMap(ar -> Stream.of(ar))
                .collect(Collectors.toList());
    }
}
