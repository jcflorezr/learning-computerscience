package net.learning.computerscience.datastructures.topic_6_trees.course.prefixtree;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private Node root;
    private int indexOfSingleChild;

    public Trie() {
        this.root = new Node("");
    }

    public void insert(String key, int value) {
        Node tempNode = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int asciiIndex = c - 'a';
            if (tempNode.getChild(asciiIndex) == null) {
                Node newNode = new Node(String.valueOf(c));
                tempNode.setChild(asciiIndex, newNode, value);
                tempNode = newNode;
            } else {
                tempNode = tempNode.getChild(asciiIndex);

            }
        }
        tempNode.setLeaf(true);
    }

    public boolean search(String key) {

        Node trieNode = root;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int asciiIndex = c - 'a';
            if (trieNode.getChild(asciiIndex) == null) {
                return false;
            } else {
                trieNode = trieNode.getChild(asciiIndex);
            }
        }

        return true;

    }

    public Integer searchAsMap(String key) {

        Node trieNode = root;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int asciiIndex = c - 'a';
            if (trieNode.getChild(asciiIndex) != null) {
                trieNode = trieNode.getChild(asciiIndex);
            } else {
                return null;
            }
        }

        return trieNode.getValue();

    }

    public List<String> allWordsWithPrefix(String prefix) {
        Node trieNode = root;
        List<String> allWords = new ArrayList<>();

        for (int i = 0; i < prefix.length(); ++i) {
            char c = prefix.charAt(i);
            int asciiIndex = c - 'a';
            trieNode = trieNode.getChild(asciiIndex);
        }
        collect(trieNode, prefix, allWords);
        return allWords;
    }

    public String longestCommonPrefix() {
        Node trieNode = root;
        String longestCommonPrefix = "";

        while (countNumOfChildren(trieNode) == 1 && !trieNode.isLeaf()) {
            trieNode = trieNode.getChild(indexOfSingleChild);
            longestCommonPrefix = longestCommonPrefix + String.valueOf((char) (indexOfSingleChild + 'a'));
        }

        return longestCommonPrefix;
    }

    private int countNumOfChildren(Node trieNode) {
        int numOfChildren = 0;
        for (int i = 0; i < trieNode.getChildren().length; i++) {
            if (trieNode.getChild(i) != null) {
                numOfChildren++;
                indexOfSingleChild = i;
            }
        }
        return numOfChildren;
    }

    private void collect(Node node, String prefix, List<String> allWords) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            allWords.add(prefix);
        }

        for (Node childNode : node.getChildren()) {
            if (childNode == null) continue;
            String childCharacter = childNode.getCharacter();
            collect(childNode, prefix + childCharacter, allWords);
        }
    }

}
