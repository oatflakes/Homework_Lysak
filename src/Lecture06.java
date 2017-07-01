import java.util.Random;
import java.util.Scanner;

public class Lecture06 {
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

        System.out.println("Лекция 6. Методы Домашнее задание.");
        while (repeat) {
            System.out.println("");
            System.out.println("Выберите задание 1-5");
            System.out.println(" 1. Программа для банка");
            System.out.println(" 2. Конвертер валют");
            System.out.println(" 3. Арифметические методы");
            System.out.println(" 4. Работа с массивом 1");
            System.out.println(" 5. Работа с массивом 2");
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
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void task01() {
        System.out.println("Представьте, что вы реализуете программу для банка, которая помогает\n" +
                "определить, погасил ли клиент кредит или нет. Допустим, ежемесячная сумма\n" +
                "платежа должна составлять 100 грн. Клиент должен выполнить 7 платежей, но\n" +
                "может платить реже большими суммами. Т.е., может двумя платежами по 300\n" +
                "и 400 грн. Закрыть весь долг. Создайте метод, который будет в качестве\n" +
                "аргумента принимать сумму платежа, введенную экономистом банка. Метод\n" +
                "выводит на экран информацию о состоянии кредита (сумма задолженности,\n" +
                "сумма переплаты, сообщение об отсутствии долга).");

    }

    private static void task02() {
        System.out.println("Напишите программу, которая будет выполнять конвертирование валют.\n" +
                "Пользователь вводит: сумму денег в определенной валюте, курс для\n" +
                "конвертации в другую валюту. Организуйте вывод результата операции\n" +
                "конвертирования валюты на экран.");

    }

    private static void task03() {
        System.out.println("Напишите метод, который будет определять:\n" +
                "1) является ли введенное число положительным или отрицательным.\n" +
                "2) Является ли оно простым (используйте технику перебора значений).\n" +
                "3) Делится ли на 2, 5, 3, 6, 9 без остатка.");
        int q=myInput.getInt("Введите число ",scanner,0,0);
        arythmetic(q);
    }

    private static void task04() {
        System.out.println("Напишите метод, который в качестве аргумента принимает одномерный\n" +
                "целочисленный массив, и сортирует его “Методом пузырька”. Также\n" +
                "напишите отдельный метод, для вывода массива на экран.");

    }

    private static void task05() {
        System.out.println("Напишите метод, который принимает 2 аргумента : целочисленный массив, и\n" +
                "целочисленное число. В методе организуйте проверку, содержит ли массив это\n" +
                "число. Метод должен возвращать логическое значение (true – содержит, false –\n" +
                "не содержит). Создайте перегрузку этого метода, который в качестве первого\n" +
                "аргумента принимает массив элементов типа double, а в качестве второго\n" +
                "аргумента принимает аргумент типа double .");

    }

    public static void arythmetic(int a) {
        a = myInput.getInt("Введите целое число", scanner, 0, 0);
        if (a >= 0) {
            System.out.println("1) Число " + a + " это положительное число");
        } else {
            System.out.println("1) Число " + a + " это отрицательное число");
        }
        if (Lecture04.isSimpleNum(a)) {
            System.out.println("2) Число " + a + " это простое число");
        } else {
            System.out.println("2) Число " + a + "не является простым");
        }
        System.out.print("3) ");
        int[] array = {2,5,3,6,9};
        for (int i = 0; i < array.length; i++) {
            if (a/array[i]==0){
                System.out.println("Число "+a+ " делится на" +array[i]);
            }
        }
    }


}