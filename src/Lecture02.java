import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lecture02 {
    private static Random random = new Random();
    MyArrays myArrays = new MyArrays();
    private static MyInput myInput = new MyInput();
    private static Scanner scanner = new Scanner(System.in);

    public MyArrays getMyArrays() {
        return myArrays;
    }

    public static void main(String[] args) {
        MyInput myInput = new MyInput();
        String choice = "";
        boolean repeat = true;

        System.out.println("Лекция 2. Домашнее задание");
        while (repeat) {
            System.out.println("");
            System.out.println("Выберите задание 1-10");
            System.out.println(" 1. Частное двух чисел с проверкой на /0");
            System.out.println(" 2. Год основания Одессы");
            System.out.println(" 3. Скидка");
            System.out.println(" 4. Четное число");
            System.out.println(" 5. Деление на три");
            System.out.println(" 6. Скидка на мобильные разговоры");
            System.out.println(" 7. Трехзначное число 1");
            System.out.println(" 8. Трехзначное число 2");
            System.out.println(" 9. Меньшее из двух чисел");
            System.out.println("10. Уравнение");
            System.out.println("Exit: other");
            System.out.println("");
            try {
                choice = myInput.getString("", scanner);
            } catch (Exception e) {
                System.out.println("Что-то пошло не так");
            }
            switch (choice) {
                case "1":
                    task01();
                    break;
                case "2":
                    task02();
                    break;
                case "3":
                    task03();
                    break;
                case "4":
                    task04();
                    break;
                case "5":
                    task05();
                    break;
                case "6":
                    task06();
                    break;
                case "7":
                    task07();
                    break;
                case "8":
                    task08();
                    break;
                case "9":
                    task09();
                    break;
                case "10":
                    task10();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void task01() {
        System.out.println("Написать программу которая вычисляет частное двух чисел.\n" +
                "Программа должна проверять правильность введенных пользователем данных и,\n" +
                "если они неверные (делитель равен нулю), выдавать сообщение об ошибке.");

        double a = 0;
        double b = 0;
        a = myInput.getDouble("Введите делимое", scanner);
        b = myInput.getDouble("Введите делитель, неравный нулю", scanner);
        if (b == 0) {
            System.out.println("Ошибка, на ноль делить нельзя");
        } else {
            System.out.println("Результат деления: " + a / b);
        }
    }

    private static void task02() {
        System.out.println("Написать программу для проверки знания даты основания Одессы. В случае");
        System.out.println("неправильного ответа пользователя, программа должна выводить правильный");
        System.out.println("ответ. Ниже приведён возможный вид экрана во время выполнения такой");
        System.out.println("программы (Данные, вводимые пользователем, выделены полужирным шрифтом).");

        int yearCity = 1794;
        int q = 0;

        q = myInput.getInt("В каком году была основана Одесса?", scanner, 0, 0);
        if (q == yearCity) {
            System.out.println("Правильно!");
        } else if (q > yearCity) {
            System.out.println("Неправильно, Одесса была основана раньше - в " + yearCity + " году");
        } else {
            System.out.println("Неправильно, Одесса была основана позже - в " + yearCity + " году");
        }
    }

    private static void task03() {
        System.out.println("Написать программу для вычисления стоимости покупки с учетом скидки.");
        System.out.println("Скидка в 3% предоставляется, если сумма покупки больше 500 руб, в 5% — если");
        System.out.println("сумма больше 1000 руб.");

        double userPrice = 0;
        double myDiscount = 0;
        double myPrice = 0;

        userPrice = myInput.getDouble("Введите стоимость товара: ", scanner);

        if (userPrice > 1000) {
            myDiscount = 0.05;
        } else if (userPrice > 500) {
            myDiscount = 0.03;
        } else {
            myDiscount = 0;
        }

        myPrice = userPrice * (1 - myDiscount);

        if (myDiscount == 0) {
            System.out.println("Скидка не предоставляется. Стоимость товара: " + myPrice + " грн");
        } else {
            System.out.println("Вам предоставлена скидка: " + 100 * myDiscount + "%");
            System.out.println("Стоимость товара с учетом скидки " + myPrice + " грн");
        }
    }

    private static void task04() {
        System.out.println("Написать программу, которая проверяет, является ли введённое");
        System.out.println("пользователем целое число четным. ");

        int a = 0;
        a = myInput.getInt("Введите целое число для проверки: ", scanner, 0, 100000000);
        if (a % 2 == 0) {
            System.out.println("Число " + a + " четное");
        } else {
            System.out.println("Число " + a + " нечетное");
        }
    }

    private static void task05() {
        System.out.println("Написать программу, которая проверяет, делится ли на три введённое с");
        System.out.println("клавиатуры целое число. ");

        int a = 0;
        a = myInput.getInt("Введите целое число для проверки: ", scanner, 0, 100000000);
        if (a % 3 == 0) {
            System.out.println("Число " + a + " делится на три");
        } else {
            System.out.println("Число " + a + " не делится на три");
        }
    }

    private static void task06() {
        System.out.println("Написать программу для вычисления стоимости разговора по телефону с");
        System.out.println("учетом 20% скидки, предоставляемой по субботам и воскресеньям.");

        int duration, weekday;
        double discount = 0, sum;
        String dClaim = "Скидка не предоставляется";
        duration = myInput.getInt("Введите исходные данные:\n" +
                "Длительность разговора (целое количество минут) ->", scanner, 0, 0);
        System.out.println("День недели (1 — понедельник, ... 7 — воскресенье) ->");
        weekday = scanner.nextInt();

        if (weekday > 5 && weekday < 8) {
            discount = 0.2;
            dClaim = "Предоставляется скидка " + 100 * discount + "%";
        }

        sum = 5.52 * duration * (1 - discount);

        System.out.println(dClaim);
        System.out.println("Стоимость разговора " + sum + " грн");
    }

    private static void task07() {
        System.out.println("Дано трехзначное число. Определить, какая из его цифр больше:");
        System.out.println("а) первая или последняя;");
        System.out.println("б) первая или вторая;");
        System.out.println("в) вторая или последняя.");

        int xyz = 0;
        int x, y, z;

        xyz = myInput.getInt("Введите трехзначное число", scanner, 100, 999);

//Определяем цифры

        x = xyz / 100;
        y = xyz / 10 - x * 10;
        z = xyz - x * 100 - y * 10;

//проверяем первое условие задачи

        if (x > z) {
            System.out.println("Первая цифра больше, чем последняя");
        } else if (x == z) {
            System.out.println("Первая цифра равна последней");
        } else {
            System.out.println("Последняя цифра больше, чем первая");
        }


//проверяем второе условие задачи

        if (x > y) {
            System.out.println("Первая цифра больше, чем вторая");
        } else if (x == y) {
            System.out.println("Первая цифра равна второй");
        } else {
            System.out.println("Вторая цифра больше, чем первая");
        }

//третье условие
        if (y > z) {
            System.out.println("Вторая цифра больше, чем последняя");
        } else if (y == z) {
            System.out.println("Вторая цифра равна последней");
        } else {
            System.out.println("Последняя цифра больше, чем вторая");
        }

    }

    private static void task08() {
        System.out.println("Дано трехзначное число. Определить, равен ли квадрат этого числа сумме");
        System.out.println("кубов его цифр.");

//квадрат минимального трехзначного числа 100*100=10000");
//сумма кубов цифр максимального трехзначного числа 999 = 729*3 = 2187
//для трехзначного числа невыполнимое условие в задаче

        int xyz;
        int x, y, z;
        double digitsCube;

        xyz = myInput.getInt("Введите трехзначное число", scanner, 100, 999);

        x = xyz / 100;
        y = xyz / 10 - x * 10;
        z = xyz - x * 100 - y * 10;

        digitsCube = Math.pow(x, 3) + Math.pow(y, 3) + Math.pow(z, 3);

        if (xyz * xyz == digitsCube) {
            System.out.println("Условие задачи выполнено");
        } else {
            System.out.println("Условие задачи не выполнено");
        }
    }

    private static void task09() {
        System.out.println("Даны вещественные числа х и у, не равные друг другу. Меньшее из этих");
        System.out.println("двух чисел заменить половиной их суммы, а большее — их удвоенным");
        System.out.println("произведением.");

        double x = 0;
        double y = 0;
        double min = 0;
        double max = 0;

        x = myInput.getDouble("Введите х: ", scanner);
        y = myInput.getDouble("Введите y: ", scanner);

        min = (x + y) / 2;
        max = 2 * x * y;

        if (x == y) {
            System.out.println("x = y, невозможно заменить");
        } else if (x > y) {
            x = max;
            y = min;
        } else {
            x = min;
            y = max;
        }
        System.out.println("x: " + x + "; y: " + y);

    }

    private static void task10() {
        System.out.println("Написать программу решения уравнения ax3 + bх = 0 для произвольных а, b.");
        double a = 1;//не равно 0
        double b = 0;
        double x;
        a = myInput.getDouble("a: ", scanner);
        b = myInput.getDouble("b: ", scanner);

        x = Math.sqrt(-b / a);
        System.out.println(x);
    }
}




