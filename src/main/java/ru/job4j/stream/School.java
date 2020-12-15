package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public static Map<String, Student> collectToMap(List<Student> students) {
        Map<String, Student> mapStudent = students.stream().collect(Collectors.toMap(
                e -> e.getSurname(),
                e -> e
        ));
        return mapStudent;
    }
}
