package net.learning.computerscience.datastructures.tree.splaytree;

public interface Tree<T> {

    void insert(T data);
    Node<T> find(T data);
    T getMin();
    T getMax();
    void inOrderTraversal();

}
