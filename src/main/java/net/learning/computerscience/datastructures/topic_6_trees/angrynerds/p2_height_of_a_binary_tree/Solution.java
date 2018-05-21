package net.learning.computerscience.datastructures.topic_6_trees.angrynerds.p2_height_of_a_binary_tree;

/**
 * http://angrynerds.io/problems/find-binary-tree-height
 */
public class Solution {

    public static int getTreeHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
}
