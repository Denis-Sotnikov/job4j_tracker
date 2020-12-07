package ru.job4j.profession;

public class Engineer extends Profession {
    private static int finishedProject;
    private String areaJob;

    public Engineer(String name, String surname, String education, String birthday, int finishedProject, String areaJob) {
        super(name, surname, education, birthday);
        this.finishedProject = finishedProject;
        this.areaJob = areaJob;
    }

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public static int getFinishedProject() {
        return finishedProject;
    }

    public String getAreaJob() {
        return areaJob;
    }
}
