package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p33_diagonal_sum_of_a_binary_tree;

import java.util.ArrayList;

/**
 * https://www.ideserve.co.in/learn/diagonal-sum-of-a-binary-tree
 */
public class Solution {

    public static ArrayList<Integer> getSumOfDiagonals(TreeNode root) {
        ArrayList<Integer> sums = new ArrayList<>();
        getSumOfDiagonals(root, sums, 1);
        return sums;
    }

    private static void getSumOfDiagonals(TreeNode currentNode, ArrayList<Integer> sums, int currentDiagonal) {
        if (currentNode == null) return;
        if (currentDiagonal > sums.size()) {
            sums.add(currentNode.data);
        } else {
            sums.set(currentDiagonal - 1, sums.get(currentDiagonal - 1) + currentNode.data);
        }
        getSumOfDiagonals(currentNode.left, sums, currentDiagonal + 1);
        getSumOfDiagonals(currentNode.right, sums, currentDiagonal);
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}