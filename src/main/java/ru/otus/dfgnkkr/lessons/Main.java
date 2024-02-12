package ru.otus.dfgnkkr.lessons;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    final Object monitor = new Object();
    String currentChar = "C";

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 5; i++) {
            executorService.execute(main::printA);
            executorService.execute(main::printB);
            executorService.execute(main::printC);
        }
        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println(".");
        System.out.println("THE END.");
    }

    public void printA() {
        synchronized (monitor) {
            try {
                while (!(currentChar.equals("C"))) {
                    monitor.wait();
                }
                currentChar = "A";
                System.out.print(currentChar);
                monitor.notifyAll();
                Thread.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void printB() {
        synchronized (monitor) {
            try {
                while (!(currentChar.equals("A"))) {
                    monitor.wait();
                }
                currentChar = "B";
                System.out.print(currentChar);
                monitor.notifyAll();
                Thread.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            try {
                while (!(currentChar.equals("B"))) {
                    monitor.wait();
                }
                currentChar = "C";
                System.out.print(currentChar);
//                System.out.println("."); // так красивее
                monitor.notifyAll();
                Thread.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
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