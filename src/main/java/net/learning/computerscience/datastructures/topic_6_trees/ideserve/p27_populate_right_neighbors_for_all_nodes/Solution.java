package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p27_populate_right_neighbors_for_all_nodes;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * https://www.ideserve.co.in/learn/populate-right-neighbors-in-a-binary-tree
 */
public class Solution {

    public static ArrayList<Integer> getRightNeighbors(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        root.level = 1;
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.pollLast();
            if (current.left != null) {
                current.left.level = current.level + 1;
                nodes.offerFirst(current.left);
            }
            if (current.right != null) {
                current.right.level = current.level + 1;
                nodes.offerFirst(current.right);
            }
            TreeNode possibleNeighbor = nodes.peekLast();
            if (possibleNeighbor != null && possibleNeighbor.level == current.level) current.neighbor = possibleNeighbor;
        }
        ArrayList<Integer> neighbors = new ArrayList<>();
        populateNeighbors(neighbors, root);
        return neighbors;
    }

    private static void populateNeighbors(ArrayList<Integer> neighbors, TreeNode node) {
        if (node == null) return;
        populateNeighbors(neighbors, node.left);
        if (node.neighbor != null) neighbors.add(node.neighbor.data);
        populateNeighbors(neighbors, node.right);
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode neighbor;
    int level;

    public TreeNode(int data) {
        this.data = data;
    }
}