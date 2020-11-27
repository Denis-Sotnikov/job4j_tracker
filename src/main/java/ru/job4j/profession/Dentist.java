package ru.job4j.profession;

public class Dentist extends Doctor {
    int experience;
    String education;

    public int getExperience() {
        return experience;
    }

    @Override
    public String getEducation() {
        return education;
    }
}
