package ru.otus.dfgnkkr.lessons.transport;

import ru.otus.dfgnkkr.lessons.landscape.LandscapeEnum;

public abstract class AbstractAutoTransport implements Transport {

    protected int fuel;
    protected int fuelCost; // типо расход топлива на единицу расстояния

    // скорость, топливо, тип местности, расстояние
    @Override
    public boolean go(LandscapeEnum type, int distance) {
        System.out.println(this.getClass().getName() + " пытается переместиться на расстояние " + distance);
        System.out.println(this.getClass().getName() + " имеет топлива " + fuel + " и расход " + fuelCost);
        if (fuel < distance * fuelCost) {
            System.out.println("Перемещение отменяется: не хватает топлива");
            System.out.println("___________________________________________________________________");
            return false;
        }
        if (!availableTypes.contains(type)) {
            System.out.println("Перемещение отменяется: " + this.getClass().getName() + " не умеет в " + type.getTitle());
            System.out.println("___________________________________________________________________");
            return false;
        }
        fuel -= distance * fuelCost;
        System.out.println("Перемещение состоялось: " + this.getClass().getName() + " сохранил топливо в размере: " + fuel);
        System.out.println("___________________________________________________________________");
        return true;
    }
}
