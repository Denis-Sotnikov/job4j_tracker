package ru.job4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Shell {
    private String paths = "";

    public void cd(String path) {
        String[] arr = path.split("/");
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].isEmpty()) {
                if (!paths.endsWith("/")) {
                    paths = paths + "/" + arr[i];
                } else {
                    paths = paths + arr[i];
                }
            }
        }
        int q = 0;
        if (paths.split("\\.\\.").length >= 2) {
            q = paths.split("\\.\\.").length;
        }
        if (arr.length == 0) {
            paths = paths + path;
        }
        if (paths.endsWith("..")) {
            String buf = "";
            String[] array = paths.split("/");
            for (int i = 0; i < array.length - 2 - (q * 2 - 2); i++) {
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

    public static void main(String[] args) {
        Shell shell = new Shell();
        shell.cd("home/user/dir1/dir2/dir3/dir4/dir5/dir6/dir7");
        System.out.println(shell.pwd());
        shell.cd("..");
        System.out.println(shell.pwd());
        shell.cd("../../../../../../..");
        System.out.println(shell.pwd());

    }
}
