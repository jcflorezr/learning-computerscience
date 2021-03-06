package net.learning.computerscience.datastructures.topic_6_trees.hacker_rank.p3_in_order_traversal;

import net.learning.computerscience.datastructures.topic_6_trees.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/tree-inorder-traversal/problem
 */
public class Solution {
    void inOrder(Node root) {
        if (root != null) {
            if (root.left != null) inOrder(root.left);
            System.out.print(root.data + " ");
            if (root.right != null) inOrder(root.right);
        }
    }
}
