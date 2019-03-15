package com.czg.learn.list;


public class LinkedList<T> implements List<T> {

    private Node<T> head;

    private Node<T> tail;

    private int size;

    public LinkedList() {

    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("index=" + index + " > List.size " + size);
        }
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        return null;
    }

    @Override
    public boolean add(T data) {
        if (head == null) {
            head = new Node<T>();
            head.data = data;
            head.next = head;
            head.last = head;
            size++;
            return true;
        }
        if (tail == null) {
            tail = new Node<T>();
            tail.data = data;
            tail.next = head;
            tail.last = head;
            head.last = tail;
            head.next = tail;
            size++;
            return true;
        }
        Node<T> node = new Node<>();
        node.data = data;
        node.next = head;
        node.last = tail;
        tail.next = node;
        tail = node;
        size++;
        return true;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        Node last = node.last;

        Node<T> newNode = new Node<>();
        newNode.data = element;
        newNode.next = node;
        newNode.last = last;
        last.next = newNode;
        node.last = newNode;

        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        Node<T> node = head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                remove(node);
                return node.data;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null || o == null) {
            return false;
        }

        Node<T> node = head;
        for (int i = 0; i <= size; i++) {
            if (node.data == o || node.data.equals(o)) {
                remove((Node<T>) node);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 移除当前节点
     *
     * @param node
     */
    private void remove(Node<T> node) {
        Node last = node.last;
        Node next = node.next;
        last.next = next;
        next.last = last;
        size--;
    }

    @Override
    public int indexOf(T o) {
        if (isEmpty() || o == null) {
            return -1;
        }
        int index = 0;
        Node<T> node = head;
        for (; node.next != null && node.next != tail.next; ) {
            if (o.equals(node.data)) {
                return index;
            }
            index++;
            node = node.next;
        }

        return index;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        if (head == null) {
            return;
        }
        Node<T> node = head;
        for (int i = 0; i <= size; i++) {
            node = node.next;
            node.last = null;
            node.data = null;
            node.next = null;
        }
        head = null;
        tail = null;
        size = 0;
    }

    private static class Node<T> {
        T data;

        Node next;

        Node last;

    }

}
