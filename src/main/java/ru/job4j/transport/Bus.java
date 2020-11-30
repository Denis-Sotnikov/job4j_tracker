package ru.job4j.transport;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Двигается по атомобильным дорогам");
    }

    @Override
    public void availableSpeed() {
        System.out.println("Доступная скорость = 60 км/ч");
    }
}
