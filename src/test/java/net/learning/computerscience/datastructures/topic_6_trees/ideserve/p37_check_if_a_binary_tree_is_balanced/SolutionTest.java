package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p37_check_if_a_binary_tree_is_balanced;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void checkIfBalanced() {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n4.left = n1;
        n4.right = n6;

        n1.left = n0;
        n1.right = n2;
        n6.left = n5;
        n6.right = n7;

        n2.right = n3;
        n7.right = n8;

        assertTrue(Solution.checkIfBalanced(n4));
    }

    @Test
    public void checkIfBalanced2() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n5.left = n7;
        n7.right = n8;

        assertFalse(Solution.checkIfBalanced(n1));
    }
}