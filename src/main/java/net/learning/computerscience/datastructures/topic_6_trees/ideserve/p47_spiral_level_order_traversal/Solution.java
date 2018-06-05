package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p47_spiral_level_order_traversal;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://www.ideserve.co.in/learn/spiral-level-order-traversal-of-a-binary-tree-set-1
 */
public class Solution {

    public static ArrayList<Integer> getSpiralTraversal(TreeNode root) {
        ArrayList<Integer> elements = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int level = 1;
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            if (level % 2 != 0 && !stack1.isEmpty()) {
                traverseOddLevel(stack1, stack2, elements);
            } else if (level % 2 == 0 && !stack2.isEmpty()) {
                traverseEvenLevel(stack1, stack2, elements);
            }
            level++;
        }
        return elements;
    }

    private static void traverseOddLevel(Stack<TreeNode> stack1, Stack<TreeNode> stack2, ArrayList<Integer> elements) {
        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            elements.add(current.data);
            if (current.right != null) stack2.push(current.right);
            if (current.left != null) stack2.push(current.left);
        }
    }

    private static void traverseEvenLevel(Stack<TreeNode> stack1, Stack<TreeNode> stack2, ArrayList<Integer> elements) {
        while (!stack2.isEmpty()) {
            TreeNode current = stack2.pop();
            elements.add(current.data);
            if (current.left != null) stack1.push(current.left);
            if (current.right != null) stack1.push(current.right);
        }
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "data=" + data +
                "}";
    }
}