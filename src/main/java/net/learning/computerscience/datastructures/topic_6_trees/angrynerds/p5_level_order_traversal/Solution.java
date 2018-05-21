package net.learning.computerscience.datastructures.topic_6_trees.angrynerds.p5_level_order_traversal;

import java.util.ArrayDeque;

/**
 * http://angrynerds.io/problems/binary-tree-level-order-traversal
 */
public class Solution {

    public static String levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        String result = "";
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result += current.data + " ";
            if (current.left != null) queue.offer(current.left);
            if (current.right!= null) queue.offer(current.right);
        }
        return result.trim();
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
}
