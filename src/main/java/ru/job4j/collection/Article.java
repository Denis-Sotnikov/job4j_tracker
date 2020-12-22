package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Article {
    public static boolean generateBy(String origin, String line) {
        origin = origin.replaceAll("\\p{P}", "");
        String[] boxOrigin = origin.split(" ");
        List<String> boxOriginList = Arrays.asList(boxOrigin);
        int count = 0;
        line = line.replaceAll("\\p{P}", "");
        String[] boxLine = line.split(" ");
        List<String> boxLineList = Arrays.asList(boxLine);
        if (boxOriginList.containsAll(boxLineList)) {
            return true;
        }
        return false;
    }
}