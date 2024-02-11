package ru.otus.dfgnkkr.lessons.transport;

import ru.otus.dfgnkkr.lessons.landscape.LandscapeEnum;

// как бы вездеход
public class Jeep extends AbstractAutoTransport implements Transport {
    public Jeep(int fuel, int fuelCost) {
        this.fuel = fuel;
        this.fuelCost = fuelCost;
        this.availableTypes.add(LandscapeEnum.PLAIN);
        this.availableTypes.add(LandscapeEnum.FOREST);
        this.availableTypes.add(LandscapeEnum.SWAMP);
    }
}
