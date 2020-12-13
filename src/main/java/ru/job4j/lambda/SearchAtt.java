package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class SearchAtt {
    private Predicate<Attachment> now = new Predicate<Attachment>() {
        @Override
        public boolean test(Attachment at) {
            return false;
        }
    };

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

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> now) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (now.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}