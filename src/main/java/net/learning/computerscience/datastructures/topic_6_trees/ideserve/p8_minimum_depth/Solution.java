package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p8_minimum_depth;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * https://www.ideserve.co.in/learn/minimum-depth-of-a-binary-tree
 */
public class Solution {


    private static final Predicate<TreeNode> isLeafNode = (node) -> node.left == null && node.right == null;

    public static int getMinimumPath(TreeNode treeNode) {
        List<Integer> depths = new ArrayList<>();
        generateDepths(treeNode, depths, 1);
        return depths.stream().min((a, b) -> a - b).get();
    }

    private static void generateDepths(TreeNode current, List<Integer> depths, int currentDepth) {
        if (current == null) return;
        if (isLeafNode.test(current)) {
            depths.add(currentDepth + 1);
        } else {
            generateDepths(current.left, depths, currentDepth + 1);
            generateDepths(current.right, depths, currentDepth + 1);
        }
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
