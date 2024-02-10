package ru.otus.dfgnkkr.lessons;

import ru.otus.dfgnkkr.lessons.animals.Animal;
import ru.otus.dfgnkkr.lessons.animals.Cat;
import ru.otus.dfgnkkr.lessons.animals.Dog;
import ru.otus.dfgnkkr.lessons.animals.Horse;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat("Barsik", 5, 10));
        animals.add(new Horse("Konik", 10, 5, 30));
        animals.add(new Dog("Doggy", 8, 4, 15));

        boolean needRest = false;
        int time;
        while (!needRest){
            for (Animal animal : animals) {
                //  сначала бегаем
                animal.run(randomInt());

                // если можем - плаваем
                time = animal.canSwim() ? animal.swim(randomInt()) : animal.run(randomInt());

                // устали?
                if (animal.isTired() || time < 0){
                    needRest = true;
                    break;
                }
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