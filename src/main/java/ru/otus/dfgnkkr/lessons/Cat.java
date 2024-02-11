package ru.otus.dfgnkkr.lessons;

/**
 * Реализуйте классы Тарелка (максимальное количество еды, текущее количество еды) и Кот (имя, аппетит). Количество еды измеряем в условных единицах.
 *
 * Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
 * Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
 */

public class Cat {
    private boolean satiety = false;
    private String name;
    private int appetite;

    /**
     * Если коту удалось покушать (хватило еды), сытость = true.
     *
     * Осмысленный отход от поставленной задачи: не считаем, что если коту мало еды в тарелке, то он её просто не трогает.
     * Считаем, что не наестся. Но, для упрощения, аппетит не снижаем.
     */
    public void eat(Plate plate){
        satiety = plate.getSomeFood(appetite);
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public boolean isHungry() {
        return !satiety;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "satiety=" + satiety +
                ", name='" + name + '\'' +
                ", appetite=" + appetite +
                '}';
    }
}
