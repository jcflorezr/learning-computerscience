package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_AVL_trees.avl_insertion;

import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTreeTest {

    @Test
    public void insertion() {

        AVLTree<Integer> avlTree = new AVLTree<>();
        int[] elements = {6,7,2,0,3,1,5,9,4,8,10};

        for (int element : elements) {
            avlTree.insert(element);
        }

        System.out.println();

    }
}