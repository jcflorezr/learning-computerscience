package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p5_print_right_view;

/**
 * https://www.ideserve.co.in/learn/right-view-of-a-binary-tree
 */
public class Solution {

    private static int maxLevelSoFar = -1;

    public static String getRightNodes(TreeNode root) {
        return getRightNodes(root, 0).trim();
    }

    private static String getRightNodes(TreeNode current, int currentLevel) {
        String nodesString = "";
        if (current == null) return nodesString;
        if (maxLevelSoFar < currentLevel) {
            maxLevelSoFar = currentLevel;
            nodesString = current.data + " ";
        }
        nodesString += getRightNodes(current.right, currentLevel + 1);
        nodesString += getRightNodes(current.left, currentLevel + 1);
        return nodesString;
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
