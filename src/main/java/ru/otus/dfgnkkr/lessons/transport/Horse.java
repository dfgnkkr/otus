package ru.otus.dfgnkkr.lessons.transport;

import ru.otus.dfgnkkr.lessons.landscape.LandscapeEnum;

//да, лошадь это автотранспорт!
public class Horse extends AbstractAutoTransport implements Transport {
    public Horse(int fuel, int fuelCost) {
        this.fuel = fuel; //вот столько у нее сил, кароч
        this.fuelCost = fuelCost;
        this.availableTypes.add(LandscapeEnum.PLAIN);
        this.availableTypes.add(LandscapeEnum.FOREST);
    }
}
