package net.learning.computerscience.datastructures.topic_6_trees.hacker_rank.p2_post_order_traversal;

import net.learning.computerscience.datastructures.topic_6_trees.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/tree-postorder-traversal/problem
 */
public class Solution {
    void postOrder(Node root) {
        if (root != null) {
            if (root.left != null) postOrder(root.left);
            if (root.right != null) postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
