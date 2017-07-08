package Lecture04;
import MyClasses.MyArrays;
import MyClasses.MyInput;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lecture04 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    MyArrays myArrays = new MyArrays();

    public MyArrays getMyArrays() {
        return myArrays;
    }

    public static void main(String[] args) {
        MyInput myInput = new MyInput();
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        boolean repeat = true;

        System.out.println("Лекция 4. Домашнее задание");
        while (repeat) {
            System.out.println("");
            System.out.println("Выберите задание 1-9");
            System.out.println("1. Шестизначное число");
            System.out.println("2. Десятиборье");
            System.out.println("3. Фигурное катание");
            System.out.println("4. Наибольшая последовательность");
            System.out.println("5. Простые числа");
            System.out.println("6. Замена минимума и максимума");
            System.out.println("7. Оставить только первые вхождения");
            System.out.println("8. Работа с массивами abc");
            System.out.println("9. Работа с массивами ab");
            System.out.println("Exit: other");
            System.out.println("");
            try {
                choice = myInput.getString("", scanner);
            } catch (Exception e) {
                System.out.println("Что-то пошло не так");
            }
            switch (choice) {
                case "1":
                    task01();//шестизначное число
                    break;
                case "2":
                    task02();//десятиборье
                    break;
                case "3":
                    task03();//фигурное катание
                    break;
                case "4":
                    task04();//наибольшая последовательность
                    break;
                case "5":
                    task05();//простые числа
                    break;
                case "6":
                    task06();//замена минимума и максимума
                    break;
                case "7":
                    task07();//оставить только первые вхождения
                    break;
                case "8":
                    task08();//abc
                    break;
                case "9":
                    task09();//ab
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void task01() {
        System.out.println("В массиве хранится информация о численности книг в каждом из 35 разделов библиотеки.");
        System.out.println("Выяснить, верно ли, что общее число книг в библиотеке есть шестизначное число");
        int[] array = new int[35];
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Сумма массива " + sum);

        if (sum > 99999 && sum < 1000000) {
            System.out.println("Это шестичное число");
        } else {
            System.out.println("Это не шестизначное число");
        }

    }

    private static void task02() {
        System.out.println("В массиве хранится информация о баллах, полученных спортсменом-десятиборцем в каждом из десяти");
        System.out.println("видов спорта. Для выхода в следующий этап соревнований общая сумма баллов должна превысить некоторое");
        System.out.println("известное значение. Определить, вышел ли данный спортсмен в следующий этап соревнований.");
        int[] array = new int[10];
        int sum = 0;
        int limit = 50;
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        System.out.println("Баллы: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Сумма баллов: " + sum);
        if (sum > limit) {
            System.out.println("Спортсмен прошел в следующий этап");
        } else {
            System.out.println("Спортсмен НЕ прошел в следующий этап");
        }
    }

    private static void task03() {
        System.out.println("Оценки, полученные спортсменом в соревнованиях по фигурному катанию (в баллах), хранятся в");
        System.out.println("массиве из 18 элементов. В первых шести элементах записаны оценки по обязательной программе, с седьмого");
        System.out.println("по двенадцатый — по короткой программе, в остальных — по произвольной программе. Выяснить, по какому");
        System.out.println("виду программы спортсмен показал лучший результат.");
        double[] array = new double[18];
        for (int i = 0; i < array.length; i++) {
            array[i] = (double) (random.nextInt(100)) + (double) (random.nextInt(1000)) / 1000;
        }
        System.out.println(Arrays.toString(array));
        int a = 0;
        int b = 0;
        double defSum = 0;
        double shortSum = 0;
        double randSum = 0;
        int defNum = 6;
        int shortNum = 12;

        for (int i = 0; i < array.length; i++) {
            if (i < defNum) {
                defSum = defSum + array[i];
            } else if (i < shortNum) {
                shortSum = shortSum + array[i];
            } else {
                randSum = randSum + array[i];
            }
        }
        System.out.println("Сумма баллов за обязательную программу: " + defSum);
        System.out.println("Сумма баллов за короткую программу: " + shortSum);
        System.out.println("Сумма баллов за произвольную программу: " + randSum);

        if (defSum > shortSum && defSum > randSum) {
            System.out.println("Больше всего баллов набрано за обязательную программу");
        }
        if (shortSum > defSum && shortSum > randSum) {
            System.out.println("Больше всего баллов набрано за короткую программу");
        }
        if (randSum > defSum && randSum > shortSum) {
            System.out.println("Больше всего баллов набрано за произвольную программу");
        }

    }

    private static void task04() {
        System.out.println("Написать программу определения в одномерном массиве вещественных чисел наибольшего количества");
        System.out.println("последовательно расположенных положительных чисел.");
        int[] array = new int[100];
        boolean flag = false;
        int counter = 0;
        int maxCounter = 0;
        int start = 0;
        int maxStart = 0;
        int t = 0;
        String str = "";
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000) - 5000;
        }

        for (int i = 0; i < array.length; i++) {
            if (i == 0) continue;
            if (array[i] > array[i - 1] && array[i] > 0 && flag) {
                flag = true;
                counter++;
            } else if (array[i] > array[i - 1] && array[i] > 0) {
                flag = true;
                start = i;
                counter++;
            } else {
                if (counter > maxCounter) {
                    maxCounter = counter;
                    maxStart = start;
                    start = 0;
                }
                counter = 0;
                flag = false;
            }
        }

        for (int i = 0; i < array.length; i++) {
            str = str + " " + array[i];
            if (((i + 1) % 10 == 0 && i != 0)) {
                System.out.println(t + ":" + str);
                t = t + 10;
                str = "";
            }
        }


        System.out.println("Наибольшая последовательность положительных чисел, по порядку: " + maxCounter);
        System.out.println("Первый элемент последовательности - " + maxStart + "-й элемент массива");

    }

    private static void task05() {
        System.out.println("Задан целочисленный массив размерности N. Есть ли среди элементов массива простые числа? Если");
        System.out.println("да, то вывести номера этих элементов.");
        int n = 100;
        int[] array = new int[n];
        String str = "";
        int t = 0;
//наполнение массива
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);

        }
