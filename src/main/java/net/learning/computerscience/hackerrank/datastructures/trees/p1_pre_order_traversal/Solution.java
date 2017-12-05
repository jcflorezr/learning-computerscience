package net.learning.computerscience.hackerrank.datastructures.trees.p1_pre_order_traversal;

import net.learning.computerscience.hackerrank.datastructures.trees.Node;

public class Solution {

    void preOrder(Node root) {
        System.out.print(root.data + " ");
        if (root.left != null) preOrder(root.left);
        if (root.right != null) preOrder(root.right);
    }

}
