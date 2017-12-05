package net.learning.computerscience.hackerrank.datastructures.trees.p2_post_order_traversal;

import net.learning.computerscience.hackerrank.datastructures.trees.Node;

public class Solution {
    void postOrder(Node root) {
        if (root != null) {
            if (root.left != null) postOrder(root.left);
            if (root.right != null) postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
