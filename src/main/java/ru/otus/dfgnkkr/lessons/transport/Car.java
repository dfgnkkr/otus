package ru.otus.dfgnkkr.lessons.transport;

import ru.otus.dfgnkkr.lessons.landscape.LandscapeEnum;

public class Car extends AbstractAutoTransport implements Transport{
    public Car(int fuel, int fuelCost) {
        this.fuel = fuel;
        this.fuelCost = fuelCost;
        this.availableTypes.add(LandscapeEnum.PLAIN);
    }
}
