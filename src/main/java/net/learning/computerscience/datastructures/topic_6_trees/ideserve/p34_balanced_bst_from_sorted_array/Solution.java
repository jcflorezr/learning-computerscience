package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p34_balanced_bst_from_sorted_array;

import java.util.Objects;

/**
 * https://www.ideserve.co.in/learn/create-a-balanced-bst-from-a-sorted-array
 */
public class Solution {

    public static TreeNode getBalancedBST(int[] sortedArray) {
        return createBST(sortedArray, 0, sortedArray.length - 1);
    }

    private static TreeNode createBST(int[] sortedArray, int from, int to) {
        if (from > to) return null;
        int mid = (from + to) / 2;
        TreeNode newNode = new TreeNode(sortedArray[mid]);
        newNode.left = createBST(sortedArray, from, mid - 1);
        newNode.right = createBST(sortedArray, mid + 1, to);
        return newNode;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return data == treeNode.data &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, left, right);
    }

    @Override
    public String toString() {
        return "{" +
                "data=" + data +
                "}";
    }
}