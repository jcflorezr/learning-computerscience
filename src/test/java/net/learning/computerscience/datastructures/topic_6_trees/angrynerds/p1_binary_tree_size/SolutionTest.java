package net.learning.computerscience.datastructures.topic_6_trees.angrynerds.p1_binary_tree_size;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getTreeSize() {
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

        assertThat(Solution.getTreeSize(root), is(equalTo(7)));

    }
}