package ru.otus.dfgnkkr.lessons.boxes;

import ru.otus.dfgnkkr.lessons.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FruitBox<T extends Fruit> implements Comparable<FruitBox<T>> {

    private final ArrayList<T> fruits = new ArrayList<>();

    public FruitBox() {
    }

    public FruitBox(ArrayList<T> fruits) {
        this.putFruits(fruits);
    }

    public void putFruits(ArrayList<T> fruits) {
        this.fruits.addAll(fruits);
    }

    public void putFruits(T fruit) {
        this.fruits.add(fruit);
    }

    /**
     * метод для "пересыпания" фруктов из данной коробки в другую
     * в результате текущая коробка должна остаться пустой
     */
    public void putFruitsToAnotherBox(FruitBox<? super T> anotherBox) {
        ((FruitBox<T>)anotherBox).putFruits(fruits);
        // "пересыпали" и коробка должна остаться пустой
        this.fruits.clear();
    }

    public List<T> getFruits() {
        return fruits;
    }

    public int getWeight() {
        int result = 0;
        if (!fruits.isEmpty()) {
            for (int w : fruits.stream().map(Fruit::getWeight).collect(Collectors.toList())) {
                result += w;
            }
        }
        return result;
    }

    /**
     * считаем коробку пустой, если ее масса равна нулю
     */
    public boolean isEmpty() {
        return getWeight() == 0;
    }

    public boolean compare(FruitBox<? super T> anotherBox) {
        return this.compareTo(anotherBox) == 0;
    }

    @Override
    public int compareTo(FruitBox anotherBox) {
        return this.getWeight() - anotherBox.getWeight();
    }
}