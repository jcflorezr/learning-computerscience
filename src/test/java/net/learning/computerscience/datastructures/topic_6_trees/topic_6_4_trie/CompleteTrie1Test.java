package net.learning.computerscience.datastructures.topic_6_trees.topic_6_4_trie;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompleteTrie1Test {

    @Test
    public void trieOperations1() {

        CompleteTrie1 trie = new CompleteTrie1();
        assertFalse(trie.searchWord("any"));

        trie.insert("airport");
        trie.insert("aircraft");
        trie.insert("airbag");

        assertTrue(trie.searchWord("aircraft"));
        assertTrue(trie.isPrefix("aircraft"));
        assertTrue(trie.searchWord("airbag"));
        assertTrue(trie.isPrefix("airbag"));
        assertTrue(trie.searchWord("airport"));
        assertTrue(trie.isPrefix("airport"));
        assertTrue(trie.isPrefix("air"));
        assertFalse(trie.searchWord("airplane"));
        assertFalse(trie.searchWord("airbags"));

        assertFalse(trie.searchWord("air"));
        trie.insert("air");
        assertTrue(trie.searchWord("air"));

    }
}