package ru.job4j.collection;

import java.util.*;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        boolean flag = false, flag1 = false, flag2 = false;
        if (!left.contains("/")) {
            left = left + "/";
        }
        if (!right.contains("/")) {
            right = right + "/";
        }
        int size = left.length() >= right.length() ? right.length() : left.length();
        for (int i = 0; i < size; i++) {
            if (left.charAt(i) == '/') {
                flag1 = true;
            }
            if (right.charAt(i) == '/') {
                flag2 = true;
            }
            if (flag1 == true && flag2 == true) {
                flag = true;
            }
            if (flag == false) {
                result = Character.compare(right.charAt(i), left.charAt(i));
                if (result != 0) {
                    return result;
                }
            } else {
                result = Character.compare(left.charAt(i), right.charAt(i));
                if (result != 0) {
                    return result;
                }
            }
        }
        if (flag == false) {
            return Integer.compare(left.length(), right.length());
        }
        return Integer.compare(left.length(), right.length());
    }
}