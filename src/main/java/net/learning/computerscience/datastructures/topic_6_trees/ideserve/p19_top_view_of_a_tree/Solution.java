package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p19_top_view_of_a_tree;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * https://www.ideserve.co.in/learn/top-view-of-a-binary-tree
 */
public class Solution {

    public static ArrayList<Integer> getTopView(TreeNode root) {
        TreeMap<Integer, Integer> topViews = new TreeMap<>();
        topViews.put(0, root.data);
        getTopViews(root.left, topViews, -1);
        getTopViews(root.right, topViews, +1);
        return new ArrayList<>(topViews.values());
    }

    private static void getTopViews(TreeNode treeNode, TreeMap<Integer, Integer> topViews, int horizontalDistance) {
        if (treeNode == null) return;
        topViews.computeIfAbsent(horizontalDistance, k -> treeNode.data);
        getTopViews(treeNode.left, topViews, horizontalDistance - 1);
        getTopViews(treeNode.right, topViews, horizontalDistance + 1);
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
