package net.learning.computerscience.datastructures.topic_6_trees.angrynerds.p7_mirror_of_a_binary_tree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void convertToMirror() {
        TreeNode root = new TreeNode();
        root.data = 1;
        root.left = new TreeNode();
        root.left.data = 2;
        root.right = new TreeNode();
        root.right.data = 3;
        root.left.left = new TreeNode();
        root.left.left.data = 4;
        root.left.right = new TreeNode();
        root.left.right.data = 5;
        root.right.left = new TreeNode();
        root.right.left.data = 6;
        root.right.right = new TreeNode();
        root.right.right.data = 7;

        TreeNode actual = Solution.convertToMirror(root);
        String result = inOrderTraversal(actual).trim();
        assertThat(result, is(equalTo("7 3 6 1 5 2 4")));
    }

    private String inOrderTraversal(TreeNode current) {
        if (current == null) return "";
        String result = "";
        result += inOrderTraversal(current.left);
        result += current.data + " ";
        result += inOrderTraversal(current.right);
        return result;
    }
}