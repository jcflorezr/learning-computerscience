package net.learning.computerscience.datastructures.topic_6_trees.ideserve.p36_convert_a_binary_tree_to_linked_list;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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

        TreeNode listFromBinaryTree = Solution.getLinkedList(n4);

        compareList(listFromBinaryTree, new int[]{0,1,2,3,4,5,6,7,8});
    }

    private void compareList(TreeNode list, int[] expectedElements) {
        for (int i = 0; i < expectedElements.length; i++) {
            assertNotNull(list);
            assertThat(list.data, is(equalTo(expectedElements[i])));
            list = list.next == null ? list : list.next;
        }
        for (int i = expectedElements.length - 1; i >= 0; i--) {
            assertNotNull(list);
            assertThat(list.data, is(equalTo(expectedElements[i])));
            list = list.prev;
        }
    }

}