package net.learning.computerscience.datastructures.tree.avltree.a_myown;

public class MyAVLTree<T extends Comparable<T>> {

    private Node<T> root;

    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else if (data != null) {
            insert(root, data);
        }
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node != null) {
            if (data.compareTo(node.getData()) <= 0) {
                node.setLeftNode(insert(node.getLeftNode(), data));
            } else {
                node.setRightNode(insert(node.getRightNode(), data));
            }
            node.setHeight();
            balanceSubtree(node, data);
            return node;
        } else {
            return new Node<>(data);
        }
    }

    public void remove(T data) {
        if (root != null && data != null) {
            remove(root, data);
        }
    }

    private Node<T> remove(Node<T> node, T data) {

        if (node == null) return node;

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftNode(remove(node.getLeftNode(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightNode(remove(node.getRightNode(), data));
        } else {

            if (node.getLeftNode() == null && node.getRightNode() == null) {
                return null;
            }

            if (node.getLeftNode() == null) {
                return node.getRightNode();
            } else if (node.getRightNode() == null) {
                return node.getLeftNode();
            }

            Node<T> tempNode = getSucessor(node.getRightNode());
            node.setData(tempNode.getData());
            node.setRightNode(remove(node.getRightNode(), tempNode.getData()));

        }

        return node;
    }

    private Node<T> getSucessor(Node<T> node) {
        if (node.getLeftNode() != null) {
            return getSucessor(node.getLeftNode());
        }
        return node;
    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRightNode() != null) {
            return getPredecessor(node.getRightNode());
        }
        return node;
    }

    private void balanceSubtree(Node<T> node, T data) {

        int leftNodeHight = node.getLeftNode() == null ? -1 : node.getLeftNode().getHeight();
        int rightNodeHeight = node.getRightNode() == null ? -1 : node.getRightNode().getHeight();

        boolean leftSubtreeIsUnbalanced = leftNodeHight - rightNodeHeight > 1;
        boolean rightSubtreeIsUnbalanced = leftNodeHight - rightNodeHeight < -1;

        boolean isDataGreaterThanUnbalancedLeftSubtreeRoot = data.compareTo(node.getLeftNode().getData()) > 0;
        boolean isDataLessThanUnbalancedLeftSubtreeRoot = data.compareTo(node.getLeftNode().getData()) < 0;

        boolean isDataGreaterThanUnbalancedRightSubtreeRoot = data.compareTo(node.getRightNode().getData()) > 0;
        boolean isDataLessThanUnbalancedRightSubtreeRoot = data.compareTo(node.getRightNode().getData()) < 0;


        // This is the heavy right unbalanced case
        if (rightSubtreeIsUnbalanced && isDataGreaterThanUnbalancedRightSubtreeRoot) {

        }

    }
}
