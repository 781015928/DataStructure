package com.czg.learn.tree;


public interface Tree<E> {

    boolean search(E e);

    boolean insert(E e);

    boolean delete(E e);

}
