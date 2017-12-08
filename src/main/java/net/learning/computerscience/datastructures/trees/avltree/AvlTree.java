package net.learning.computerscience.datastructures.trees.avltree;

public class AvlTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {
        root = insertNode(root, data);
    }

    @Override
    public void traverse() {
        if (root == null) return;

        inOrderTraversal(root);
    }

    @Override
    public void delete(T data) {
        root = deleteNode(root, data);
    }

    private Node<T> insertNode(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChildNode(insertNode(node.getLeftChildNode(), data));
        } else {
            node.setRightChildNode(insertNode(node.getRightChildNode(), data));
        }

        node.setHeight(Math.max(height(node.getLeftChildNode()), height(node.getRightChildNode())) + 1);

        node = settleViolation(data, node);

        return node;
    }

    private Node<T> settleViolation(T data, Node<T> node) {
        int balance = getBalance(node);

        // This is the case 1 (left-left)
        if (balance > 1 && data.compareTo(node.getLeftChildNode().getData()) < 0) {
            return rightRotation(node);
        }

        // This is the case 1 (left-left)
        if (balance < -1 && data.compareTo(node.getRightChildNode().getData()) > 0) {
            return leftRotation(node);
        }

        // This is the case 3 (left-right)
        if (balance > 1 && data.compareTo(node.getLeftChildNode().getData()) > 0) {
            node.setLeftChildNode(leftRotation(node.getLeftChildNode()));
            return rightRotation(node);
        }

        // This is the case 4 (right-left)
        if (balance < -1 && data.compareTo(node.getRightChildNode().getData()) < 0) {
            node.setRightChildNode(rightRotation(node.getRightChildNode()));
            return leftRotation(node);
        }

        return node;
    }

    private Node<T> rightRotation(Node<T> node) {
        System.out.println("Rotating to the right on node: " + node);

        Node<T> tempLeftChildNode = node.getLeftChildNode();
        Node<T> t = tempLeftChildNode.getRightChildNode();

        tempLeftChildNode.setRightChildNode(node);
        node.setLeftChildNode(t);

        node.setHeight(Math.max(height(node.getLeftChildNode()), height(node.getRightChildNode())) + 1);
        tempLeftChildNode.setHeight(Math.max(height(tempLeftChildNode.getLeftChildNode()), height(tempLeftChildNode.getRightChildNode())) + 1);
        return tempLeftChildNode;
    }

    private Node<T> leftRotation(Node<T> node) {
        System.out.println("Rotating to the left on node: " + node);

        Node<T> tempRightChildNode = node.getRightChildNode();
        Node<T> t = tempRightChildNode.getLeftChildNode();

        tempRightChildNode.setLeftChildNode(node);
        node.setRightChildNode(t);

        node.setHeight(Math.max(height(node.getLeftChildNode()), height(node.getRightChildNode())) + 1);
        tempRightChildNode.setHeight(Math.max(height(tempRightChildNode.getLeftChildNode()), height(tempRightChildNode.getRightChildNode())) + 1);
        return tempRightChildNode;
    }

    private int height(Node<T> node) {
        if (node == null) return -1;
        return node.getHeight();
    }

    private int getBalance(Node<T> node) {
        if (node == null) return 0;
        return height(node.getLeftChildNode()) - height(node.getRightChildNode());
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChildNode() != null) {
            inOrderTraversal(node.getLeftChildNode());
        }

        System.out.println(node);

        if (node.getRightChildNode() != null) {
            inOrderTraversal(node.getRightChildNode());
        }
    }

    private Node<T> deleteNode(Node<T> node, T data) {
        if (node == null) return node;

        // first we have to look for the node we want to get rid of
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChildNode(deleteNode(node.getLeftChildNode(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChildNode(deleteNode(node.getRightChildNode(), data));
        } else {

            // This is the case 1
            if (node.getLeftChildNode() == null && node.getRightChildNode() == null) {
                System.out.println("Removing a leaf node...");
                return null;
            }

            // This is the case 2
            if (node.getLeftChildNode() == null) {
                System.out.println("Removing the right child...");
                Node<T> tempNode = node.getRightChildNode();
                node = null;
                return tempNode;
            } else if (node.getRightChildNode() == null) {
                System.out.println("Removing the left child...");
                Node<T> tempNode = node.getLeftChildNode();
                node = null;
                return tempNode;
            }

            // This is the case 3
            System.out.println("Removing item with two children...");
            Node<T> tempNode = getPredecessor(node.getLeftChildNode());

            node.setData(tempNode.getData());
            node.setLeftChildNode(deleteNode(node.getLeftChildNode(), tempNode.getData()));
        }

        node.setHeight(Math.max(height(node.getLeftChildNode()), height(node.getRightChildNode())) + 1);

        // We have to check on every deleteNode operation whether the trees has become unbalanced or not
        return settleDeletion(node);
    }

    private Node<T> settleDeletion(Node<T> node) {
        int balance = getBalance(node);

        // we know the trees is left heavy but it can be left-right heavy or left-left heavy
        if (balance > 1) {

            // left-right heavy situation: left rotation on parent + right rotation on grand parent
            if (getBalance(node.getLeftChildNode()) < 0) {
                node.setLeftChildNode(leftRotation(node.getLeftChildNode()));
            }

            // this is the rotation on the grand parent (if left-left heavy, only single right rotation is needed)
            return rightRotation(node);
        }

        // we know the trees is right heavy but it can be left-right heavy or right-right heavy
        if (balance < -1) {

            // right-left heavy situation: right rotation on parent + left rotation on grand parent
            if (getBalance(node.getRightChildNode()) > 0) {
                node.setRightChildNode(rightRotation(node.getRightChildNode()));
            }

            // this is the rotation on the grand parent (if right-right heavy, only single right rotation is needed)
            return leftRotation(node);
        }


        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRightChildNode() != null) {
            return getPredecessor(node.getRightChildNode());
        }
        return node;
    }

}
