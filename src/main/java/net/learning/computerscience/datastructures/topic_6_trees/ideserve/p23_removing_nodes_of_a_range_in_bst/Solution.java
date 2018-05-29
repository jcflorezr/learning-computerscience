package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p23_removing_nodes_of_a_range_in_bst;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * https://www.ideserve.co.in/learn/remove-out-of-range-bst-nodes
 */
public class Solution {

    private static Predicate<TreeNode> isLeafNode = (node) -> node.left == null && node.right == null;
    private static Predicate<TreeNode> hasTwoChildren = (node) -> node.left != null && node.right != null;

    public static ArrayList<Integer> removeNodesOfASpecificRange(TreeNode root, int from, int to) {
        TreeNode modifiedTree = removeNodes(root, from, to);
        ArrayList<Integer> nodes = new ArrayList<>();
        getNodes(modifiedTree, nodes);
        return nodes;
    }

    private static TreeNode removeNodes(TreeNode node, int from, int to) {
        if (node == null) return null;
        node.left = removeNodes(node.left, from, to);
        node.right = removeNodes(node.right, from, to);
        if (node.data >= from && node.data <= to) {
            if (isLeafNode.test(node)) {
                return null;
            } else if (hasTwoChildren.test(node)) {
                TreeNode predecessor = getPredecessor(node.left);
                node.left = removeNode(predecessor, node.left);
                predecessor.left = node.left;
                predecessor.right = node.right;
                return predecessor;
            } else {
                return node.left != null ? node.left : node.right;
            }
        }
        else return node;
    }

    private static TreeNode removeNode(TreeNode nodeToBeDeleted, TreeNode node) {
        if (nodeToBeDeleted.data == node.data) {
            if (isLeafNode.test(node)) {
                return null;
            } else {
                return node.left != null ? node.left : node.right;
            }
        }
        else return removeNode(nodeToBeDeleted, node.right);
    }

    private static void getNodes(TreeNode modifiedTree, ArrayList<Integer> nodes) {
        if (modifiedTree == null) return;
        getNodes(modifiedTree.left, nodes);
        nodes.add(modifiedTree.data);
        getNodes(modifiedTree.right, nodes);
    }

    private static TreeNode getPredecessor(TreeNode node) {
        return node.right != null ? getPredecessor(node.right) : node;
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
