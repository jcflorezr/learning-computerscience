package net.learning.computerscience.datastructures.topic_6_trees.hacker_rank.p1_pre_order_traversal;

import net.learning.computerscience.datastructures.topic_6_trees.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/tree-preorder-traversal/problem
 */
public class Solution {

    void preOrder(Node root) {
        System.out.print(root.data + " ");
        if (root.left != null) preOrder(root.left);
        if (root.right != null) preOrder(root.right);
    }

}
