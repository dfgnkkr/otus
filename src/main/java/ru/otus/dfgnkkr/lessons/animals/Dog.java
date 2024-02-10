package ru.otus.dfgnkkr.lessons.animals;

/**
 * Собаки на 1 метр плавания тратят 2 единицы выносливости
 */
public class Dog extends Animal{
    public Dog(String name, int runSpeed, int swimSpeed, int stamina) {
        super(name, runSpeed, swimSpeed, stamina);
    }

    @Override
    public int swim(int distance) {
        int strain = distance * 2;
        if (stamina < strain ) {
            System.out.println("Собака " + name +" устала ;(");
            isTired = true;
            return -1;
        }
        System.out.println("Собака " + name + " плывёт со скоростью " + swimSpeed + "м/с, на дистанцию " + distance + "м.");
        stamina -= strain; // 1 к 2 для любых собак
        System.out.println("Значение выносливости " + name + " теперь составляет " + stamina + "уе.");
        return distance/swimSpeed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", runSpeed=" + runSpeed +
                ", swimSpeed=" + swimSpeed +
                ", stamina=" + stamina +
                ", isTired=" + isTired +
                '}';
    }
}
