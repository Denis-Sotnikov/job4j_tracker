package ru.job4j;

import java.util.*;

public class Shell {
    List<String> listString = new ArrayList<>();

    public void cd(String path) {
        if (listString.isEmpty()) {
            listString.add("");
        }

        if (path.equals("/")) {
            int size = listString.size();
            for (int i = size - 1; i > 1; i--) {
                listString.remove(i);
            }
        } else {
            if (path.startsWith("c:/")) {
                int size = listString.size();
                for (int i = size - 1; i > 0; i--) {
                    listString.remove(i);
                }
                listString.set(0, path);
            } else {
                if (!path.contains("..")) {
                    String[] arr = path.split("/");
                    for (int i = 0; i < arr.length; i++) {
                        if (!arr[i].isEmpty()) {
                            if (!listString.get(listString.size()-1).endsWith("/")) {
                                listString.add("/" + arr[i]);
                            } else {
                                listString.add("/" + arr[i]);
                            }
                        }
                    }
                } else {
                    int q = path.split("\\.\\.").length>0 ? path.split("\\.\\.").length : 1;
                        int size = listString.size();
                        for (int i = size - 1; i > size - 1 - q; i--) {
                            listString.remove(i);
                        }
                }
            }
            }
    }

    public String pwd() {
        return listString.toString()
                .replaceFirst("\\[", "")
                .replaceFirst("\\]", "")
                .replaceAll(",", "")
                .replaceAll(" ", "");
    }

    public static void main(String[] args) {
        Shell shell = new Shell();
        shell.cd("home/user/dir1/dir2/dir3/dir4/dir5/dir6/dir7");
        System.out.println(shell.pwd());
//        shell.cd("/");
        shell.cd("c:/");
//        shell.cd("..");
        System.out.println(shell.pwd());
//        shell.cd("../../../../../../..");
        System.out.println(shell.pwd());
    }
}
