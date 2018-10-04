package net.learning.computerscience.datastructures.topic_6_trees.geeks_for_geeks.summary.p10_sorted_array_to_BST;

public class Solution {

    public static Node bstFromSortedArray(int[] elements) {
        int from = 0;
        int to = elements.length - 1;
        return getBST(elements, from, to);
    }

    private static Node getBST(int[] elements, int from, int to) {
        if (from > to) return null;
        int mid = (from + to) / 2;
        Node currentNode = new Node(elements[mid]);
        currentNode.left = getBST(elements, from, mid - 1);
        currentNode.right = getBST(elements, mid + 1, to);
        return currentNode;
    }

}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
