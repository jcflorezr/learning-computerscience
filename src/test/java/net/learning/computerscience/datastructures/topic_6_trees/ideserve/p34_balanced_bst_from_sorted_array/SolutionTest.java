package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p34_balanced_bst_from_sorted_array;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void getBalancedBST() {
        int[] sortedArray = {0,1,2,3,4,5,6,7,8};

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

        TreeNode balancedBST = Solution.getBalancedBST(sortedArray);

        compareBSTs(balancedBST, n4);
    }

    @Test
    public void getBalancedBST2() {
        int[] sortedArray = {0,1,2,3,4,5,6,7};

        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n3.left = n1;
        n3.right = n5;

        n1.left = n0;
        n1.right = n2;
        n5.left = n4;
        n5.right = n6;

        n6.right = n7;

        TreeNode balancedBST = Solution.getBalancedBST(sortedArray);

        compareBSTs(balancedBST, n3);
    }

    private void compareBSTs(TreeNode actual, TreeNode expected) {
        if (actual == null && expected == null) return;
        assertThat(actual, is(equalTo(expected)));
        compareBSTs(actual.left, expected.left);
        compareBSTs(actual.right, expected.right);
    }
}