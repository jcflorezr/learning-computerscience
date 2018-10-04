package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_AVL_trees;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.*;

public class CompleteAVLTree1Test {

    @Test
    public void testAVLTree() {
        CompleteAVLTree1<Integer> avlTree = new CompleteAVLTree1<>();
        int[] elements = {6,7,2,0,3,1,5,9,4,8,10};
        for (int element : elements) {
            avlTree.insert(element);
        }
        List<Integer> levelOrderElements = levelOrderTraversal(avlTree.root);
        assertEquals(Arrays.asList(6,2,8,0,4,7,9,1,3,5,10), levelOrderElements);
        avlTree.delete(8);
        levelOrderElements = levelOrderTraversal(avlTree.root);
        assertEquals(Arrays.asList(6,2,9,0,4,7,10,1,3,5), levelOrderElements);
        avlTree.delete(2);
        levelOrderElements = levelOrderTraversal(avlTree.root);
        assertEquals(Arrays.asList(6,3,9,0,4,7,10,1,5), levelOrderElements);
        avlTree.delete(200);
        levelOrderElements = levelOrderTraversal(avlTree.root);
        assertEquals(Arrays.asList(6,3,9,0,4,7,10,1,5), levelOrderElements);
    }

    private <T extends Comparable<T>> List<T> levelOrderTraversal(Node<T> current) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(current);
        List<T> levelOrderElements = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node<T> temp = queue.poll();
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            levelOrderElements.add(temp.element);
        }
        return levelOrderElements;
    }
}