package net.learning.computerscience.datastructures.binarysearchtree;

public interface Tree<T> {

    void traversal();

    void insert(T data);

    void delete(T data);

    T getMinValue();

    T getMaxValue();

}
