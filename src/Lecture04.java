import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lecture04 {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        //task01();//шестизначное число
        //task02();//десятиборье
        //task03();//фигурное катание
        //task04();//наибольшая последовательность
        //task05();//простые числа
        //task06();//замена минимума и максимума
        task07();//оставить только первые вхождения
        //task02();//

    }

    //В массиве хранится информация о численности книг в каждом из 35 разделов библиотеки.
    // Выяснить, верно ли, что общее число книг в библиотеке есть шестизначное число

    private static void task01() {
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

    // В массиве хранится информация о баллах, полученных спортсменом-десятиборцем в каждом из десяти
    // видов спорта. Для выхода в следующий этап соревнований общая сумма баллов должна превысить некоторое
    // известное значение. Определить, вышел ли данный спортсмен в следующий этап соревнований.

    private static void task02() {
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

    // Оценки, полученные спортсменом в соревнованиях по фигурному катанию (в баллах), хранятся в
    // массиве из 18 элементов. В первых шести элементах записаны оценки по обязательной программе, с седьмого
    // по двенадцатый — по короткой программе, в остальных — по произвольной программе. Выяснить, по какому
    // виду программы спортсмен показал лучший результат.

    private static void task03() {
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

// Написать программу определения в одномерном массиве вещественных чисел наибольшего количества
// последовательно расположенных положительных чисел.

    private static void task04() {
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

// Задан целочисленный массив размерности N. Есть ли среди элементов массива простые числа? Если
// да, то вывести номера этих элементов.

    private static void task05() {
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

        boolean flag;

        for (int i = 0; i < array.length; i++) {
            flag = false;
            if (array[i] > 1) {
                for (int j = 2; j < array[i]; j++) {
                    if (array[i] % j == 0) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                System.out.println("Простое число: " + array[i] + ", порядковый номер в массиве: " + (i + 1));
            }
        }


    }

// Дан массив, в котором все элементы различны. Заменить в нём нулём :
//а) максимальный элемент;
//б) минимальный элемент.

    private static void task06() {
        int n = 100;
        int[] array = new int[n];
        boolean flag = true;
        String str = "";
        int t = 0;

//наполнение массива неповторяющимися значениями
        for (int i = 0; i < array.length; i++) {
            flag=true;
            while (flag) {
                t = random.nextInt(10000)+1;
                if (i==0){
                    array[i]=t;
                    flag=false;
                }
                else {
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
        t=0;
        for (int i = 0; i < array.length; i++) {
            str = str + " " + array[i];
            if (((i + 1) % 10 == 0 && i != 0)) {
                System.out.println(t + ":" + str);
                t = t + 10;
                str = "";
            }
        }

        int max=0;
        int min=0;
        int maxi=0;
        int mini=n;
//находим макс и мин значения, порядковые номера

        int[] array1=array.clone();

        Arrays.sort(array1);
        max=array1[n-1];
        min=array1[0];

        for (int i = 0; i <array.length ; i++) {
            if (array[i]==max){
                array[i]=0;
                maxi=i;
            }
            else if(array[i]==min){
                array[i]=0;
                mini=i;
            }
        }

//замена элементов
        array[maxi]=0;
        array[mini]=0;

//вывод результатов
        System.out.println("Максимальный элемент: "+max+" заменен на 0, пор.ном."+(maxi+1));
        System.out.println("Минимальный элемент: "+min+" заменен на 0, пор.ном."+(mini+1));



        t=0;
        for (int i = 0; i < array.length; i++) {
            str = str + " " + array[i];
            if (((i + 1) % 10 == 0 && i != 0)) {
                System.out.println(t + ":" + str);
                t = t + 10;
                str = "";
            }
        }


    }

// Заменить нулями все повторяющиеся элементы в массиве, оставив их первые вхождения, то есть
// в массиве должны остаться только разные элементы.

    private static void task07(){
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
    }



}


//        8. Заменить нулями :
//а) все отрицательные элементы;
//б) все элементы, большие данного числа n;
//в) все элементы, начиная с n1-го по n2-й (n1 ≤ n2).
//        9. Дан массив целых чисел. Удалить из него:
//а) все четные элементы, стоящие на нечетных местах;
//б) все элементы, кратные 3 или 5.



