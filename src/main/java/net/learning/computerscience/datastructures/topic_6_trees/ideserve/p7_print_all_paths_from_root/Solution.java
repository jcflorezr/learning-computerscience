package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p7_print_all_paths_from_root;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * https://www.ideserve.co.in/learn/print-all-root-to-leaf-paths-of-a-binary-tree
 */
public class Solution {


    private static Predicate<TreeNode> isLeafNode = (node) -> node.left == null && node.right == null;
    private static BiPredicate<TreeNode, Stack<Integer>> nodeBelongsToPath =
            (node, path) -> (path.peek() == (node.left != null ? node.left.data : -Integer.MAX_VALUE)) ||
                            (path.peek() == (node.right != null ? node.right.data : -Integer.MAX_VALUE));

    public static List<Stack<Integer>> getPathsFromRoot(TreeNode treeNode) {
        List<Stack<Integer>> pathsFromRoot = new ArrayList<>();
        generatePaths(treeNode, pathsFromRoot);
        return pathsFromRoot;
    }

    private static void generatePaths(TreeNode current, List<Stack<Integer>> pathsFromRoot) {
        if (current == null) return;
        if (isLeafNode.test(current)) {
            Stack<Integer> newPath = new Stack<>();
            newPath.push(current.data);
            pathsFromRoot.add(newPath);
            return;
        }
        generatePaths(current.left, pathsFromRoot);
        generatePaths(current.right, pathsFromRoot);
        pathsFromRoot.stream().filter(path -> nodeBelongsToPath.test(current, path)).forEach(path -> path.push(current.data));
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
}
