package ru.job4j.profession;

public class Doctor extends Profession {
    private String areaJob;
    private int recoveredPatients;

    public Doctor(String name, String surname, String education, String birthday, String areaJob, int recoveredPatients) {
        super(name, surname, education, birthday);
        this.areaJob = areaJob;
        this.recoveredPatients = recoveredPatients;
    }

    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }


    public String getAreaJob() {
        return areaJob;
    }

    public int getRecoveredPatients() {
        return recoveredPatients;
    }
}
