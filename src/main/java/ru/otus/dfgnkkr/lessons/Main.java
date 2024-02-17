package ru.otus.dfgnkkr.lessons;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");

        fillArrayInOneThread();
        fillArrayInManyThreads();
    }

    public static void fillArrayInOneThread(){
        System.out.println("1. Заполняем массив в 1 поток. Поехали.");
        double[] array = new double[100000000];
        long time = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = doMath(i);
        }

        System.out.println("На заполнение массива в 1 поток понадобилось: " + (System.currentTimeMillis() - time) + " мс.");
    }

    public static void fillArrayInManyThreads() throws InterruptedException {
        System.out.println("2. Заполняем массив в 4 потока. Поехали.");
        double[] array = new double[100000000];
        long time = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < array.length; i += 4) {
                array[i] = doMath(i);
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 1; i < array.length; i += 4) {
                array[i] = doMath(i);
            }
        });
        t2.start();
        Thread t3 = new Thread(() -> {
            for (int i = 2; i < array.length; i += 4) {
                array[i] = doMath(i);
            }
        });
        t3.start();
        Thread t4 = new Thread(() -> {
            for (int i = 3; i < array.length; i += 4) {
                array[i] = doMath(i);
            }
        });
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("На заполнение массива в 4 потока понадобилось: " + (System.currentTimeMillis() - time) + " мс.");
    }

    public static double doMath(int i){
        return 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
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