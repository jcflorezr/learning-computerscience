package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p14_check_if_two_nodes_are_cousins;

import java.util.Objects;

/**
 * https://www.ideserve.co.in/learn/check-if-two-nodes-are-cousins-binary-tree
 */
public class Solution {

    public static boolean checkIfTwoNodesAreCousins(TreeNode root, int valueA, int valueB) {
        Info infoA = getInfo(root, valueA, 0);
        Info infoB = getInfo(root, valueB, 0);
        return infoA.equals(infoB);
    }

    private static Info getInfo(TreeNode current, int value, int level) {
        if (current == null) return null;
        if (current.data == value) {
            return new Info(level);
        }

        Info info = getInfo(current.left, value, level + 1);
        info = (info == null) ? getInfo(current.right, value, level + 1) : info;

        if (info == null) return info;
        if (info.numAncestor == 2) {
            info.grandpa = current;
        } else {
            info.numAncestor++;
        }
        return info;
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

class Info {
    int level;
    TreeNode grandpa;
    int numAncestor = 1;

    public Info(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return level == info.level &&
                (info.grandpa != null && ((Info) o).grandpa != null &&
                        info.grandpa.data == ((Info) o).grandpa.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, grandpa);
    }
}