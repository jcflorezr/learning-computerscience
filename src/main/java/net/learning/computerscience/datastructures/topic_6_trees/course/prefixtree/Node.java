package net.learning.computerscience.datastructures.topic_6_trees.course.prefixtree;

public class Node {

    private String character;
    private Node[] children;
    private boolean leaf;
    private boolean visited;
    private int value;

    public Node(String character) {
        this.character = character;
        children = new Node[Constant.ALPHABET_SIZE];
    }

    public void setChild(int index, Node node, int value) {
        node.setValue(value);
        this.children[index] = node;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.character;
    }

    public Node getChild(int index) {
        return children[index];
    }
}