package net.learning.computerscience.datastructures.trees.hacker_rank.p4_height_of_a_binary_tree;

import net.learning.computerscience.datastructures.trees.hacker_rank.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = new Node();
        while(t-- > 0){
            int data = scan.nextInt();
            root = root.insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }

    static int height(Node root) {
        List<Integer> heightsList = new ArrayList<>();
        heights(root, 0, heightsList);
        return getMaxHeight(heightsList);
    }

    static void heights(Node node, int height, List<Integer> heightsList) {
        if (node.left != null) heights(node.left, height + 1, heightsList);
        if (node.right != null) heights(node.right, height + 1, heightsList);
        if (node.left == null && node.right == null) heightsList.add(height);
    }

    static int getMaxHeight(List<Integer> heightsList) {
        int height = -1;
        for (int i = 0; i < heightsList.size(); i++) {
            if (heightsList.get(i) > height) height = heightsList.get(i);
        }
        return height;
    }

}