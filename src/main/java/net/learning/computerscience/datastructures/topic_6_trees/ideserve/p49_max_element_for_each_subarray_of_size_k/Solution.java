package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p49_max_element_for_each_subarray_of_size_k;

import java.util.ArrayList;

/**
 * https://www.ideserve.co.in/learn/maximum-element-from-each-subarray-of-size-k-set-1
 */
public class Solution {

    public static ArrayList<Integer> getMaxElements(int[] inputArray, int k) {
        ArrayList<Integer> elements = new ArrayList<>();
        TreeNode node;
        for (int i = 0; i < inputArray.length - (k - 1); i++) {
            node = insertNodes(getSubArray(inputArray, i, i + k));
            elements.add(getMaxElement(node));
        }
        return elements;
    }

    private static TreeNode insertNodes(int[] subArray) {
        TreeNode newTree = null;
        for (int element : subArray) {
            newTree = insertNode(newTree, element);
            newTree = balanceIfNeeded(newTree);
        }
        return newTree;
    }

    private static TreeNode insertNode(TreeNode node, int element) {
        if (node == null) return new TreeNode(element);
        if (element <= node.data) node.left = insertNode(node.left, element);
        else if (element > node.data) node.right = insertNode(node.right, element);
        return node;
    }

    private static TreeNode balanceIfNeeded(TreeNode current) {
        if (current == null) return null;
        current.left = balanceIfNeeded(current.left);
        current.right = balanceIfNeeded(current.right);
        int leftHeight = getHeight(current.left);
        int rightHeight = getHeight(current.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            // left
            if (leftHeight > rightHeight) {
                // left
                if (current.left.left != null) {
                    TreeNode temp = current.left;
                    temp.right = current;
                    current.left = null;
                    return temp;
                // right
                } else {
                    TreeNode temp = current.left;
                    TreeNode temp2 = temp.right;
                    temp2.right = current;
                    temp2.left = temp;
                    temp.right = null;
                    return temp2;
                }
            // right
            } else {
                // right
                if (current.right.right != null) {
                    TreeNode temp = current.right;
                    temp.left = current;
                    current.right = null;
                    return temp;
                // left
                } else {
                    TreeNode temp = current.right;
                    TreeNode temp2 = temp.left;
                    temp2.left = current;
                    temp2.right = temp;
                    temp.left = null;
                    return temp2;
                }
            }
        }
        return current;
    }

    private static int getHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private static int getMaxElement(TreeNode node) {
        return node.right == null ? node.data : getMaxElement(node.right);
    }

    private static int[] getSubArray(int[] inputArray, int from, int to) {
        int subArrayLength = to - from;
        int[] subArray = new int[subArrayLength];
        for (int i = 0; i < subArrayLength && to >= from; i++, from++) {
            subArray[i] = inputArray[from];
        }
        return subArray;
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "data=" + data +
                "}";
    }
}