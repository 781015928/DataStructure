package com.czg.learn.stack;


interface Stack<E> {

    E push(E item);

    E pop();

    E peek();

    boolean empty();

    int size();
}
