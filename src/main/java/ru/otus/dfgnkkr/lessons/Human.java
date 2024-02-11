package ru.otus.dfgnkkr.lessons;

import ru.otus.dfgnkkr.lessons.landscape.LandscapeEnum;
import ru.otus.dfgnkkr.lessons.transport.Transport;

public class Human implements Transport {

    private Transport currentTransport;
    private String name;

    public Human(String name) {
        this.name = name;
        this.availableTypes.add(LandscapeEnum.PLAIN);
    }

    /**
     * При попытке выполнить перемещение у человека, не использующего транспорт,
     * считаем что он просто идет указанное расстояние пешком
     */
    @Override
    public boolean go(LandscapeEnum type, int distance) {
        if (currentTransport != null)
            return currentTransport.go(type,distance);
        return availableTypes.contains(type);
    }

    public Transport getCurrentTransport() {
        return currentTransport;
    }

    public void setCurrentTransport(Transport currentTransport) {
        this.currentTransport = currentTransport;
    }

    public String getName() {
        return name;
    }
}
