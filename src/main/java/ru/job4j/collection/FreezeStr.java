package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> leftMap = new HashMap<>();
        char[] leftArray = left.toCharArray();
        char[] rightArray = right.toCharArray();
        char keyLeft;
        char keyRight;
        for (int i = 0; i < leftArray.length; i++) {
            keyLeft = leftArray[i];
            if (!leftMap.containsKey(keyLeft)) {
                leftMap.put(keyLeft, 1);
            } else {
                int count = leftMap.get(keyLeft);
                leftMap.put(keyLeft, ++count);
            }
        }

        for (int i = 0; i < rightArray.length; i++) {
            keyRight = rightArray[i];
            if (leftMap.containsKey(keyRight)) {
                if (leftMap.get(keyRight) == 1) {
                 leftMap.remove(keyRight);
                } else {
                   int count = leftMap.get(keyRight);
                   leftMap.put(keyRight, --count);
                }
            }
        }
        return leftMap.isEmpty() ? true : false;
    }
}
