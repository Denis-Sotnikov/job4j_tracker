package ru.job4j.collection;

import java.util.*;

public class Article {
    public static boolean generateBy(String origin, String line) {
        origin = origin.replaceAll("\\p{P}", "");
        String[] boxOrigin = origin.split(" ");
        Set<String> boxOriginList = new HashSet<String>();
        boxOriginList.addAll(Arrays.asList(boxOrigin));
        line = line.replaceAll("\\p{P}", "");
        String[] boxLine = line.split(" ");
        for (int i = 0; i < boxLine.length; i++) {
            if (!boxOriginList.contains(boxLine[i])) {
                return false;
            }
        }
        return true;
    }
}