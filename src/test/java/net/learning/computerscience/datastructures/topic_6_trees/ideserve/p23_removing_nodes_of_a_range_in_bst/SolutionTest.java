package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p23_removing_nodes_of_a_range_in_bst;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void removeNodesOfASpecificRange() {

        TreeNode treeNode = newBST(new int[]{8, 5, 11, 2, 7, 9, 12, 6, 10, 13}, 0);
        System.out.println();

    }

    private TreeNode newBST(int[] elements, int index) {
        if (index >= elements.length) return null;
        TreeNode newNode = new TreeNode(elements[index]);
        TreeNode newNode1 = newBST(elements, index + 1);
        TreeNode newNode2 = newBST(elements, index + 2);
        newNode.left = (newNode1 == null ? Integer.MIN_VALUE : newNode1.data) >
                       (newNode2 == null ? Integer.MIN_VALUE : newNode2.data)
                    ? newNode2 : newNode1;
        newNode.right = (newNode1 == null ? Integer.MIN_VALUE : newNode1.data) <
                    (newNode2 == null ? Integer.MIN_VALUE : newNode2.data)
                    ? newNode2 : newNode1;
        return newNode;
    }
}