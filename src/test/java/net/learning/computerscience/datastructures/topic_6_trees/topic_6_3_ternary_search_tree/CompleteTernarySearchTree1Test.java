package net.learning.computerscience.datastructures.topic_6_trees.topic_6_3_ternary_search_tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompleteTernarySearchTree1Test {

    @Test
    public void insert() {

        CompleteTernarySearchTree1 tree = new CompleteTernarySearchTree1();
        tree.insert("airport", 1);
        tree.insert("airbag", 2);
        tree.insert("airline", 3);
        tree.insert("airplane", 4);

        assertEquals(new Integer(1), tree.get("airport"));
        assertEquals(new Integer(2), tree.get("airbag"));
        assertEquals(new Integer(3), tree.get("airline"));
        assertEquals(new Integer(4), tree.get("airplane"));

        assertNull(tree.get("airplus"));

    }
}