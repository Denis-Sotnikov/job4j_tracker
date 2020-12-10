package ru.job4j.collection;

import java.util.Comparator;



public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] arrayLeft = left.split(". ");
        String[] arrayRight =right.split(". ");
        try{
            if (arrayLeft != null && arrayRight != null){
                int leftInt = Integer.parseInt(arrayLeft[0]);
                int rightInt = Integer.parseInt(arrayRight[0]);
                return Integer.compare(leftInt, rightInt);
            }
        }
        catch (NumberFormatException e){
            System.out.println("Введите валидный номер. Данный номер невалиден");
        }
        return Integer.parseInt(null);
    }

    public static void main(String[] args) {
        LexSort lexSort = new LexSort();
        System.out.println(lexSort.compare("10. werew. wewq", "1. sdfdsf"));
    }
}