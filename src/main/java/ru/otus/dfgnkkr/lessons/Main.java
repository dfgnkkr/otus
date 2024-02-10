package ru.otus.dfgnkkr.lessons;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
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