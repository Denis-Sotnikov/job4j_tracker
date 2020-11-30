package ru.job4j.profession;

public class Programmer extends Engineer {
    private String hobby;
    private String type;
    public Programmer(String name, String surname, String education, String birthday, String hobby, String type) {
        super(name, surname, education, birthday);
        this.hobby = hobby;
        this.type = type;
    }

    public String getHobby() {
        return hobby;
    }

    public String getType() {
        return type;
    }
}
