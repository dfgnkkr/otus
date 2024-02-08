package ru.otus.dfgnkkr.lessons;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название файла (целиком, например \"1.txt \"): ");
        String filePath = scanner.nextLine();

        System.out.print("Введите строку для поиска (например \"tEst \"): ");
        String findStr = scanner.nextLine();

        try (BufferedReader in
                     = new BufferedReader(new FileReader(filePath))) {
            List<String> fileLines = in.lines().collect(Collectors.toList());
            StringBuilder builder = new StringBuilder();
            for (String str : fileLines) {
                builder.append(str);
            }
            String fullText = builder.toString();
            System.out.println("Найдено количество вхождений: " + StringUtils.countMatches(fullText, findStr));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}