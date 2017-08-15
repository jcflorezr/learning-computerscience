package net.learning.computerscience.datastructures.tree.binarysearchtree;

public class App {

    public static void main(String[] args) {
        Tree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(10);
        binarySearchTree.insert(-1);
        binarySearchTree.insert(1);
        binarySearchTree.insert(0);
        binarySearchTree.insert(1000);
        binarySearchTree.insert(-22);

        System.out.println(binarySearchTree.getMaxValue());
        System.out.println(binarySearchTree.getMinValue());

        binarySearchTree.traversal();

        binarySearchTree.delete(10);
        binarySearchTree.traversal();

        System.out.println();

        Tree<Person> binarySearchTreeCustomObject = new BinarySearchTree<>();
        binarySearchTreeCustomObject.insert(new Person("Adam", 27));
        binarySearchTreeCustomObject.insert(new Person("Kevin", 13));
        binarySearchTreeCustomObject.insert(new Person("Joe", 67));
        binarySearchTreeCustomObject.insert(new Person("Michael", 2));
        binarySearchTreeCustomObject.insert(new Person("Smith", 11));

        binarySearchTreeCustomObject.traversal();
    }

}
