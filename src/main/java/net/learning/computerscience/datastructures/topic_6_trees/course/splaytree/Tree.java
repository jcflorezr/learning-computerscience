package net.learning.computerscience.datastructures.topic_6_trees.course.splaytree;

public interface Tree<T> {

    void insert(T data);
    Node<T> find(T data);
    T getMin();
    T getMax();
    void inOrderTraversal();

}
