package ru.job4j.profession;

public class Builder extends Engineer {
    private String areaJob;
    private int numberOfBuildingsBuilt;

    public Builder(String name, String surname, String education, String birthday, String areaJob, int numberOfBuildingsBuilt) {
        super(name, surname, education, birthday);
        this.areaJob = areaJob;
        this.numberOfBuildingsBuilt = numberOfBuildingsBuilt;
    }

    public String getAreaJob() {
        return areaJob;
    }

    public int getNumberOfBuildingsBuilt() {
        return numberOfBuildingsBuilt;
    }


}
