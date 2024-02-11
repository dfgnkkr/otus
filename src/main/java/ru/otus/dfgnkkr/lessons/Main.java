package ru.otus.dfgnkkr.lessons;

import java.util.Arrays;

public class Main {
    /**
     * Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
     */
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        for (int i = 0; i < 5; i++) {
            cats[i] = new Cat("Cat_" + i, randomInt());
        }

        Plate plate = new Plate(50);

        boolean isAllCatsSatiety = false;
        boolean isPlateEmpty = plate.isEmpty();
        while (!isAllCatsSatiety && !isPlateEmpty) { // пока не пуста миска или пока есть голодный кот
            for (Cat cat : cats) {

                if (cat.isHungry()) { // если кот голоден
                    if (!isPlateEmpty) { // не пуста ли миска
                        cat.eat(plate); // наконец едим
                        System.out.println("Ест кот '" + cat.getName() + "'.");
                    } else {
                        break; // если миска пуста, то выходим на условие while
                    }
                }
                isAllCatsSatiety = Arrays.stream(cats).noneMatch(Cat::isHungry);
                isPlateEmpty = plate.isEmpty();
            }
        }
        System.out.println("Вышли из цикла обжорства. ");
        System.out.println(isAllCatsSatiety ? "Все коты сыты" : "Часть котов осталась голодной ;(");

        for (Cat cat : cats) {
            System.out.println(cat.toString());
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