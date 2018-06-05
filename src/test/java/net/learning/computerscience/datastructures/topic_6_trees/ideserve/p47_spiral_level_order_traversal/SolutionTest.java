package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p47_spiral_level_order_traversal;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getSpiralTraversal() {
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
        assertThat(Solution.getSpiralTraversal(n4), is(equalTo(Arrays.asList(4,1,6,7,5,2,0,3,8))));
    }

    @Test
    public void getSpiralTraversal2() {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n0.left = n1;
        n0.right = n2;

        n1.left = n4;
        n1.right = n5;
        n2.left = n3;
        n2.right = n6;

        n5.left = n7;
        n5.right = n8;
        n6.right = n9;

        assertThat(Solution.getSpiralTraversal(n0), is(equalTo(Arrays.asList(0,1,2,6,3,5,4,7,8,9))));
    }
}