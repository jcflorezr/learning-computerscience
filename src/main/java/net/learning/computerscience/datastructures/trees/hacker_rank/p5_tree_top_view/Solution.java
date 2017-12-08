package net.learning.computerscience.datastructures.trees.hacker_rank.p5_tree_top_view;

import net.learning.computerscience.datastructures.trees.hacker_rank.Node;

/**
 * https://www.hackerrank.com/challenges/tree-top-view/problem
 */
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
