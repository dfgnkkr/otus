package ru.otus.dfgnkkr.lessons;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        printString("спать", 4);

        sumArrayElements(convertIntArray(randomIntArray()));

        rewriteArray(convertIntArray(randomIntArray()), 5);

        addNumToArrayElements(convertIntArray(randomIntArray()), 6);

        sumHalfArrayElements(randomIntArray());

    }

    /**
     * Реализуйте метод, принимающий в качестве аргументов целое число и строку, и печатающий в
     * консоль строку указанное количество раз;
     */
    public static void printString(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(i+1 + ". " + str);
        }
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив, суммирующий все
     * элементы, значение которых больше 5, и печатающий полученную сумму в консоль;
     */
    public static void sumArrayElements(Integer[] array) {
        Integer result = 0;

        List<Integer> list =  Arrays.stream(array).filter(e -> e > 5).collect(Collectors.toList());

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
        for (int i = 0; i < array.length; i++){
            array[i] = num;
        }
    }

    /**
     * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный
     * массив, увеличивающий каждый элемент массива на указанное число;
     */
    public static void addNumToArrayElements(Integer[] array, int num) {
        for (int i = 0; i < array.length; i++){
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
        int halfLength = length/2; // грубо округляем
        System.out.println("___ длина массива: " + length + "___ половина длины массива: " + halfLength);

        int[] half1 = Arrays.copyOf(array, halfLength);
        int[] half2 = Arrays.copyOfRange(array,halfLength - 1,length - 1);
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
        return randomIntArray(11);
    }

    public static int[] randomIntArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomInt();
        }
        return result;
    }

    public static Integer[] convertIntArray(int[] data){
        return Arrays.stream(data).boxed().toArray(Integer[]::new);
    }

}