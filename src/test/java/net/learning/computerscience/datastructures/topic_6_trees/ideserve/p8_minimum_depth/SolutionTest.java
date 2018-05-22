package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p8_minimum_depth;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findMinimumDepth() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.right = new TreeNode(8);
        root.left.left.right.right = new TreeNode(11);
        root.left.right.right = new TreeNode(9);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(10);

        assertThat(Solution.getMinimumPath(root), is(equalTo(3)));
    }

}