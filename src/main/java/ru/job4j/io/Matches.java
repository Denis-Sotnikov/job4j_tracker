package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String playerOne = "Игрок 1";
        String playerTwo = "Игрок 2";
        String player = null;
        boolean flag = true;
        int count = 11;
        while (count>0){
            if (flag == true){
                player = playerOne;
                flag = false;
            }
            else {
                if (flag == false){
                    player = playerTwo;
                    flag = true;
                }
            }
            System.out.println("Спичек на столе " + count);
            System.out.println(player+", возьмите спички в количестве от 1 до 3");
            System.out.print("Введите количество спичек которое вы возьмете: ");
            int select = Integer.valueOf(input.nextLine());
            while(select<1 || select>3){
                System.out.print("Вы ввели неправильное количество спичек. Веедите от 1 до 3: ");
                select = Integer.valueOf(input.nextLine());
            }
            count = count - select;
        }
        System.out.println(player + " выиграл");
    }
}
