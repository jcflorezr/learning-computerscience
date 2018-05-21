package net.learning.computerscience.datastructures.topic_6_trees.angrynerds.p1_binary_tree_size;

/**
 * http://angrynerds.io/problems/find-binary-tree-size
 */
public class Solution {

    public static int getTreeSize(TreeNode root) {
        if (root == null) return 0;
        return 1 + getTreeSize(root.left) + getTreeSize(root.right);
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
}
