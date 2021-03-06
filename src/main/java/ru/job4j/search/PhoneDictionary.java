package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (var p : persons) {
            if (p.getAddress().contains(key)
                    || p.getName().contains(key)
                    || p.getPhone().contains(key)
                    || p.getSurname().contains(key)) {
                result.add(p);
            }
        }
        return result;
    }

    public ArrayList<Person> findOne(String key) {

        Predicate<Person> findGetName = x -> x.getName().contains(key);

        Predicate<Person> findGetPhone = x -> x.getPhone().contains(key);

        Predicate<Person> findGetAddress = x -> x.getAddress().contains(key);

        Predicate<Person> findGetSurname = x -> x.getSurname().contains(key);

        Predicate<Person> combine = findGetName
                .or(findGetAddress
                .or(findGetPhone
                .or(findGetSurname)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}