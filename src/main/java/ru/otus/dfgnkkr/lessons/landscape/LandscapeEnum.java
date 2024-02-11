package ru.otus.dfgnkkr.lessons.landscape;

public enum LandscapeEnum {

    SWAMP ("Болото"),
    PLAIN ("Рввнина"),
    FOREST ("Лес");

    private String title;

    LandscapeEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "LandscapeEnum{" +
                "title='" + title + '\'' +
                '}';
    }
}
