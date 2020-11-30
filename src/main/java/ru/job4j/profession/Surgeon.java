package ru.job4j.profession;

public class Surgeon extends Doctor {
    private int quantityOperations;

    public Surgeon(String name, String surname, String education, String birthday, int quantityOperations, int livesSaved) {
        super(name, surname, education, birthday);
        this.quantityOperations = quantityOperations;
        this.livesSaved = livesSaved;
    }

    private int livesSaved;

    public int getQuantityOperations() {
        return quantityOperations;
    }

    public int getLivesSaved() {
        return livesSaved;
    }
}
