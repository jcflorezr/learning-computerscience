package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p14_check_if_two_nodes_are_cousins;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void checkIfTwoNodesAreCousins() {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n5.left = n7;
        n4.right = n8;
        n6.right = n9;
        n8.right = n10;

        assertFalse(Solution.checkIfTwoNodesAreCousins(n1, 2, 3));
        assertTrue(Solution.checkIfTwoNodesAreCousins(n1, 5, 6));
        assertFalse(Solution.checkIfTwoNodesAreCousins(n1, 10, 9));
        assertTrue(Solution.checkIfTwoNodesAreCousins(n1, 8, 7));

    }
}