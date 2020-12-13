package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate now) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (now.test(att.getSize())) {
                rsl.add(att);
            }
        }
        return rsl;
    }
    Predicate<Integer> now = new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return false;
        }
    };
}