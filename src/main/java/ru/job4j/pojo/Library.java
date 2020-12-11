package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book world = new Book("Clean code");
        Book space = new Book("Space");
        Book star = new Book("Star");
        Book code = new Book("Code");
        Book[] biblioteka = new Book[4];
        biblioteka[0] = world;
        biblioteka[1] = space;
        biblioteka[2] = star;
        biblioteka[3] = code;
        for (int i = 0; i < biblioteka.length; i++) {
            System.out.println(biblioteka[i].getName());
        }
        System.out.println();
        Book tmp = new Book();
        tmp = biblioteka[0];
        biblioteka[0] = biblioteka[3];
        biblioteka[3] = tmp;
        for (int i = 0; i < biblioteka.length; i++) {
            System.out.println(biblioteka[i].getName());
        }
        System.out.println();
        for (int i = 0; i < biblioteka.length; i++) {
            if (biblioteka[i].getName().equals("Clean code")) {
                System.out.println(biblioteka[i].getName());
            }
        }
    }
}
