package ru.otus.dfgnkkr.lessons;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        sumArrayElements(randomIntegerArrayArrays());

        printSquad(5);

        printArray(randomIntArrayArrays());

        findMax(randomIntArrayArrays());

        sumArrayLineElements(randomIntegerArrayArrays());

    }

    /**
     * Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив,
     * метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
     */
    public static void sumArrayElements(Integer[][] array) {
        int result = 0;

        for (Integer[] line : array)
            for (Integer element : line)
                if (element > 0) result += element;

        System.out.println("_________ Сумма: " + result);
    }

    /**
     * Реализовать метод, который принимает в качестве аргумента int size и печатает в консоль квадрат из символов * со сторонами соответствующей длины;
     */
    public static void printSquad(int size) {
        // строки
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // столбцы
                System.out.print("* ");
            }
            // перевод строки
            System.out.print("\n");
        }
        System.out.println("_________ конец ___________");
    }

    /**
     * Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив,
     * и зануляющий его диагональные элементы (можете выбрать любую из диагоналей, или занулить обе);
     */
    public static void printArray(int[][] array) {
        // строки
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                // столбцы
                if (i == j) array[i][j] = 0; // зануляем диагональ
                System.out.print(array[i][j] + " ");
            }
            // перевод строки
            System.out.print("\n");
        }
        System.out.println("_________ конец ___________");
    }

    /**
     * Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
     */
    public static int findMax(int[][] array) {
        int max = 0;

        // строки
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                // столбцы
                if (array[i][j] > max) max = array[i][j];
                System.out.print(array[i][j] + " ");

            }
            // перевод строки
            System.out.print("\n");
        }

        System.out.println("_________ конец ___________");
        return max;
    }


    /**
     * Реализуйте метод, который считает сумму элементов второй строки двумерного массива,
     * если второй строки не существует, то в качестве результата необходимо вернуть -1
     */
    public static Integer sumArrayLineElements(Integer[][] array) {
        Integer result = 0;

        if (array.length < 2) { // если второй "строки" нет, то вернем -1
            return -1;
        }

        List<Integer> line2 = Arrays.stream(array[1]).collect(Collectors.toList());

        for (Integer num : line2) {
            result += num;
        }

        System.out.println("Полученный массив (список): " + line2);
        System.out.println("_________ Сумма: " + result);


        System.out.println("_________ конец ___________");
        return result;
    }


    /**
     * Реализуйте метод, принимающий в качестве аргументов целое число и строку, и печатающий в
     * консоль строку указанное количество раз;
     */
    public static void printString(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(i + 1 + ". " + str);
        }
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив, суммирующий все
     * элементы, значение которых больше 5, и печатающий полученную сумму в консоль;
     */
    public static void sumArrayElements(Integer[] array) {
        Integer result = 0;

        List<Integer> list = Arrays.stream(array).filter(e -> e > 5).collect(Collectors.toList());

        for (Integer num : list) {
            result += num;
        }

        System.out.println("Первоначальный массив: " + Arrays.toString(array));
        System.out.println("Отбросили значения меньше 5. Полученный массив (список): " + list);
        System.out.println("_________ Сумма: " + result);
    }

    /**
     * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный
     * массив, метод должен заполнить каждую ячейку массива указанным числом;
     */
    public static void rewriteArray(Integer[] array, int num) {
//        Arrays.fill(array, num); // или так
        for (int i = 0; i < array.length; i++) {
            array[i] = num;
        }
    }

    /**
     * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный
     * массив, увеличивающий каждый элемент массива на указанное число;
     */
    public static void addNumToArrayElements(Integer[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            array[i] += num;
        }
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив, и печатающий в
     * консоль информацию о том, сумма элементов какой из половин массива больше;
     */
    public static void sumHalfArrayElements(int[] array) {
        int result1 = 0;
        int result2 = 0;

        int length = array.length;
        int halfLength = length / 2; // грубо округляем
        System.out.println("___ длина массива: " + length + "___ половина длины массива: " + halfLength);

        int[] half1 = Arrays.copyOf(array, halfLength);
        int[] half2 = Arrays.copyOfRange(array, halfLength - 1, length - 1);
        System.out.println("_________ первая половина массива: " + Arrays.toString(half1));
        System.out.println("_________ вторая половина массива: " + Arrays.toString(half2));

        result1 = IntStream.of(half1).sum();
        result2 = IntStream.of(half2).sum();

        String msg = result1 > result2 ? "_первой_" : "_второй_";
        System.out.println("__________ Сумма элементов " + msg + " половины массива больше");
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

    public static int[] randomIntArray() {
        return randomIntArray(10);
    }

    public static int[] randomIntArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomInt();
        }
        return result;
    }

    public static Integer[] convertIntArray(int[] data) {
        return Arrays.stream(data).boxed().toArray(Integer[]::new);
    }

    public static Integer[][] randomIntegerArrayArrays() {
        Integer[][] array = new Integer[10][10];
        for (int i = 0; i < 10; i++) {
            array[i] = convertIntArray(randomIntArray());
        }
        return array;
    }

    public static int[][] randomIntArrayArrays() {
        int[][] array = new int[10][10];
        for (int i = 0; i < 10; i++) {
            array[i] = randomIntArray();
        }
        return array;
    }

}