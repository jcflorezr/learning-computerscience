package net.learning.computerscience.datastructures.trees.course.avltree.a_myown;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class MyAVLTreeTest {
    
    private MyAVLTree<Integer> myAVLTree;
    
    @Before
    public void setUp() {
        myAVLTree = new MyAVLTree<>();
    }

    @Test
    public void testBinarySearchTreeOperations() throws Exception {
        //List<Integer> list = asList(32,39,6,36,43,8,3,1,7,45);
        List<Integer> list = asList(20,10,40,30,50);
        list.forEach(element -> myAVLTree.insert(element));

//        // in-order traversal
//        String expectedResult = "[1, 3, 6, 7, 8, 32, 36, 39, 43, 45]";
//        assertThat(myAVLTree.inOrderTraversal().toString(), equalTo(expectedResult));
//
//        // pre-order traversal
//        expectedResult = "[32, 6, 3, 1, 8, 7, 39, 36, 43, 45]";
//        assertThat(myAVLTree.preOrderTraversal().toString(), equalTo(expectedResult));
//
//        // post-order traversal
//        expectedResult = "[1, 3, 7, 8, 6, 36, 45, 43, 39, 32]";
//        assertThat(myAVLTree.postOrderTraversal().toString(), equalTo(expectedResult));
//
//        // get maximum element
//        assertThat(myAVLTree.getMax(), equalTo(45));
//
//        // get minimum element
//        assertThat(myAVLTree.getMin(), equalTo(1));

        // remove the root node
        myAVLTree.remove(32);
//        expectedResult = "[8, 6, 3, 1, 7, 39, 36, 43, 45]";
//        assertThat(myAVLTree.preOrderTraversal().toString(), equalTo(expectedResult));
    }

}