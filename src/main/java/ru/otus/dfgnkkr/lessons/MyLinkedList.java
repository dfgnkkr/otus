package ru.otus.dfgnkkr.lessons;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {

    /**
     * размер списка.
     * повышается при добавлении элементов (важно, что бы все элементы добавлялись либо через linkLast, либо linkFirst)
     */
    transient int size = 0;

    /**
     * Ссылка на первый элемент
     */
    transient Node<E> first;

    /**
     * Ссылка на последний элемент
     */
    transient Node<E> last;

    /**
     * нода.
     * по сути - элемент списка, имеющий ссылки на предыдущий и следующий элементы.
     * @param <E>
     */
    protected static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    protected void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void add(E data) {
        linkLast(data);
    }


    /**
     * Этот метод, насколько понимаю, не создает нового элемента списка, а заменяет существующий
     *
     * В домашке значится так: "add(int position, T data)" - типо void, типо добавление и типо с указанием позиции
     * Я такого метода не вижу в оригинальном LinkedList.
     * Так что будем думать, что имелся ввиду LinkedList#set(int index, E element).
     */
    public E set(int position, E data) {
        checkElementIndex(position);
        Node<E> x = node(position);
        E oldVal = x.item;
        x.item = data;
        return oldVal;
    }

    /**
     * добавить элемент в начало списка
     * @param data
     */
    public void addFirst(E data) {
        linkFirst(data);
    }

    /**
     * добавить элемент в конец списка
     * @param data
     */
    public void addLast(E data) {
        linkLast(data);
    }

    /**
     * получить первый элемент списка
     *
     */
    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    /**
     * получить последний элемент списка
     *
     */
    public E getLast(){
        final Node<E> f = last;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }


    /**
     * проверить, существует ли в списке такой индекс
     *
     */
    protected void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Переданный индекс (" + index + ") выходит за пределы размерности списка");
    }

    protected boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * удаляем конкретный элемент списка
     */
    public  E remove(int position) {
        checkElementIndex(position);
        return unlink(node(position));
    }

    /**
     * отлинковываем удаляемый элемент и правим ссылки его соседей
     */
    E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }


    /**
     * возвращаем элемент по индексу (если индекс существующий)
     */
    public E get(int position){
        checkElementIndex(position);
        return node(position).item;
    }

    /**
     * возвращаем Ноду по индексу
     */
    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
}
