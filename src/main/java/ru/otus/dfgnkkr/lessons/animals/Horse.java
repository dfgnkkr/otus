package ru.otus.dfgnkkr.lessons.animals;

/**
 * Лошади на 1 метр плавания тратят 4 единицы выносливости
 */
public class Horse extends Animal{

    public Horse(String name, int runSpeed, int swimSpeed, int stamina) {
        super(name, runSpeed, swimSpeed, stamina);
    }

    @Override
    public int swim(int distance) {
        int strain = distance * 4;
        if (stamina < strain ) {
            System.out.println("Лошадь " + name +" устала ;(");
            isTired = true;
            return -1;
        }
        System.out.println("Лошадь " + name + " плывёт со скоростью " + swimSpeed + "м/с, на дистанцию " + distance + "м.");
        stamina -= strain; // 1 к 4 для любых лошадей
        System.out.println("Значение выносливости " + name + " теперь составляет " + stamina + "уе.");
        return distance/swimSpeed;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", runSpeed=" + runSpeed +
                ", swimSpeed=" + swimSpeed +
                ", stamina=" + stamina +
                ", isTired=" + isTired +
                '}';
    }
}