//вывод массива на печать, строками по 10 элементов
        for (int i = 0; i < array.length; i++) {
            str = str + " " + array[i];
            if (((i + 1) % 10 == 0 && i != 0)) {
                System.out.println(t + ":" + str);
                t = t + 10;
                str = "";
            }
        }

//определяем, простое ли число и его индекс
        for (int i = 0; i < array.length; i++) {
            boolean flag;
            flag=isSimpleNum(array[i]);
            if (!flag) {
                System.out.println("Простое число: " + array[i] + ", порядковый номер в массиве: " + (i + 1));
            }
        }

    }

    public static boolean isSimpleNum(int a) {

        boolean flag = true;
        if (a > 1) {
            for (int j = 2; j < a; j++) {
                if (a % j == 0) {
                    flag = false;
                    break;
                }
            }
        } else if (a == 1) {
            return true;
        }else if(a<0){
            return  false;
        }
        return flag;
    }

    private static void task06() {
        System.out.println("Дан массив, в котором все элементы различны. Заменить в нём нулём :");
        System.out.println("а) максимальный элемент;");
        System.out.println("б) минимальный элемент.");
        int n = 100;
        int[] array = new int[n];
        boolean flag = true;
        String str = "";
        int t = 0;

//наполнение массива неповторяющимися значениями
        for (int i = 0; i < array.length; i++) {
            flag = true;
            while (flag) {
                t = random.nextInt(10000) + 1;
                if (i == 0) {
                    array[i] = t;
                    flag = false;
                } else {
                    for (int j = 0; j < i; j++) {
                        if (array[j] == t) {
                            break;
                        }
                        if (j == i - 1) {
                            flag = false;
                            array[i] = t;
                        }
                    }
                }


            }
        }
//вывод массива на печать, строками по 10 элементов
        t = 0;
        for (int i = 0; i < array.length; i++) {
            str = str + " " + array[i];
            if (((i + 1) % 10 == 0 && i != 0)) {
                System.out.println(t + ":" + str);
                t = t + 10;
                str = "";
            }
        }

        int max = 0;
        int min = 0;
        int maxi = 0;
        int mini = n;
//находим макс и мин значения, порядковые номера

        int[] array1 = array.clone();

        Arrays.sort(array1);
        max = array1[n - 1];
        min = array1[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                array[i] = 0;
                maxi = i;
            } else if (array[i] == min) {
                array[i] = 0;
                mini = i;
            }
        }

//замена элементов
        array[maxi] = 0;
        array[mini] = 0;

//вывод результатов
        System.out.println("Максимальный элемент: " + max + " заменен на 0, пор.ном." + (maxi + 1));
        System.out.println("Минимальный элемент: " + min + " заменен на 0, пор.ном." + (mini + 1));


        t = 0;
        for (int i = 0; i < array.length; i++) {
            str = str + " " + array[i];
            if (((i + 1) % 10 == 0 && i != 0)) {
                System.out.println(t + ":" + str);
                t = t + 10;
                str = "";
            }
        }


    }


    private static void task07() {
        System.out.println("Заменить нулями все повторяющиеся элементы в массиве, оставив их первые вхождения, то есть");
        System.out.println("в массиве должны остаться только разные элементы.");
        int n = 100;
        int x = 10;
        int[] array = new int[n];
        String str = "";
        int t = 0;
//наполнение массива
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(x);

        }
