package net.learning.computerscience.datastructures.trees.avltree;

public class App {

    public static void main(String[] args) {
        Tree<String> avlTree = new AvlTree<>();

        avlTree.insert("a");
        avlTree.insert("c");
        avlTree.insert("b");
//        avlTree.insert(6);

//        avlTree.delete(15);

        avlTree.traverse();
    }

}
