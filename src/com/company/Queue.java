package com.company;

public interface Queue {
    void addLast(Object o);

    Object removeFirst();

    Object get(int i);

    boolean empty();

    boolean full();

    int size();
}
