package ru.job4j.profession;

import org.w3c.dom.ls.LSOutput;

public class Builder extends Engineer {
    private static int finishedProject;
    private String areaJob;
    private int numberOfBuildingsBuilt;
    Object object = new Object();

    public Builder(String name, String surname, String education, String birthday, String areaJob, int numberOfBuildingsBuilt) {
        super(name, surname, education, birthday);
        this.areaJob = areaJob;
        this.numberOfBuildingsBuilt = numberOfBuildingsBuilt;
    }

    @Override
    public String getAreaJob() {
        return areaJob;
    }
    public static int getFinishedProject() {
        System.out.println("hello");
        return finishedProject;
    }

    public int getNumberOfBuildingsBuilt() {
        return numberOfBuildingsBuilt;
    }

    public static void main(String[] args) {
        getFinishedProject();

    }
}
