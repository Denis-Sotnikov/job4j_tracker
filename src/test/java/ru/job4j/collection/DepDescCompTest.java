package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.greaterThan;

public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        System.out.println(rsl);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore1() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K1"
        );
        System.out.println(rsl);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore2() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2"
        );
        System.out.println(rsl);
        assertThat(rsl, is(0));
    }

    @Test
    public void whenUpDepartmentGoBefore3() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K1/s"
        );
        System.out.println(rsl);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore4() {
        int rsl = new DepDescComp().compare(
                "K2/s",
                "K2"
        );
        System.out.println(rsl);
        assertThat(rsl, greaterThan(0));
    }

}