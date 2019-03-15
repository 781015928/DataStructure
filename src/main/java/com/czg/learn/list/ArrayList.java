package com.czg.learn.list;


import java.util.Arrays;

public class ArrayList<T> implements List<T> {

    public ArrayList() {
        this(32);
    }

    private Object[] elements;
    private static final Object[] EMPTY_ELEMENTS = new Object[0];

    private int size;


    public ArrayList(int size) {
        elements = new Object[size];
    }


    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        Object oldElement = elements[index];
        elements[index] = element;

        return (T) oldElement;
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("index=" + index + " > List.size " + size);
        }
    }

    @Override
    public boolean add(T element) {
        dilatation();
        elements[size] = element;
        size++;
        return true;
    }

    int count = 1;

    private void dilatation() {
        if (size + 1 > elements.length) {
            int newSize = elements.length << 1 + elements.length;
            System.out.println("拷贝" + count++);
            elements = Arrays.copyOf(elements, newSize);
        }
    }


    @Override
    public void add(int index, T element) {
        checkIndex(index);
        dilatation();
        size++;
        for (int i = size; i > index; i--) {

            elements[i] = elements[i - 1];

        }

        elements[index] = element;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        Object element = elements[index];
        assert (index == 0);
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return (T) element;
    }

    @Override
    public boolean remove(Object o) {
        if (o != null) {
            for (int index = 0; index < size; index++) {
                if (o.equals(get(index))) {
                    remove(index);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public int indexOf(T o) {
        if (o != null) {
            for (int index = 0; index < size; index++) {
                if (o.equals(get(index))) {
                    return index;
                }
            }
        }
        return -1;
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
        for (int index = 0; index < size; index++) {
            elements[index] = null;
        }
        elements = EMPTY_ELEMENTS;
        size = 0;
    }
}
