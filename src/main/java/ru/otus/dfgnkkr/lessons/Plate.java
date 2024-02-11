package ru.otus.dfgnkkr.lessons;

/**
 * Реализуйте классы Тарелка (максимальное количество еды, текущее количество еды) и Кот (имя, аппетит).
 *
 * Количество еды измеряем в условных единицах.
 * При создании тарелки указывается ее объем и она полностью заполняется едой
 * В тарелке должен быть метод, позволяющий добавить еду в тарелку. После добавления в тарелке не может оказаться еды больше максимума
 * В тарелке должен быть boolean метод уменьшения количества еды, при этом после такого уменьшения,
 * в тарелке не может оказаться отрицательное количество еды (если удалось уменьшить еду так, чтобы в тарелке осталось >= 0 кусков еды, то возвращаем true, в противном случае - false).
 */
public class Plate {

    private final int maxFoodWeight; // объём тарелки, верхняя граница количества корма
    private int currentFoodWeight;

    /**
     * При создании тарелки указывается ее объем и она полностью заполняется едой
     */
    public Plate(int maxFoodWeight){
        this.maxFoodWeight = maxFoodWeight;
        this.currentFoodWeight = maxFoodWeight;
    }

    /**
     * В тарелке должен быть метод, позволяющий добавить еду в тарелку. После добавления в тарелке не может оказаться еды больше максимума
     */
    public void putSomeFood(int foodWeight){
        System.out.println("Сейчас в тарелке: " + this.currentFoodWeight);
        System.out.println("Добавляем: " + foodWeight);
        this.currentFoodWeight += foodWeight;
        if (this.currentFoodWeight > this.maxFoodWeight) this.currentFoodWeight = this.maxFoodWeight;
        System.out.println("Сейчас в тарелке: " + this.currentFoodWeight + ". Максимально возможная загрузка: " + this.maxFoodWeight);
    }

    /**
     * В тарелке должен быть boolean метод уменьшения количества еды, при этом после такого уменьшения,
     *  в тарелке не может оказаться отрицательное количество еды (если удалось уменьшить еду так, чтобы в тарелке осталось >= 0 кусков еды, то возвращаем true, в противном случае - false).
     */
    public boolean getSomeFood(int foodWeight){
        boolean result;
        System.out.println("Сейчас в тарелке: " + this.currentFoodWeight);
        System.out.println("Съедаем: " + foodWeight);
        this.currentFoodWeight -= foodWeight;
        if (this.currentFoodWeight >= 0) {
            result = true;
        } else {
            result = false;
            this.currentFoodWeight = 0; // не может быть меньше
        }

        System.out.println("Сейчас в тарелке: " + this.currentFoodWeight + ". Максимально возможная загрузка: " + this.maxFoodWeight);

        return result;
    }

    public boolean isEmpty(){
        return this.currentFoodWeight == 0;
    }


}
