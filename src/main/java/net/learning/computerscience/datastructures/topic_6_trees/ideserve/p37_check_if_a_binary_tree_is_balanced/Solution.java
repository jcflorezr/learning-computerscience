package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p37_check_if_a_binary_tree_is_balanced;

/**
 * https://www.ideserve.co.in/learn/check-if-a-binary-tree-is-balanced
 */
public class Solution {

    public static boolean checkIfBalanced(TreeNode root) {
        return Math.abs(getHeight(root.left) - getHeight(root.right)) < 1;
    }

    private static int getHeight(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int lHeight = getHeight(treeNode.right);
        int rHeight = getHeight(treeNode.left);
        return Math.max(lHeight, rHeight) + 1;
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