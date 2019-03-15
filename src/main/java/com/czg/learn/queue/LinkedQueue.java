package com.czg.learn.queue;


public class LinkedQueue<E> implements Queue<E> {
    private Node<E> tail;

    @Override
    public void enqueue(E o) {
        if (tail == null) {
            tail = new Node<>();
            tail.data = o;
        } else {
            tail.last = new Node<>();
            tail.last.data = o;
        }
    }

    @Override
    public E dequeue() {
        if (tail == null) {
            return null;
        } else {
            return tail.data;
        }
    }

    private class Node<T> {
        T data;
        Node<T> last;

    }
}
