package ru.job4j.transport;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Двигается по воздуху");
    }

    @Override
    public void availableSpeed() {
        System.out.println("Доступная скорость = 800 км/ч");
    }
}
