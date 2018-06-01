package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p44_binary_search_tree_deletion;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    private TreeNode treeNode;

    @Before
    public void setUp() {
        treeNode = newBST(new int[]{8, 5, 11, 2, 7, 9, 12, 6, 10, 13});
    }

    @Test
    public void deleteLeafNode() {
        assertThat(Solution.deleteNode(treeNode, 6), is(equalTo(Arrays.asList(2,5,7,8,9,10,11,12,13))));
    }

    @Test
    public void deleteNodeWithOneChild() {
        assertThat(Solution.deleteNode(treeNode, 12), is(equalTo(Arrays.asList(2,5,6,7,8,9,10,11,13))));
    }

    @Test
    public void deleteNodeWithTwoChildren() {
        assertThat(Solution.deleteNode(treeNode, 8), is(equalTo(Arrays.asList(2,5,6,7,9,10,11,12,13))));
    }

    @Test
    public void deleteNodeWithTwoChildren2() {
        assertThat(Solution.deleteNode(treeNode, 5), is(equalTo(Arrays.asList(2,6,7,8,9,10,11,12,13))));
    }

    private TreeNode newBST(int[] elements) {
        TreeNode root = new TreeNode(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            insertNode(elements[i], root);
        }
        return root;
    }

    private void insertNode(int element, TreeNode node) {
        if (node == null) node = new TreeNode(element);
        else {
            if (element <= node.data) {
                if (node.left == null) node.left = new TreeNode(element);
                else insertNode(element, node.left);
            } else {
                if (node.right == null) node.right = new TreeNode(element);
                else insertNode(element, node.right);
            }
        }
    }
}