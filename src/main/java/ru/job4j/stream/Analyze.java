package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.empty;
import static java.util.stream.Collectors.*;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(e -> e.getSubjects().stream())
                .mapToInt(e -> e.getScore())
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(e -> new Tuple(e.getName(), (e.getSubjects().stream())
                .mapToInt(w -> w.getScore())
                .average()
                .orElse(0))).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(e -> e.getSubjects().stream())
                .collect(groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(
                                e.getKey(),
                                e.getValue()
                        )
                )
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(e -> new Tuple(e.getName(), e.getSubjects().stream()
                .mapToInt(w -> w.getScore())
                .sum()
        ))
                .max((o1, o2) -> (Double.compare(o1.getScore(),
                        o2.getScore())))
                .orElse(new Tuple("tr", 12));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(e -> e.getSubjects().stream())
                .collect(groupingBy(Subject::getName, summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(
                                e.getKey(),
                                e.getValue()
                        )
                )
                .max((o1, o2) -> Double
                        .compare(o1.getScore(), o2.getScore()))
                .orElse(new Tuple("tr", 12));
    }
}