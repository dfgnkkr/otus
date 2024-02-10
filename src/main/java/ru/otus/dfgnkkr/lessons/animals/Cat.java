package ru.otus.dfgnkkr.lessons.animals;

/**
 * Коты.
 * Коты не умеют плавать.
 */
public class Cat extends Animal {
    public Cat(String name, int runSpeed, int stamina) {
        super(name, runSpeed, stamina);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", runSpeed=" + runSpeed +
                ", stamina=" + stamina +
                ", isTired=" + isTired +
                '}';
    }

    @Override
    public int swim(int distance) {
        throw new RuntimeException("Коты не умеют плавать и ваще не полезут в воду.");
    }
}
