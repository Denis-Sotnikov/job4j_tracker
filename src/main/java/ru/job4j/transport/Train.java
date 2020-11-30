package ru.job4j.transport;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Двигается по железнодорожным путям");
    }

    @Override
    public void availableSpeed() {
        System.out.println("Доступная скорость = 70 км/ч");
    }

    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle airplane = new Airplane();
        Vehicle[] array = new Vehicle[3];
        array[0] = train;
        array[1] = bus;
        array[2] = airplane;
        for (int i = 0; i < array.length; i++) {
            array[i].move();
            array[i].availableSpeed();
            System.out.println();
        }

    }
}
