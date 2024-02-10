package ru.otus.dfgnkkr.lessons;

import java.util.NoSuchElementException;

/**
 * стек.
 * представитель двунаправленного списка.
 */
public class MyStack<E> extends MyLinkedList<E> {

    /**
     * пихаем новый элемент в начало стека
     */
    public void push(E data){
        addFirst(data);
    }

    /**
     * выкидываем элемент из начала стека
     *
     * для этого приходится реализовывать методы removeFirst и unlinkFirst (кладу рядом)
     */
    public E pop(){
        return removeFirst();
    }

    public E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    private E unlinkFirst(Node<E> f) {
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }

}
