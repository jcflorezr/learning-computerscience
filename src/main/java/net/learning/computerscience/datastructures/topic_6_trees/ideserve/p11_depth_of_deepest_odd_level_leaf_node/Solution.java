package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p11_depth_of_deepest_odd_level_leaf_node;

import java.util.function.Predicate;

/**
 * https://www.ideserve.co.in/learn/depth-of-deepest-odd-level-leaf-node
 */
public class Solution {


    private static Predicate<TreeNode> isLeafNode = (node) -> node.left == null && node.right == null;
    private static Predicate<Integer> isOdd = (number) -> number % 2 != 0;

    public static int getDeepestOddLevelLeafNode(TreeNode root) {
        return getDeepestOddLevelLeafNode(root, 0);
    }

    private static int getDeepestOddLevelLeafNode(TreeNode current, int currentLevel) {
        if (current == null) return 0;
        if (isLeafNode.test(current) && isOdd.test(currentLevel)) {
            return currentLevel;
        } else {
            return Math.max(getDeepestOddLevelLeafNode(current.left, currentLevel + 1),
                            getDeepestOddLevelLeafNode(current.right, currentLevel + 1));
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
