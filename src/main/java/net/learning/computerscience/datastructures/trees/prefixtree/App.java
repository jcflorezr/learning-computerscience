package net.learning.computerscience.datastructures.trees.prefixtree;

import java.util.List;

public class App {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("joe", 1);
        trie.insert("adam", 2);
        trie.insert("adamm", 20);


        System.out.println(trie.searchAsMap("adamm"));

        Trie autocompleteTrie = new Trie();
        autocompleteTrie.insert("adam", 2);
        autocompleteTrie.insert("ada", 20);
        autocompleteTrie.insert("adaa", 210);
        autocompleteTrie.insert("adada", 230);
        autocompleteTrie.insert("adazzz", 250);

        List<String> list = autocompleteTrie.allWordsWithPrefix("");

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("longest common prefix: " + autocompleteTrie.longestCommonPrefix());

    }

}
