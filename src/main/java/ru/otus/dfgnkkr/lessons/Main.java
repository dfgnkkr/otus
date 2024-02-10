package ru.otus.dfgnkkr.lessons;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        PhoneBook phoneBook = new PhoneBook();
        for (int i = 0; i < 10; i++){
            Set<String> numbers = new HashSet<>();
            numbers.add("number_" + i);
            numbers.add("number_" + i + "_" + randomInt());
            phoneBook.addAll("name_" + i, numbers);
        }

        phoneBook.add("name_test", "number_test");

        System.out.println("Проверяем метод find() и выполненный выше add(): " + (phoneBook.find("name_test").contains("number_test") ? "РАБОТАЕТ" : "___ПРОБЛЕМКИ___"));

        System.out.println("Проверяем метод containsPhoneNumber(): " + (phoneBook.containsPhoneNumber("number_4") ? "РАБОТАЕТ" : "___ПРОБЛЕМКИ___"));

    }

    /**
     * Реализуйте класс PhoneBook, который хранит в себе список имен (фио) и телефонных номеров;
     * Под одним именем может быть несколько телефонов (в случае однофамильцев,
     * или наличии у одного человека нескольких номеров), тогда при запросе такой фамилии должны выводиться все телефоны;
     */
    public static class PhoneBook{
        /**
         * Собственно справочник. Реализуем мапой, где key = name, а value = перечень номеров.
         */
        private final Map<String, Set<String>> phoneBook = new HashMap<>();

        /**
         * Метод add() должен позволять добавлять запись имя-телефон;
         */
        public void add(String name, String number){
            if (phoneBook.containsKey(name)) {
                phoneBook.get(name).add(number);
            } else {
                phoneBook.put(name, new HashSet<>(Collections.singletonList(number)));
            }
        }

        /**
         * Метод add() должен позволять добавлять запись имя-телефон;
         */
        public void addAll(String name, Set<String> numbers){
            if (phoneBook.containsKey(name)) {
                phoneBook.get(name).addAll(numbers);
            } else {
                phoneBook.put(name, numbers);
            }
        }

        /**
         * Метод find() выполнять поиск номер(-а, -ов) телефона по имени;
         */
        public Set<String> find(String name){
            if (phoneBook.containsKey(name)) {
                return phoneBook.get(name);
            }
            return new HashSet<>();
        }

        /**
         * Метод containsPhoneNumber должен проверять наличие телефона в справочнике.
         */
        public boolean containsPhoneNumber(String number){
            return phoneBook.values().stream().flatMap(Set::stream).anyMatch(v -> v.equals(number));
        }
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