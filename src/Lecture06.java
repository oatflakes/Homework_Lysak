import java.util.Arrays;
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

        System.out.println("Лекция 6. Методология ООП. Часть 1. Домашнее задание.");
        while (repeat) {
            System.out.println("");
            System.out.println("Выберите задание 1-5");
            System.out.println(" 1. [Готово] Программа для банка");
            System.out.println(" 2. [Готово] Конвертер валют");
            System.out.println(" 3. [Готово] Арифметические методы");
            System.out.println(" 4. [Готово] Работа с массивом 1");
            System.out.println(" 5. [Готово] Работа с массивом 2");
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
        double totalSum = 0;
        double remainedSum = 0;
        int paymentCount = 0;
        int paymentCounter = 0;

        double payment = 0;
        totalSum = (double) myInput.getInt("Введите сумму кредита, не более 1000000", scanner, 0, 1000000);
        remainedSum = totalSum;
        paymentCount = myInput.getInt("Введите количество платежей, от 2 до 24", scanner, 2, 24);
        boolean creditClosed = false;
        do {
            remainedSum = remainedSum - payment;
            creditDetailsPrint(totalSum, remainedSum, payment, paymentCount, paymentCounter);
            if (remainedSum > 0) {
                if(paymentCount<paymentCounter){
                    System.out.println("(!)Начисляется пеня(!)");
                }
                payment = myInput.getInt("Введите сумму платежа", scanner, 0, 100000);
            } else {
                creditClosed = true;
                System.out.println("Кредит погашен");
                if (remainedSum < 0) {
                    System.out.println("Переплата всего " + -remainedSum);
                }
            }

            paymentCounter++;

        } while (!creditClosed);
    }

    private static void creditDetailsPrint(double totalSum, double remainedSum, double payment, int paymentCount, int paymentCounter) {
        double credit = 0;
        credit = paymentCounter * totalSum / paymentCount;
        System.out.println("Сумма кредита: " + totalSum);
        if (remainedSum >= 0) {
            System.out.println("Тело кредита: " + remainedSum);
        } else {
            System.out.println("Тело кредита 0.00");
        }
        System.out.println("Сумма задолженности согласно графику погашения: " + credit);
        System.out.println("Погашено : " + (totalSum - remainedSum));
        System.out.println("Совершено платежей: " + paymentCounter);
        if (credit > (totalSum - remainedSum)) {
            System.out.println("Сумма задолженности по кредиту " + (credit - (totalSum - remainedSum)));
        } else if (credit < (totalSum - remainedSum)) {
            System.out.println("Переплата по графику " + -(credit - (totalSum - remainedSum)));
        } else {
            System.out.println("Оплаты по графику");
        }

    }

    private static void creditCalculate() {


    }


    private static void task02() {
        System.out.println("Напишите программу, которая будет выполнять конвертирование валют.\n" +
                "Пользователь вводит: сумму денег в определенной валюте, курс для\n" +
                "конвертации в другую валюту. Организуйте вывод результата операции\n" +
                "конвертирования валюты на экран.");

        double amount = 0;
        double exchangeRate = 0;
        boolean flag = false;

        while (!flag) {
            amount = myInput.getDouble("Введите сумму в вашей валюте ", scanner);
            if (amount <= 0) {
                System.out.println("Введите положительное число");
                flag = false;
            } else {
                flag = true;
            }
        }
        flag = false;
        while (!flag) {
            exchangeRate = myInput.getDouble("Введите курс ", scanner);
            if (exchangeRate < 0) {
                System.out.println("Введите положительное число");
                flag = false;
            } else {
                converter(amount, exchangeRate);
                flag = true;
            }
        }


    }

    private static void converter(double amount, double exchangeRate) {
        System.out.println("Сумма: " + amount);
        System.out.println("Курс обмена: " + exchangeRate);
        System.out.println("Эквивалент: " + amount * exchangeRate);
    }

    private static void task03() {
        System.out.println("Напишите метод, который будет определять:\n" +
                "1) является ли введенное число положительным или отрицательным.\n" +
                "2) Является ли оно простым (используйте технику перебора значений).\n" +
                "3) Делится ли на 2, 5, 3, 6, 9 без остатка.");
        int q = myInput.getInt("Введите число ", scanner, 0, 0);
        arythmetic(q);
    }

    private static void arythmetic(int a) {
        //a = myInput.getInt("Введите целое число", scanner, 0, 0);
        if (a >= 0) {
            System.out.println("1) Число " + a + " это положительное число");
        } else {
            System.out.println("1) Число " + a + " это отрицательное число");
        }
        boolean check;
        check = Lecture04.isSimpleNum(a);
        if (check) {
            System.out.println("2) Число " + a + " это простое число");
        } else {
            System.out.println("2) Число " + a + " не является простым");
        }
        System.out.print("3) \n");
        int[] array = {2, 5, 3, 6, 9};
        for (int i = 0; i < array.length; i++) {
            if (a % array[i] == 0) {
                System.out.println("Число " + a + " делится на " + array[i]);
            }
        }
    }

    private static void task04() {
        System.out.println("Напишите метод, который в качестве аргумента принимает одномерный\n" +
                "целочисленный массив, и сортирует его “Методом пузырька”. Также\n" +
                "напишите отдельный метод, для вывода массива на экран.");
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000) - 5000;
        }
        printArray(array);
        bubbleSort(array);
        System.out.println("Результат сортировки:");
        printArray(array);
    }

    private static void bubbleSort(int array[]) {
        int tmp = 0;
        boolean sorted;
        do {
            sorted = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    sorted = true;
                }
            }
        }
        while (sorted);
    }

    private static void printArray(int array[]) {
        System.out.println(Arrays.toString(array));
    }

    private static void printArray(double array[]) {
        System.out.println(Arrays.toString(array));
    }


    private static void task05() {
        System.out.println("Напишите метод, который принимает 2 аргумента : целочисленный массив, и\n" +
                "целочисленное число. В методе организуйте проверку, содержит ли массив это\n" +
                "число. Метод должен возвращать логическое значение (true – содержит, false –\n" +
                "не содержит). Создайте перегрузку этого метода, который в качестве первого\n" +
                "аргумента принимает массив элементов типа double, а в качестве второго\n" +
                "аргумента принимает аргумент типа double .");
        double[] array = new double[20];
        int[] array1 = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextDouble();
            array1[i] = random.nextInt(10000) - 5000;
        }
        System.out.println("Первый массив");
        printArray(array);
        double num = 0;
        num = myInput.getDouble("Введите число", scanner);
        boolean result;
        result = numberIsInArray(array, num);
        if (result) {
            System.out.println("Число " + num + " содержится в первом массиве");
        } else {
            System.out.println("Число " + num + " не содержится в первом массиве");
        }

        int num1 = 0;
        System.out.println("Второй массив");
        printArray(array1);
        num1 = myInput.getInt("Введите число", scanner, 0, 0);
        result = numberIsInArray(array1, num1);
        if (result) {
            System.out.println("Число " + num1 + " содержится во втором массиве");
        } else {
            System.out.println("Число " + num1 + " не содержится во втором массиве");
        }

    }

    private static boolean numberIsInArray(int array[], int num) {
        for (int element : array) {
            if (element == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean numberIsInArray(double array[], double num) {
        for (double element : array) {
            if (element == num) {
                return true;
            }
        }
        return false;
    }


}