package ru.otus.dfgnkkr.lessons;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    /**
     * В методе main() необходимо вызвать полученный метод,
     * обработать возможные исключения AppArraySizeException и AppArrayDataException
     * и вывести результат расчета (сумму элементов, при условии, что подали на вход корректный массив).
     *
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String[][] array1 = new String[4][4];
        String[][] array2 = new String[4][4];
        String[][] array3 = new String[4][6];

        fillArray(array1);
        fillArray(array2);
        fillArray(array3);

        // в ячейку второго массива сунем текст, вместо числа
        array2[2][2] = "asd";

        // третий массив больше, чем нужно
        array3[3][4] = "1";
        array3[3][5] = "2";

        try{
            System.out.println("По первому массиву метод должен успешно посчитать сумму: " + checkAndSumArray(array1));
        } catch(AppArraySizeException | AppArrayDataException e){
            System.out.println("____ERROR_____сюда попасть не должны");
            e.printStackTrace();
        }

        try{
            System.out.println(checkAndSumArray(array2));
        } catch(AppArraySizeException | AppArrayDataException e){
            System.out.println("По второму массиву метод должен упасть в AppArrayDataException");
            e.printStackTrace();
        }

        try{
            System.out.println(checkAndSumArray(array3));
        } catch(AppArraySizeException | AppArrayDataException e){
            System.out.println("По третьему массиву метод должен упасть в AppArraySizeException");
            e.printStackTrace();
        }
    }

    public static void fillArray(String[][] array) {
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                String str = String.valueOf(randomInt());
                array[j][i] = str;
            }
        }
    }

    /**
     * Бросим ошибку, если нам не понравится размер массива
     */
    public static class AppArraySizeException extends Exception{

    }

    /**
     * Бросим ошибку, если нам не понравится содержимое массива
     */
    public static class AppArrayDataException extends Exception{

    }

    /**
     * Целевой метод.
     *
     * Реализуйте метод, аргументом которого является двумерный строковый массив размером 4х4.
     * Если передан массив другого размера необходимо бросить исключение AppArraySizeException.
     * Метод должен обойти все элементы массива, преобразовать в int и просуммировать.
     * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит текст вместо числа),
     * должно быть брошено исключение AppArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
     *
     * @param array
     * @return
     */
    public static int checkAndSumArray(String[][] array) throws AppArraySizeException, AppArrayDataException {
        int result = 0;
        int length = 4;

        // проверяем длину "верхнего" массива
        if (array.length != length) {
            throw new AppArraySizeException();
        }
        // проверяем длину "вложенных" массивов
        for (int j = 0; j < 4; j++) {
            if (array[j].length != length) {
                throw new AppArraySizeException();
            }
        }


        // проходим по элементам массива, парсим в циферки, суммируем
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new AppArrayDataException();
                }
            }
        }

        return result;
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