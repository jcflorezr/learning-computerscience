package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_AVL_trees.avl_insertion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/self-balancing-tree/problem
 * https://www.ideserve.co.in/learn/avl-tree-insertion
 * https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 */
public class Solution {

    public static List<Integer> getBalancedTree(int[] inputArray) {
        TreeNode root = null;
        for (int element : inputArray) {
            root = insertNode(root, element);
        }
        ArrayList<Integer> treeElements = new ArrayList<>();
        preOrderTraversal(root, treeElements);
        return treeElements;
    }

    private static void preOrderTraversal(TreeNode current, ArrayList<Integer> treeElements) {
        if (current == null) return;
        treeElements.add(current.data);
        preOrderTraversal(current.left, treeElements);
        preOrderTraversal(current.right, treeElements);
    }

    private static TreeNode insertNode(TreeNode current, int element) {
        if (current == null) return new TreeNode(element, 1);
        if (element <= current.data) {
            current.left = insertNode(current.left, element);
        } else {
            current.right = insertNode(current.right, element);
        }
        int balance = getHeight(current.left) - getHeight(current.right);
        if (Math.abs(balance) > 1) {
            current = balanceTree(current, balance);
        }
        current.height = Math.max(getHeight(current.left), getHeight(current.right)) + 1;
        return current;
    }

    private static TreeNode balanceTree(TreeNode current, int balance) {
        if (balance > 1) {
            if (current.left.left != null) {
                return rightRotate(current);
            } else {
                current.left = leftRotate(current.left);
                return rightRotate(current);
            }
        } else {
            if (current.right.right != null) {
                return leftRotate(current);
            } else {
                current.right = rightRotate(current.right);
                return leftRotate(current);
            }
        }
    }

    private static TreeNode rightRotate(TreeNode current) {
        TreeNode temp = current.left;
        TreeNode temp2 = temp.right;
        temp.right = current;
        current.left = temp2;
        current.height = temp2 != null ? 2 : 1;
        return temp;
    }

    private static TreeNode leftRotate(TreeNode current) {
        TreeNode temp = current.right;
        TreeNode temp2 = temp.left;
        temp.left = current;
        current.right = temp2;
        current.height = temp2 != null ? 2 : 1;
        return temp;
    }

    private static int getHeight(TreeNode current) {
        return current != null ? current.height : 0;
    }
}

class TreeNode {
    int data;
    int height;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data, int height) {
        this.data = data;
        this.height = height;
    }

    @Override
    public String toString() {
        return "{" +
                "data=" + data +
                "}";
    }
}