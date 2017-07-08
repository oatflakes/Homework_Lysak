package MyClasses;

import java.util.Scanner;

public class MyInput1 {

    int returnInt(String mmplayerName) {
        Scanner scanner = new Scanner(System.in);
        boolean inputIsFigure;
        int mmplayerMove = 0;
        do {
            System.out.println(mmplayerName + ", ваш ход");
            try {
                mmplayerMove = Integer.parseInt(scanner.next()) - 1;
                inputIsFigure = true;
            } catch (Exception e) {
                System.out.println("Введите число");
                inputIsFigure = false;
            }
        } while (!inputIsFigure);
        return mmplayerMove;
    }
}