package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        String[] leftArray = left.split("");
        List<String> leftList = Arrays.asList(leftArray);
        String[] rightArray = right.split("");
        List<String> rightList = Arrays.asList(rightArray);
        leftList.sort(Comparator.naturalOrder());
        rightList.sort(Comparator.naturalOrder());
        if (leftList.equals(rightList)) {
            return true;
        }
        return false;
    }
}
