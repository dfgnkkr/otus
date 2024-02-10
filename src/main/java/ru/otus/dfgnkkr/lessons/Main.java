package ru.otus.dfgnkkr.lessons;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var file = new File("./");
        System.out.println("Список файлов txt в корневой папке проекта:");
        System.out.println("_____" + Arrays.stream(file.listFiles()).map(f -> f.getName()).filter(s -> s.contains(".txt")).collect(Collectors.toSet()) + "_____");
        System.out.println("Введите название файла (целиком, например \"1.txt \"): ");
        String filePath = scanner.nextLine();

        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            List<String> fileLines = in.lines().collect(Collectors.toList());
            System.out.println("Выбран файл '" + filePath + "'. Далее отобразим содержимое: ");
            System.out.println("___ начало ___");
            for (String str : fileLines) {
                System.out.println(str);
            }
            System.out.println("___ конец ___");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Введите строку для добавления в файл: ");
        String strForFile = scanner.nextLine();

        try (BufferedWriter out = new BufferedWriter(new FileWriter(filePath, true))) {
            out.newLine();
            out.write(strForFile);
            System.out.println("___ введенная строка добавлена в файл ___");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            List<String> fileLines = in.lines().collect(Collectors.toList());
            System.out.println("Итого, содержимое файла: ");
            System.out.println("___ начало ___");
            for (String str : fileLines) {
                System.out.println(str);
            }
            System.out.println("___ конец ___");
        } catch (Exception e) {
            e.printStackTrace();
        }
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