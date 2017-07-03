import java.util.Random;
import java.util.Scanner;

public class Lecture07 {
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

        System.out.println("Лекция 7. Методология ООП. Часть 2. Домашнее задание.");
        while (repeat) {
            System.out.println("");
            System.out.println("Выберите задание 1-5");
            System.out.println(" 1. Обыкновенная дробь");
            System.out.println(" 2. Матрица");
            System.out.println(" 3. Point Figure");
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
        System.out.println("Создать классы Point и Figure. Класс Point должен содержать два\n" +
                "целочисленных поля и одно строковое поле (координаты x, y и название точки ).\n" +
                "Создать три свойства с одним методом доступа get. Создать пользовательский\n" +
                "конструктор, в теле которого проинициализируйте поля значениями аргументов.\n" +
                "Класс Figure должен содержать конструкторы, которые принимают от 3-х до 5-ти\n" +
                "аргументов типа Point. Создать два метода: double LengthSide(Point A, Point B),\n" +
                "который рассчитывает длину стороны многоугольника; void PerimeterCalculator(),\n" +
                "который рассчитывает периметр многоугольника. Написать программу, которая\n" +
                "выводит на экран название и периметр многоугольника. (длина стороны находится\n" +
                "следующим образом – от координат второй точки, отнимаются координаты первой\n" +
                "точки x = x2 – x1, y = y2 – y1, а потом возводят x и y в квадрат, суммируют, и\n" +
                "вычисляют корень суммы). Полная формула для нахождение длины стороны :");
        int q=myInput.getInt("Введите число ",scanner,0,0);

    }



}