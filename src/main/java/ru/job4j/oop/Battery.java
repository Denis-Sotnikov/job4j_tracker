package ru.job4j.oop;

public class Battery {
    private int charge;
    public void exchange(Battery another){
        this.charge--;
        another.charge++;
    }
}
