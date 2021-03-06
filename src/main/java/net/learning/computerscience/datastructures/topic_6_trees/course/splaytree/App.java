package net.learning.computerscience.datastructures.topic_6_trees.course.splaytree;

public class App {

    public static void main(String[] args) {
        Tree<Integer> splayTree = new SplayTree<>();

        splayTree.insert(10);
        splayTree.insert(-5);
        splayTree.insert(0);
        splayTree.insert(20);
        splayTree.insert(30);

        ((SplayTree) splayTree).printRoot();
        splayTree.inOrderTraversal();
    }

}
