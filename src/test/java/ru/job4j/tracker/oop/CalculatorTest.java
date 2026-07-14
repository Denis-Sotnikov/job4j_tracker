package ru.job4j.tracker.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        float a = 5;
        float b = 6;
        Calculator calc = new Calculator();
        float expectedValue = a + b;
        float actualValue = calc.add(a, b);
        float value = 0.0001f;
        assertThat(actualValue).isEqualTo(expectedValue, withPrecision(value));
    }
}