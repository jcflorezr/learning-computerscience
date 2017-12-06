package net.learning.computerscience.hackerrank.datastructures.trees.p5_tree_top_view;

import net.learning.computerscience.hackerrank.datastructures.trees.Node;

public class Solution {

    void topView(Node root) {
        if (root == null) return;
        if (root.left != null) leftTopView(root.left);
        System.out.print(root.data + " ");
        if (root.right != null) rightTopView(root.right);
    }

    void leftTopView(Node root) {
        if (root.left != null) leftTopView(root.left);
        System.out.print(root.data + " ");
    }

    void rightTopView(Node root) {
        System.out.print(root.data + " ");
        if (root.right != null) rightTopView(root.right);
    }

}
