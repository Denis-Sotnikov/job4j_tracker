package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        int index = 0;
        for (String s : value) {
            if(s.equals(key)){
                rsl = index;
                break;
            }
            index++;
        }
        if (rsl == -1){
            throw new ElementNotFoundException();
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] array = {"wer", "azx", "Hello"};
        try {
            System.out.println(indexOf(array, "az"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
