package ru.job4j;

import java.util.List;
import java.util.Optional;

public class Shell {
    String paths = "";

    public void cd(String path) {
        String[] arr = path.split("/");
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].isEmpty()) {
                paths = paths + "/" + arr[i];
            }
        }
        if (arr.length == 0) {
            paths = paths + path;
        }
        if (paths.endsWith("..")) {
            System.out.println("yes");
            String buf = "";
            String[] array = paths.split("/");
            for (int i = 0; i < array.length-2; i++) {
                if (!array[i].isEmpty()) {
                    buf = buf + array[i] + "/";
                }
            }
            paths = buf;
            if (paths.isEmpty()) {
                paths = "/";
            }
        }
    }

    public String pwd() {
        return paths;
    }
}
