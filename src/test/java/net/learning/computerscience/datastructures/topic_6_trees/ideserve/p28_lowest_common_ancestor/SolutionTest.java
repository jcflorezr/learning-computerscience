package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p28_lowest_common_ancestor;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    private TreeNode root;

    @Before
    public void setUp() {
        root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n5.left = n7;
        n4.right = n8;
        n6.right = n9;
        n8.right = n10;
    }

    @Test
    public void getLowestCommonAncestor() {
        assertThat(Solution.getLowestCommonAncestor(root, 10, 9), is(equalTo(1)));
    }

    @Test
    public void getLowestCommonAncestor2() {
        assertThat(Solution.getLowestCommonAncestor(root, 3, 6), is(equalTo(3)));
    }

    @Test
    public void getLowestCommonAncestor3() {
        assertThat(Solution.getLowestCommonAncestor(root, 8, 7), is(equalTo(2)));
    }

    @Test
    public void getLowestCommonAncestor4() {
        assertThat(Solution.getLowestCommonAncestor(root, 5, 1), is(equalTo(1)));
    }

}