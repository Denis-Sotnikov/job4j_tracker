package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("space@yandex.ru", "Aleksandr Burcev");
        for (String s : map.keySet()) {
            String value = map.get(s);
            System.out.println(s + " " + value);
        }
    }

}