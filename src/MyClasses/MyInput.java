package MyClasses;

import java.util.Scanner;

public class MyInput {
    public String getString(String inputMessage, Scanner scanner) {
        String str = "";
        System.out.println(inputMessage);
        return scanner.next();
    }

    public int getInt(String inputMessage, Scanner scanner, int min, int max) {
        boolean inputIsInt;
        boolean inputIsCorrect = false;
        int intOut = 0;
        while (!inputIsCorrect) {
            do {
                System.out.println(inputMessage);
                try {
                    intOut = Integer.parseInt(scanner.next());
                    inputIsInt = true;
                } catch (Exception e) {
                    System.out.println("Введите число");
                    inputIsInt = false;
                }
            } while (!inputIsInt);

            if (min == 0 && max == 0) {
                inputIsCorrect = true;
            } else {
                if (intOut > max + 1 || intOut < min) {
                    System.out.println("Введите число от " + min + " до " + max);
                    inputIsCorrect = false;
                } else {
                    inputIsCorrect = true;
                }
            }

        }
        return (intOut);
    }

    public double getDouble(String inputMessage, Scanner scanner) {
        boolean inputIsDbl = false;
        double dblOut = 0;
        do {
            System.out.println(inputMessage);
            try {
                dblOut = Double.parseDouble(scanner.next());
                inputIsDbl = true;
            } catch (Exception e) {
                System.out.println("Введите число");
                inputIsDbl = false;
            }
        } while (!inputIsDbl);

        return (dblOut);
    }
}