package net.learning.computerscience.datastructures.topic_6_trees.course.ternarysearchtree;

public class App {

    public static void main(String[] args) {
        TernarySearchTree ternarySearchTree = new TernarySearchTree();

        ternarySearchTree.put("apple", 1);
        ternarySearchTree.put("orange", 2);

        System.out.println(ternarySearchTree.get("banana"));
    }

}
