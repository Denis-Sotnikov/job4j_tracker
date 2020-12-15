package ru.job4j.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Matrix {
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[3][3];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[0][2] = 2;
        matrix[1][0] = 3;
        matrix[1][1] = 4;
        matrix[1][2] = 5;
        matrix[2][0] = 6;
        matrix[2][1] = 7;
        matrix[2][2] = 8;
        List<Integer> list = Arrays.stream(matrix)
                .flatMap(array -> Stream.of(array))
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
