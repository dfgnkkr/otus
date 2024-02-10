package ru.otus.dfgnkkr.lessons;

import java.util.LinkedList;

/**
 * очередь.
 * представитель двунаправленного списка.
 */
public class MyQueue<E> extends MyLinkedList<E> {

    /**
     * кладём элемент в очередь, в конец
     */
    public void offer(E e){
        add(e);
    }

    /**
     * вынимаем (удаляем) из очереди первый элемент
     *
     * снова понадобился unlinkFirst - кладу рядом
     */
    public E poll(){
        final Node<E> f = first;
        return (f == null) ? null : unlinkFirst(f);
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
