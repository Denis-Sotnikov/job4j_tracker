package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private List<Integer> listForObject = new ArrayList<>();

    public EasyStream(List<Integer> listForObject) {
        this.listForObject = listForObject;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> listForMap = new ArrayList<>();
        for (int i = 0; i < this.listForObject.size(); i++) {
            listForMap.add(fun.apply(this.listForObject.get(i)));
        }
        this.listForObject = listForMap;
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> listForFilter = new ArrayList<>();
        for (int i = 0; i < this.listForObject.size(); i++) {
            if (fun.test(this.listForObject.get(i))) {
                listForFilter.add(this.listForObject.get(i));
            }
        }
        this.listForObject = listForFilter;
        return this;
    }

    public List<Integer> collect() {
        return this.listForObject;
    }
}