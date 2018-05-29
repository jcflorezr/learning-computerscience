package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p28_lowest_common_ancestor;

/**
 * https://www.ideserve.co.in/learn/lowest-common-ancestor-of-two-nodes-binary-search-tree
 */
public class Solution {

    public static int getLowestCommonAncestor(TreeNode root, int node1, int node2) {
        return getLowestAncestor(root, node1, node2).data;
    }

    private static TreeNode getLowestAncestor(TreeNode current, int node1, int node2) {
        if (current == null) return null;

        TreeNode treeNode1 = getLowestAncestor(current.left, node1, node2);
        TreeNode treeNode2 = getLowestAncestor(current.right, node1, node2);

        if (treeNode1 != null && treeNode2 != null) return current;
        if (current.data == node1 || current.data == node2) return current;

        return treeNode1 != null ? treeNode1 : treeNode2;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int data) {
        this.data = data;
    }
}