//вывод массива на печать, строками по 10 элементов
        System.out.print(" ");
        for (int i = 0; i < array.length; i++) {
            str = str + " " + array[i];
            if (((i + 1) % 10 == 0 && i != 0)) {
                System.out.println(t + ":" + str);
                t = t + 10;
                str = "";
            }
        }

//поиск повторов, замена и подсчет их количества
        int counter = 0;

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    array[i] = 0;
                    counter++;
                    break;
                }

            }
        }

        System.out.println("Проверка завершена, " + counter + " повторов заменено на 0");

//вывод массива на печать, строками по 10 элементов
        t = 0;
        System.out.print(" ");
        for (int i = 0; i < array.length; i++) {
            str = str + " " + array[i];
            if (((i + 1) % 10 == 0 && i != 0)) {
                System.out.println(t + ":" + str);
                t = t + 10;
                str = "";
            }
        }


    }


    private static void task08() {

        int n = 100;
        int x = 10;
        int[] array = new int[n];
        String str = "";
        int t = 0;
        String option = "";

//наполнение массива
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(x) - x / 2;
        }
//вывод массива на печать, строками по 10 элементов
        t = 0;
        System.out.print(" ");
        for (int i = 0; i < array.length; i++) {
            str = str + " " + array[i];
            if (((i + 1) % 10 == 0 && i != 0)) {
                System.out.println(t + ":" + str);
                t = t + 10;
                str = "";
            }
        }

        System.out.println("Заменить нулями:\n" + "а) все отрицательные элементы;\n" +
                "б) все элементы, большие данного числа n;\n" +
                "в) все элементы, начиная с n1-го по n2-й (n1 ≤ n2)");

        System.out.println("Выберите вариант (а, б, в)");
        option = scanner.nextLine();
        switch (option) {
            case "а": {
                for (int i = 0; i < array.length; i++) {
                    if (array[i] < 0) {
                        array[i] = 0;
                    }
                }
                break;
            }
            case "б": {
                System.out.print("Укажите максимально допустимое значение ");
                int g = scanner.nextInt();
                for (int i = 0; i < array.length; i++) {
                    if (array[i] > g) {
                        array[i] = 0;
                    }
                }
                break;
            }
            case "в": {
                System.out.print("Укажите начало диапазона ");
                int g = scanner.nextInt();
                System.out.print("Укажите конец диапазона ");
                int h = scanner.nextInt();
                for (int i = g - 1; i < h; i++) {
                    array[i] = 0;
                }
                break;
            }
        }
//вывод массива на печать, строками по 10 элементов
        t = 0;
        System.out.println("Обработанный массив");
        System.out.print(" ");
        for (int i = 0; i < array.length; i++) {
            str = str + " " + array[i];
            if (((i + 1) % 10 == 0 && i != 0)) {
                System.out.println(t + ":" + str);
                t = t + 10;
                str = "";
            }
        }

    }


    private static void task09() {
        System.out.println("Дан массив целых чисел. Удалить из него:");
        System.out.println("а) все четные элементы, стоящие на нечетных местах");
        System.out.println("б) все элементы, кратные 3 или 5.");
        int n = 100;
        int[] array = new int[n];
        int t = 0;
        String str = "";
        int x = 10;

        //наполнение массива
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(x);
        }

        //вывод массива на печать, строками по 10 элементов
        t = 0;
        System.out.print(" ");
        for (int i = 0; i < array.length; i++) {

            str = str + " " + array[i];
            if (((i + 1) % 10 == 0 && i != 0)) {
                System.out.println(t + ":" + str);
                t = t + 10;
                str = "";
            }
        }

        System.out.println("Что удалить?\n" + "а) четные элементы на нечетных местах\n" + "б) элементы, кратные 3 и 5\n");
        String option = scanner.nextLine();
        if (option.equals("а")) {
            for (int i = 1; i <= array.length; i++) {
                if (array[i - 1] % 2 == 0 && (i) % 2 == 0) {
                    array[i - 1] = 0;
                }
            }
        } else if (option.equals("б")) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 3 == 0 || array[i] % 5 == 0) {
                    array[i] = 0;
                }
            }

        } else {
            System.out.println("Недопустимый выбор");
        }

        //вывод массива на печать, строками по 10 элементов
        t = 0;
        System.out.print(" ");
        for (int i = 0; i < array.length; i++) {
            str = str + " " + array[i];
            if (((i + 1) % 10 == 0 && i != 0)) {
                System.out.println(t + ":" + str);
                t = t + 10;
                str = "";
            }
        }
    }
}






