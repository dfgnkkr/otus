package ru.otus.dfgnkkr.lessons.animals;

/**
 * Создайте классы Cat, Dog и Horse с наследованием от класса Animal
 * У каждого животного есть имя, скорость бега и плавания (м/с), и выносливость (измеряется в условных единицах)
 *
 * Затраты выносливости:
 *  Все животные на 1 метр бега тратят 1 ед выносливости,
 *  Собаки на 1 метр плавания - 2 ед.
 *  Лошади на 1 метр плавания тратят 4 единицы
 *  Кот плавать не умеет.
 *
 * Реализуйте методы run(int distance) и swim(int distance), которые должны возвращать время, затраченное на указанное действие, и “понижать выносливость” животного.
 * Если выносливости не хватает, то возвращаем время -1 и указываем что у животного появилось состояние усталости.
 *
 * При выполнении действий пишем сообщения в консоль.
 * Добавьте метод info(), который выводит в консоль состояние животного.
 */
public abstract class Animal {
    protected String name;
    protected int runSpeed;
    protected int swimSpeed;
    protected int stamina; // выносливость
    protected boolean isTired;

    public Animal(String name, int runSpeed, int swimSpeed, int stamina) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.stamina = stamina;
        this.isTired = false; // первоначально животное отдохнувшее
    }

    public Animal(String name, int runSpeed, int stamina) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.stamina = stamina;
        this.swimSpeed = 0; // некоторые животные не плавают
        this.isTired = false; // первоначально животное отдохнувшее
    }

    public boolean canSwim(){
        return swimSpeed > 0;
    }

    public void printAnimalInfo(){
        System.out.println("Информация о зверушке: " + this);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", runSpeed=" + runSpeed +
                ", swimSpeed=" + swimSpeed +
                ", stamina=" + stamina +
                ", isTired=" + isTired +
                '}';
    }

    /**
     * Все животные на 1 метр бега тратят 1 ед выносливости,
     *
     * @return время, затраченное на указанное действие, при “понижении выносливости” животного.
     * Если выносливости не хватает, то возвращаем время -1 и указываем что у животного появилось состояние усталости.
     */
    public int run(int distance){
        if (stamina < distance) {
            System.out.println("Животное "+ name +" устало ;(");
            isTired = true;
            return -1;
        }
        System.out.println("Животное " + name + " бежит со скоростью " + runSpeed + "м/с, на дистанцию " + distance + "м.");
        stamina -= distance; // 1 к 1 для любых животных
        System.out.println("Значение выносливости " + name + " теперь составляет " + stamina + "уе.");
        return distance/runSpeed;
    }

    /**
     *  Плавание.
     *
     *  Собаки на 1 метр плавания тратят 2 ед выносливости.
     *  Лошади на 1 метр плавания тратят 4 единицы.
     *  Кот плавать не умеет.
     *
     * @return время, затраченное на указанное действие, и “понижать выносливость” животного.
     * Если выносливости не хватает, то возвращаем время -1 и указываем что у животного появилось состояние усталости.
     */
    public abstract int swim(int distance);

    public String getName() {
        return name;
    }

    public int getRunSpeed() {
        return runSpeed;
    }

    public int getSwimSpeed() {
        return swimSpeed;
    }

    public int getStamina() {
        return stamina;
    }

    public boolean isTired() {
        return isTired;
    }
}
