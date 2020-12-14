package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CalculateFunction {

    private Function<Double, Double> func = new Function<Double, Double>() {
        @Override
        public Double apply(Double aDouble) {
            return aDouble;
        }
    };

    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> decision = new ArrayList<>();
        Double total = Double.valueOf(0);
        for (int i = start; i < end; i++) {
            decision.add(func.apply((double) i));
        }
        return decision;
    }
}
