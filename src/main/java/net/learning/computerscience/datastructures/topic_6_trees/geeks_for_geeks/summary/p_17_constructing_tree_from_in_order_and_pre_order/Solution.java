package net.learning.computerscience.datastructures.topic_6_trees.geeks_for_geeks.summary.p_17_constructing_tree_from_in_order_and_pre_order;

import java.util.ArrayDeque;

/**
 * https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 */
public class Solution {

    public static void main(String[] args) {

        int[] inOrderArray = {10,20,30,40,50,60,70,80,90};
        ArrayDeque<Integer> preOrderArray = new ArrayDeque<>();
        preOrderArray.push(50);
        preOrderArray.push(30);
        preOrderArray.push(10);
        preOrderArray.push(20);
        preOrderArray.push(40);
        preOrderArray.push(70);
        preOrderArray.push(60);
        preOrderArray.push(80);
        preOrderArray.push(90);

        Node rootNode = createTree(0, inOrderArray.length - 1, inOrderArray, preOrderArray);

        System.out.println();

    }

    private static Node createTree(int from, int to, int[] inOrderArray, ArrayDeque<Integer> preOrderArray) {
        if (to < from) return null;
        int rootElementIndex = getElementIndex(preOrderArray.pollLast(), inOrderArray);
        Node rootNode = new Node(inOrderArray[rootElementIndex]);

        if (to == from) return rootNode;

        rootNode.leftChild = createTree(from, rootElementIndex - 1, inOrderArray, preOrderArray);
        rootNode.rightChild = createTree(rootElementIndex + 1, to, inOrderArray, preOrderArray);

        return rootNode;
    }

    static private int getElementIndex(int element, int[] array) {
        return getElementIndex(element, 0, array.length - 1, array);
    }

    static private int getElementIndex(int element, int from, int to, int[] array) {
        if (from > to) return -1 - to;
        int middle = (from + to) / 2;
        if (element == array[middle]) return middle;
        if (element < array[middle]) return getElementIndex(element, from, middle - 1, array);
        else return getElementIndex(element, middle + 1, to, array);
    }

}

class Node {
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int data) {
        this.data = data;
    }
}
