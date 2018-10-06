package net.learning.computerscience.datastructures.topic_6_trees.topic_6_3_ternary_search_tree;

public class CompleteTernarySearchTree1 {

    private Node root;

    public Node insert(String word, int value) {
        root = insert(word, root, 0, value);
        return root;
    }

    public Integer get(String word) {
        Node node = get(word, root, 0);
        return node != null ? node.value : null;
    }

    private Node get(String word, Node current, int index) {
        if (current == null || index == word.length()) return null;
        char letter = word.charAt(index);
        if (letter < current.letter) {
            return get(word, current.first, index);
        } else if (letter > current.letter) {
            return get(word, current.third, index);
        }
        return (index == word.length() - 1) ? current : get(word, current.second, index + 1);
    }

    private Node insert(String word, Node current, int index, int value) {
        char letter = word.charAt(index);
        if (current == null) {
            current = new Node(letter);
        }

        if (letter < current.letter) {
            current.first = insert(word, current.first, index, value);
        } else if (letter > current.letter) {
            current.third = insert(word, current.third, index, value);
        } else if (index < word.length() - 1) {
            current.second = insert(word, current.second, index + 1, value);
        } else {
            current.value = value;
        }
        return current;
    }

}

class Node {
    char letter;
    Node first;
    Node second;
    Node third;
    int value;

    public Node(char letter) {
        this.letter = letter;
    }
}
