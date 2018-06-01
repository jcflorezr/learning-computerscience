package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p44_binary_search_tree_deletion;

import java.util.ArrayList;

/**
 * https://www.ideserve.co.in/learn/binary-search-tree-delete
 */
public class Solution {

    public static ArrayList<Integer> deleteNode(TreeNode root, int valueToBeDeleted) {
        ArrayList<Integer> elements = new ArrayList<>();
        root = delete(root, valueToBeDeleted);
        traverseTree(root, elements);
        return elements;
    }

    private static TreeNode delete(TreeNode node, int valueToBeDeleted) {
        if (node == null) return null;
        if (node.data == valueToBeDeleted) {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left != null && node.right != null) {
                TreeNode predecessor = getPredecessor(node.left);
                delete(node, predecessor.data);
                node.data = predecessor.data;
                return node;
            } else {
                return node.left == null ? node.right : node.left;
            }
        }
        node.left = delete(node.left, valueToBeDeleted);
        node.right = delete(node.right, valueToBeDeleted);
        return node;
    }

    private static TreeNode getPredecessor(TreeNode node) {
        return node.right == null ? node : getPredecessor(node.right);
    }

    private static void traverseTree(TreeNode node, ArrayList<Integer> elements) {
        if (node == null) return;
        traverseTree(node.left, elements);
        elements.add(node.data);
        traverseTree(node.right, elements);
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