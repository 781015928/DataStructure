package com.czg.learn.list;


public interface List<T> {

    T get(int index);

    T set(int index, T element);

    boolean add(T e);

    void add(int index, T element);

    T remove(int index);


    boolean remove(Object o);

    int indexOf(T o);

    int size();

    boolean isEmpty();


   // Iterator<T> iterator();

    void clear();

}
