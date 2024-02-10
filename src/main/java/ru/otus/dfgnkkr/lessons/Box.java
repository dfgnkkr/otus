package ru.otus.dfgnkkr.lessons;

/**
 * Попробуйте реализовать класс по его описания: объекты класса Коробка должны иметь размеры и цвет.
 * Коробку можно открывать и закрывать. Коробку можно перекрашивать.
 * Изменить размер коробки после создания нельзя.
 * У коробки должен быть метод, печатающий информацию о ней в консоль.
 * В коробку можно складывать предмет (если в ней нет предмета), или выкидывать его оттуда (только если предмет в ней есть),
 * только при условии, что коробка открыта (предметом читаем просто строку).
 *
 * Выполнение методов должно сопровождаться выводом сообщений в консоль.
 */
public class Box {
    private final int size;
    private String color;
    private String item = null; // изначально - коробка пустая
    private boolean isOpen = false;

    /**
     * Объекты класса Коробка должны иметь размеры и цвет.
     */
    public Box(int size, String color) {
        // int не может быть null, но может быть 0; считаем 0 неподходящим значением для размера коробки
        if (color == null || size == 0)  {
            throw new RuntimeException("Коробка должна иметь цвет и размер");
        }
        this.size = size;
        this.color = color;
        System.out.println("Успешно создали коробку: ");
        printBoxInfo();
    }

    @Override
    public String toString() {
        return "Box{" +
                "size=" + size +
                ", color='" + color + '\'' +
                ", item='" + item + '\'' +
                ", isOpen=" + isOpen +
                '}';
    }

    /**
     * У коробки должен быть метод, печатающий информацию о ней в консоль.
     */
    public void printBoxInfo(){
        System.out.println(this);
    }

    /**
     * Изменить размер коробки после создания нельзя. Поэтому сеттера для size нет.
     */
    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    /**
     * Коробку можно перекрасить
     */
    public void setColor(String color) {
        System.out.println("Перекрашиваем коробку. Было: " + this.color + ". Стало: " + color);
        this.color = color;
    }

    public boolean isEmpty(){
        return item == null;
    }

    /**
     * Из коробки можно выкидывать предмет (только если предмет в ней есть),
     * только при условии, что коробка открыта (предметом читаем просто строку).
     */
    public void throwItem() {
        if (!isEmpty() && isOpen()){
            item = null;
        } else {
            throw new RuntimeException("Невозможно опустошить коробку: " + this);
        }
        System.out.println("Опустошили коробку.");
    }

    /**
     * В коробку можно складывать предмет (если в ней нет предмета), только при условии, что коробка открыта.
     */
    public void putItem(String item) {
        if (isEmpty() && isOpen()){
            this.item = item;
        } else {
            throw new RuntimeException("Невозможно положить предмет в коробку: " + this);
        }
        System.out.println("Сложили в коробку предмет: " + item);
    }

    public boolean isOpen() {
        return isOpen;
    }

    /**
     * Коробку можно открывать и закрывать.
     */
    public void setOpen(boolean open) {
        isOpen = open;
        System.out.println(open ? "Открыли коробку" : "Закрыли коробку");
    }
}
