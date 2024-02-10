package ru.otus.dfgnkkr.lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayList<Sotrudnyk> arrayList = new ArrayList<>();
        arrayList.add(new Sotrudnyk("name1", 20));
        arrayList.add(new Sotrudnyk("name2", 40));

        System.out.println("Моложе: " + getYoungestOne(arrayList).name);
        System.out.println("Средний возраст окей: " + (isAverageAgeOK(arrayList, 17) ? "yes" : "no"));
    }


    /**
     * Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList с набором
     * последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);
     */
    public static ArrayList<Integer> getSortedList(int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            result.add(i);
        }
        return result;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы,
     * значение которых больше 5, и возвращающий сумму;
     */
    public static Integer getSumByList(ArrayList<Integer> arrayList) {
        Integer result = 0;
        for (Integer element : arrayList) {
            if (element > 5) result += element;
        }
        return result;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, метод должен
     * переписать каждую заполненную ячейку списка указанным числом;
     */
    public static void rewriteElements(ArrayList<Integer> arrayList, int num) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != null) {
                arrayList.remove(i);
                arrayList.add(i, num);
            }
        }
    }


    /**
     * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, увеличивающий
     * каждый элемент списка на указанное число;
     */
    public static void addNumToElement(ArrayList<Integer> arrayList, int num) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != null) {
                int oldValue = arrayList.get(i);
                arrayList.remove(i);
                arrayList.add(i, oldValue + num);
            }
        }
    }


    /**
     * Создайте класс Сотрудник с полями: имя, возраст;
     */
    public static class Sotrudnyk {
        private String name;
        private Integer age;

        public Sotrudnyk(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }


    /**
     * Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
     */
    public static List<String> getNames(ArrayList<Sotrudnyk> sotrudnyks) {
        return sotrudnyks.stream().map(Sotrudnyk::getName).collect(Collectors.toList());
    }


    /**
     * Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст, и
     * возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу;
     */
    public static List<Sotrudnyk> getVeryOldSotrudniksList(ArrayList<Sotrudnyk> sotrudnyks, Integer minAge) {
        return sotrudnyks.stream().filter(s -> (s.getAge() >= minAge)).collect(Collectors.toList());
    }


    /**
     * Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст, и
     * проверяющий, что средний возраст сотрудников превышает указанный аргумент;
     */
    public static boolean isAverageAgeOK(ArrayList<Sotrudnyk> sotrudnyks, Integer minAverageAge) {
        return sotrudnyks.stream().map(Sotrudnyk::getAge).mapToInt(a -> a).average().getAsDouble() > Double.valueOf(String.valueOf(minAverageAge));
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого
     * молодого сотрудника.
     */
    public static Sotrudnyk getYoungestOne(ArrayList<Sotrudnyk> sotrudnyks) {
        return sotrudnyks.stream().filter(s -> s.getAge().equals(sotrudnyks.stream().map(Sotrudnyk::getAge).mapToInt(a -> a).min().getAsInt())).findAny().get();
    }


    public static int randomInt() {
        return randomInt(1);
    }

    public static int randomInt(int mod) {
        return (int) (Math.random() * 10 * mod);
    }

    public static boolean randomBool() {
        return randomInt() >= 4; // кек
    }
}