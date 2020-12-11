package ru.job4j.poly;

public class Bus implements Transport {
    private int countOfPassengers = 0;

    @Override
    public void drive() {
        System.out.println("Автобус отправляется, держитесь за поручни.");
    }

    @Override
    public void passengers(int countPassengers) {
        this.countOfPassengers = countPassengers;
    }

    @Override
    public int refuel(int litrs) {
        int result = litrs * 44;
        System.out.println("Bus refuel succes");
        System.out.println("it cost " + result);
        return result;
    }
}
