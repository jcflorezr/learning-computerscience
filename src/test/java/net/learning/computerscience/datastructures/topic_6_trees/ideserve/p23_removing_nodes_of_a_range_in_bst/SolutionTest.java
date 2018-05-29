package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p23_removing_nodes_of_a_range_in_bst;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void removeNodesOfASpecificRange() {
        TreeNode treeNode = newBST(new int[]{8, 5, 11, 2, 7, 9, 12, 6, 10, 13});
        assertThat(Solution.removeNodesOfASpecificRange(treeNode, 3, 9), is(equalTo(Arrays.asList(2,10,11,12,13))));
    }

    @Test
    public void removeNodesOfASpecificRange2() {
        TreeNode treeNode = newBST(new int[]{8, 5, 11, 2, 7, 9, 12, 6, 10, 13});
        assertThat(Solution.removeNodesOfASpecificRange(treeNode, 9, 13), is(equalTo(Arrays.asList(2,5,6,7,8))));
    }

    @Test
    public void removeNodesOfASpecificRange3() {
        TreeNode treeNode = newBST(new int[]{8, 3, 9, 2, 6, 5, 7, 4});
        assertThat(Solution.removeNodesOfASpecificRange(treeNode, 2, 6), is(equalTo(Arrays.asList(7,8,9))));
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