package ru.otus.dfgnkkr.lessons;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        MyQueue<Integer> queue = new MyQueue<>();
        MyStack<Integer> stack = new MyStack<>();

        List<Integer> listForSorting = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            queue.offer(randomInt(10));
            stack.push(randomInt(15));
            listForSorting.add(randomInt(20));
        }

        System.out.println("Вынимаем событие (первое) из очереди: " + queue.poll());
        System.out.println("Выкидываем элемент (первый) из стека: " + stack.pop());

        BubbleSorter sorter = new BubbleSorter(listForSorting);
        System.out.println("Приготовили лист для сортировки. Сейчас он выглядит так: ");
        sorter.printer();
        System.out.println("Теперь выполним сортировку и посмотрим на результат: ");
        sorter.sort();
    }

    /**
     * класс-сортирователь пузырьковым методом
     */
    static class BubbleSorter{
        private List<Integer> list;
        private int listSize;

        public BubbleSorter(List<Integer> list){
            this.list = list;
            this.listSize = list.size();
        }

        /**
         * выполняем сортировку пузырьком
         * получившийся список возвращаем и печатаем в консоль
         */
        public List<Integer> sort(){
            for (int out = listSize - 1; out >= 1; out--){
                for (int in = 0; in < out; in++){
                    if(list.get(in) > list.get(in + 1)){
                        // если текущий элемент больше следующего - меняем их местами
                        Integer dummy = list.get(in);
                        list.set(in, list.get(in + 1));
                        list.set(in + 1, dummy);
                    }
                }
            }

            printer();
            return list;
        }


        /**
         * вывод в консоль
         */
        public void printer(){
            for (int i = 0; i < listSize; i++){
                System.out.print(list.get(i) + " ");
                System.out.println(" ");
            }
            System.out.println("----Окончание вывода массива----");
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