package com.czg.learn.stack;


public class LinkedStack<E> implements Stack<E> {

    private Node<E> head;

    private int size;

    @Override
    public E push(E item) {
        if (head == null) {
            head = new Node();
            head.data = item;
            return item;
        } else {
            head.next = new Node();
            head.next.data = item;
        }
        size++;
        return item;
    }

    @Override
    public E pop() {
        if (head == null) {
            return null;
        }
        E data = head.data;
        head = head.next;
        return data;
    }

    @Override
    public E peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node<T> {

        T data;

        Node<T> next;


    }
}
