package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p7_print_all_paths_from_root;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {

    @Test
    public void printAllPathsFromRoot() {
        TreeNode root = new TreeNode();
        root.data = 1;

        root.left = new TreeNode();
        root.left.data = 2;
        root.right = new TreeNode();
        root.right.data = 3;

        root.left.left = new TreeNode();
        root.left.left.data = 4;
        root.left.right = new TreeNode();
        root.left.right.data = 5;
        root.right.left = new TreeNode();
        root.right.left.data = 6;

        root.left.left.right = new TreeNode();
        root.left.left.right.data = 8;
        root.right.left.right = new TreeNode();
        root.right.left.right.data = 9;

        root.left.left.right.right = new TreeNode();
        root.left.left.right.right.data = 10;

        List<Stack<Integer>> pathsFromRoot = Solution.getPathsFromRoot(root);

        List<Stack<Integer>> expectedPathsFromRoot = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        path.push(10);
        path.push(8);
        path.push(4);
        path.push(2);
        path.push(1);
        expectedPathsFromRoot.add(path);
        path = new Stack<>();
        path.push(5);
        path.push(2);
        path.push(1);
        expectedPathsFromRoot.add(path);
        path = new Stack<>();
        path.push(9);
        path.push(6);
        path.push(3);
        path.push(1);
        expectedPathsFromRoot.add(path);

        assertThat(pathsFromRoot, is(equalTo(expectedPathsFromRoot)));

    }

    @Test
    public void printAllPathsFromRoot2() {
        TreeNode root = new TreeNode();
        root.data = 1;

        root.left = new TreeNode();
        root.left.data = 2;
        root.right = new TreeNode();
        root.right.data = 3;

        root.left.left = new TreeNode();
        root.left.left.data = 4;
        root.left.right = new TreeNode();
        root.left.right.data = 5;
        root.right.left = new TreeNode();
        root.right.left.data = 6;
        root.right.right = new TreeNode();
        root.right.right.data = 7;

        List<Stack<Integer>> pathsFromRoot = Solution.getPathsFromRoot(root);

        List<Stack<Integer>> expectedPathsFromRoot = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        path.push(4);
        path.push(2);
        path.push(1);
        expectedPathsFromRoot.add(path);
        path = new Stack<>();
        path.push(5);
        path.push(2);
        path.push(1);
        expectedPathsFromRoot.add(path);
        path = new Stack<>();
        path.push(6);
        path.push(3);
        path.push(1);
        expectedPathsFromRoot.add(path);
        path = new Stack<>();
        path.push(7);
        path.push(3);
        path.push(1);
        expectedPathsFromRoot.add(path);

        assertThat(pathsFromRoot, is(equalTo(expectedPathsFromRoot)));

    }
}