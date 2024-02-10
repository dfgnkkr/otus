package ru.otus.dfgnkkr.lessons;

import ru.otus.dfgnkkr.lessons.boxes.AppleBox;
import ru.otus.dfgnkkr.lessons.boxes.FruitBox;
import ru.otus.dfgnkkr.lessons.boxes.OrangeBox;
import ru.otus.dfgnkkr.lessons.fruits.Apple;
import ru.otus.dfgnkkr.lessons.fruits.Fruit;
import ru.otus.dfgnkkr.lessons.fruits.Orange;

public class Main {
    public static void main(String[] args) {

        System.out.println("Создадим 10 яблок и сложим их в яблочную коробку");
        AppleBox<Apple> appleBox1 = new AppleBox<>();
        for (int i = 0; i < 10; i++) {
            appleBox1.putFruits(new Apple());
        }
        System.out.println("Вес получившейся яблочной коробки: " + appleBox1.getWeight());

        System.out.println("Создадим 10 апельсин и сложим их в апельсиновую коробку");
        OrangeBox<Orange> orangeBox1 = new OrangeBox<>();
        for (int i = 0; i < 10; i++) {
            orangeBox1.putFruits(new Orange());
        }
        System.out.println("Вес получившейся апельсиновой коробки: " + orangeBox1.getWeight());

        System.out.println("Создадим 3 яблок, 4 апельсин и сложим их во фруктовую коробку");
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        for (int i = 0; i < 4; i++) {
            fruitBox.putFruits(new Orange());
        }
        for (int i = 0; i < 3; i++) {
            fruitBox.putFruits(new Apple());
        }
        System.out.println("Вес получившейся апельсиновой коробки: " + fruitBox.getWeight());

        System.out.println("Пытаемся пересыпать яблоки из яблочной коробки во фруктовую коробку");
        appleBox1.putFruitsToAnotherBox(fruitBox);
        System.out.println("Вес получившейся фруктовой коробки: " + fruitBox.getWeight());
        System.out.println("Вес получившейся яблочной коробки (должна быть пустой): " + appleBox1.getWeight());

        System.out.println("Сравниваем вес апельсиновой коробки и фруктовой");
        if (orangeBox1.compare(fruitBox)) {
            System.out.println("Коробки имеют одинаковую массу: " + orangeBox1.getWeight());
        } else {
            System.out.println("Коробки имеют разную массу. Апельсиновая: " + orangeBox1.getWeight() + ". Фруктовая: " + fruitBox.getWeight());
        }
    }
}