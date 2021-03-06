package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p33_diagonal_sum_of_a_binary_tree;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getSumOfDiagonals() {
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

        assertThat(Solution.getSumOfDiagonals(n1), is(equalTo(Arrays.asList(4,22,29))));
    }

    @Test
    public void getSumOfDiagonals2() {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n0.left = n1;
        n0.right = n2;
        n1.left = n4;
        n1.right = n5;
        n2.left = n3;
        n2.right = n6;
        n5.left = n7;

        assertThat(Solution.getSumOfDiagonals(n0), is(equalTo(Arrays.asList(8,9,11))));
    }

}