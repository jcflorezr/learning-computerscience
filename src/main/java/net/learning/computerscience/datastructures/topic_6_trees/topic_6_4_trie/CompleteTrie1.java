package net.learning.computerscience.datastructures.topic_6_trees.topic_6_4_trie;

public class CompleteTrie1 {

    private Node root;

    public CompleteTrie1() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (char letter : word.toCharArray()) {
            if (current.getChild(letter) == null) {
                current.setChild(letter, false);
            }
            current = current.getChild(letter);
        }
        current.setEndOfWord();
    }

    public boolean searchWord(String word) {
        Node current = isWithinTrie(word);
        return current != null && current.isEndOfWord();
    }

    public boolean isPrefix(String word) {
        return isWithinTrie(word) != null;
    }

    private Node isWithinTrie(String word) {
        Node current = root;
        for (char letter : word.toCharArray()) {
            current = current.getChild(letter);
            if (current == null) return null;
        }
        return current;
    }
}

class Node {
    private char letter;
    private Node[] children;
    private boolean endOfWord;

    public Node() {
        this.children = new Node[26];
    }

    public Node(char letter, boolean endOfWord) {
        this.letter = letter;
        this.children = new Node[26];
        this.endOfWord = endOfWord;
    }

    public char getLetter() {
        return this.letter;
    }

    public Node getChild(char letter) {
        return children[letter - 'a'];
    }

    public void setChild(char letter, boolean endOfWord) {
        int arrIdx = letter - 'a';
        if (arrIdx < 0 || arrIdx >= 26) {
            throw new RuntimeException("Only lowercase a-z characters allowed");
        }
        this.children[letter - 'a'] = new Node(letter, endOfWord);
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord() {
        this.endOfWord = true;
    }
}