package ru.otus.dfgnkkr.lessons.transport;

import ru.otus.dfgnkkr.lessons.landscape.LandscapeEnum;

public class Bicycle implements Transport{
    public Bicycle() {
        this.availableTypes.add(LandscapeEnum.PLAIN);
        this.availableTypes.add(LandscapeEnum.FOREST);
    }

    @Override
    public boolean go(LandscapeEnum type, int distance) {
        // тут бы условие на существование человека с ногами
        return availableTypes.contains(type);
    }
}
