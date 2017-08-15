package net.learning.computerscience.datastructures.tree.ternarysearchtree;

public class TernarySearchTree {

    private Node rootNode;

    public void put(String key, int value) {
        rootNode = put(rootNode, key, value, 0);
    }

    private Node put(Node node, String key, int value, int index) {

        char c = key.charAt(index);
        if (node == null) {
            node = new Node(c);
        }
        if (c < node.getCharacter()) {
            node.setLeftChild(put(node.getLeftChild(), key, value, index));
        } else if (c > node.getCharacter()) {
            node.setRightChild(put(node.getRightChild(), key, value, index));
        } else if (index < key.length() - 1) {
            node.setMiddleChild(put(node.getMiddleChild(), key, value, index + 1));
        } else {
            node.setValue(value);
        }
        return node;
    }

    public Integer get(String key) {
        Node node = get(rootNode, key, 0);
        if (node == null) {
            return null;
        }
        return node.getValue();
    }

    private Node get(Node node, String key, int index) {
        if (node == null) {
            return null;
        }
        char c = key.charAt(index);
        if (c < node.getCharacter()) {
            return get(node.getLeftChild(), key, index);
        } else if (c > node.getCharacter()) {
            return get(node.getRightChild(), key, index);
        } else if (index < key.length() - 1) {
            return get(node.getMiddleChild(), key, index + 1);
        } else {
            return node;
        }
    }

}
