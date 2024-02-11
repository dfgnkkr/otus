package ru.otus.dfgnkkr.lessons;

import ru.otus.dfgnkkr.lessons.landscape.LandscapeEnum;
import ru.otus.dfgnkkr.lessons.transport.Car;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Human human = new Human("Mike");
        Car car = new Car(100, 8);

        human.setCurrentTransport(car);
        human.go(LandscapeEnum.SWAMP, 2);
        human.go(LandscapeEnum.PLAIN, 20);
        human.go(LandscapeEnum.PLAIN, 2);

        boolean isFuelEnough = true;
        while(isFuelEnough) {
            isFuelEnough = human.go(LandscapeEnum.PLAIN,randomInt());
        }
        System.out.println("___ доездились");

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