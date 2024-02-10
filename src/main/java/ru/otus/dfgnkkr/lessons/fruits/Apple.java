package ru.otus.dfgnkkr.lessons.fruits;

public class Apple extends Fruit{
    public Apple() {
        weight = 2;
    }

    @Override
    public String whoAmI(){
        return "Apple";
    }
}
