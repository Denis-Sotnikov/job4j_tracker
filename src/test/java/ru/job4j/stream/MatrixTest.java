package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixTest {
    private  Integer[][] matrix = new Integer[3][3];
    private List<Integer> expected = new ArrayList<>();

    @Before
    public void setUp() {
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[0][2] = 2;
        matrix[1][0] = 3;
        matrix[1][1] = 4;
        matrix[1][2] = 5;
        matrix[2][0] = 6;
        matrix[2][1] = 7;
        matrix[2][2] = 8;
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);
    }

    @Test
    public void testChange() {
        List<Integer> input = Matrix.change(matrix);
        assertThat(expected, is(input));
    }

}