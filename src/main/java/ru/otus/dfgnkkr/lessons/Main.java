package ru.otus.dfgnkkr.lessons;

import java.util.Scanner;

/**
 * (1) Реализуйте метод greetings(), который при вызове должен отпечатать в столбец 4 слова: Hello, World, from, Java;
 * (2) Реализуйте метод checkSign(..), принимающий в качестве аргументов 3 int переменные a, b и c. Метод должен посчитать их сумму, и если она больше или равна 0, то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
 * (3) Реализуйте метод selectColor() в теле которого задайте int переменную data с любым начальным значением. Если data меньше 10 включительно, то в консоль должно быть выведено сообщение “Красный”, если от 10 до 20 включительно, то “Желтый”, если больше 20 - “Зеленый”;
 * (4) Реализуйте метод compareNumbers(), в теле которого объявите две int переменные a и b с любыми начальными значениями. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
 * (5) Создайте метод addOrSubtractAndPrint(int initValue, int delta, boolean increment). Если increment = true, то метод должен к initValue прибавить delta и отпечатать в консоль результат, в противном случае - вычесть;
 * Каждый метод последовательно вызовите из метода main();
 * (*) При запуске приложения, запросите у пользователя число от 1 до 5, и после ввода выполнения метод, соответствующий указанному номеру со случайным значением аргументов;
 * Домашнее задание сдается через Pull Request!
 */
public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            int methodNum = userInputNumber();
            switch (methodNum) {
                case (1):
                    greetings();
                    break;
                case (2):
                    checkSign();
                    break;
                case (3):
                    selectColor();
                    break;
                case (4):
                    compareNumbers();
                    break;
                case (5):
                    addOrSubtractAndPrint(randomInt(), randomInt(), randomBool());
                    break;
                case (6):
                    exit = true;
                    break;
                default:
                    System.out.println("____________________________Что-то не так. Попробуем ещё разок.");
            }
        }
        System.out.println("__________Конец!______________");
    }

    /**
     * (*) При запуске приложения, запросите у пользователя число от 1 до 5, и после ввода выполнения метод, соответствующий указанному номеру со случайным значением аргументов;
     */
    public static int userInputNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====================================");
        System.out.println("Введите целое число от 1 до 6, где: ");
        System.out.println("====================================");
        System.out.println("1. метод greetings()");
        System.out.println("2. метод checkSign(..)");
        System.out.println("3. метод selectColor()");
        System.out.println("4. метод compareNumbers()");
        System.out.println("5. метод addOrSubtractAndPrint(int initValue, int delta, boolean increment)");
        System.out.println("6. завершение программы");
        System.out.println("___ Программа глупая: если ввести что-то кроме целого числа, то она сломаеца. Будь внимателен, дружок.");
        return scanner.nextInt();
    }

    /**
     * (5) Создайте метод addOrSubtractAndPrint(int initValue, int delta, boolean increment). Если increment = true,
     * то метод должен к initValue прибавить delta и отпечатать в консоль результат, в противном случае - вычесть;
     */
    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        System.out.println(increment ? initValue + delta : initValue - delta);
    }

    /**
     * (4) Реализуйте метод compareNumbers(), в теле которого объявите две int переменные a и b с любыми начальными значениями.
     * Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
     */
    public static void compareNumbers() {
        int a = randomInt();
        int b = randomInt();
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    /**
     * (3) Реализуйте метод selectColor() в теле которого задайте int переменную data с любым начальным значением.
     * Если data меньше 10 включительно, то в консоль должно быть выведено сообщение “Красный”, если от 10 до 20 включительно,
     * то “Желтый”, если больше 20 - “Зеленый”;
     */
    public static void selectColor() {
        int data = randomInt(3); // модификатор 3 позволяет получить результат от 0 до 27.
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    /**
     * (2) Реализуйте метод checkSign(..), принимающий в качестве аргументов 3 int переменные a, b и c.
     * Метод должен посчитать их сумму, и если она больше или равна 0,
     * то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
     */
    public static void checkSign() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сейчас будем суммировать 3 числа.");
        System.out.println("Введите число a:");
        int a = scanner.nextInt();
        System.out.println("Введите число b:");
        int b = scanner.nextInt();
        System.out.println("Введите число c:");
        int c = scanner.nextInt();
        checkSign(a, b, c);
    }

    public static void checkSign(int a, int b, int c) {
        if ((a + b + c) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }


    /**
     * (1) Реализуйте метод greetings(), который при вызове должен отпечатать в столбец 4 слова: Hello, World, from, Java;
     */
    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
        System.out.println("кароч");
    }

    public static int randomInt() {
        return randomInt(1);
    }

    public static int randomInt(int mod) {
        return (int) (Math.random() * 10 * mod);
    }

    public static boolean randomBool() {
        return randomInt() >= 4; // кек
    }


}