package Lecture03;
import MyClasses.MyArrays;
import MyClasses.MyInput;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lecture03 {
    private static Random random = new Random();
    public MyArrays myArrays = new MyArrays();
    public static MyInput myInput = new MyInput();
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
            System.out.println(" 1. Функция, три варианта");
            System.out.println(" 2. Функция, аргумент с шагом");
            System.out.println(" 3. Цифры в натуральном числе");
            System.out.println(" 4. Ряд, *");
            System.out.println(" 5. Ряд");
            System.out.println(" 6. Уравнение");
            System.out.println(" 7. [done] 19/100");
            System.out.println(" 8. [done] 13/17");
            System.out.println(" 9. Прогрессия 1");
            System.out.println("10. Прогрессия 2");
            System.out.println("11. Фигуры");
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
                case "11":
                    task11();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void task01() {
        System.out.println("Составить программу для вычисления значений функции Fx(a,b) на отрезке a b с шагом h.\n" +
                "Результат представить в виде таблицы, первый столбец которой —\n" +
                "значения аргумента, второй — соответствующие значения функции.");

    }

    private static void task02() {
        System.out.println("Написать программу вычисления функции\n" +
                "Аргумент x принимает значения от 1 до 5 с шагом 0,5.");
    }

    private static void task03() {
        System.out.println("Дано натуральное число. Верно ли, что цифра а встречается в нем реже, чем цифра b?");
        int rang = 0;
        String a;
        a = myInput.getString("введите число >9", scanner);
        rang = a.length();


    }

    private static void task04() {
        System.out.println("Вычислить значение функции, где i, x  — элементы, вводимые с клавиатуры, k n ");
    }

    private static void task05() {
        System.out.println("Вычислить значение функции, где i, x  — элементы, вводимые с клавиатуры, k n ");
    }

    private static void task06() {
        System.out.println("Уравнение");
    }

    private static void task07() {
        System.out.println("Найти 15 первых натуральных чисел, делящихся нацело на 19 и больших 100.");
        int count = 0;
        int i = 100;
        while (count < 15) {
            if (i > 100 && (i % 19 == 0)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
    }

    private static void task08() {
        System.out.println("Найти 20 первых натуральных чисел, делящихся нацело на 13 или на 17 и больших 500.");
        int count = 0;
        int i = 500;
        while (count < 20) {
            if (i > 500 && (i % 13 == 0) && (i % 17 == 0)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
    }

    private static void task09() {
        System.out.println("Дана арифметическая прогрессия с параметрами а = 2, b = 4. Сколько нужно\n" +
                "взять членов прогрессии, начиная с первого, чтобы их сумма превысила\n" +
                "заданную величину Z. Написать программу решения задачи. Вывести искомое\n" +
                "число слагаемых, величину суммы и последнее слагаемое.");
    }

    private static void task10() {
        System.out.println("Дана арифметическая прогрессия 1, 5, 9, 13, ... Написать программу\n" +
                "определения суммы первых десяти ее членов. Вывести значение суммы и всех ее\n" +
                "слагаемых.");
    }

    private static void task11() {
        System.out.println("Напишите программы, которые выводят на экран :");
        System.out.println("прямоугольник");
        System.out.println("прямоугольный треугольник");
        System.out.println("равносторонний треугольник");
        System.out.println("ромб");
    }

}