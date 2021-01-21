package ru.job4j;

import org.codehaus.plexus.util.CollectionUtils;

import java.util.*;

public class Shell {
    List<String> listString = new ArrayList<>();

    public void cd(String path) {
        if (listString.isEmpty()) {
            listString.add("");
        }

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
        int q = 0;
        if (listString.toString().split("\\.\\.").length >= 2) {
            q = listString.toString().split("\\.\\.").length - 1;
        }

        if (listString.get(listString.size()-1).endsWith("..")) {
            int size = listString.size();
            for (int i = listString.size() - 1; i > size - 3 - (q * 2 - 2); i--) {
                listString.remove(i);
            }
        }
    }

    public String pwd() {
        return listString.toString()
                .replaceFirst("\\[", "")
                .replaceFirst("\\]", "")
                .replaceAll(",", "");
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
