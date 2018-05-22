package net.learning.computerscience.datastructures.topic_6_trees.angrynerds.p7_mirror_of_a_binary_tree;

/**
 * http://angrynerds.io/problems/mirror-a-tree
 */
public class Solution {

    public static TreeNode convertToMirror(TreeNode root) {
        swapChildren(root);
        return root;
    }

    private static void swapChildren(TreeNode current) {
        if (current == null) return;
        TreeNode temp = current.left;
        current.left = current.right;
        current.right = temp;
        swapChildren(current.left);
        swapChildren(current.right);
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
}
