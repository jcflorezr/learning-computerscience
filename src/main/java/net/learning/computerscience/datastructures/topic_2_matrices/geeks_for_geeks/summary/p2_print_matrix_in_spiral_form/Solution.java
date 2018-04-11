package net.learning.computerscience.datastructures.topic_2_matrices.geeks_for_geeks.summary.p2_print_matrix_in_spiral_form;

/**
 * http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 */
public class Solution {

    public static void main(String[] args) {
        int mat[][] = {{1,  2,  3,  4,  5,  6},
                       {7,  8,  9,  10, 11, 12},
                       {13, 14, 15, 16, 17, 18}};
        print(mat);
        mat = new int[][]
                 {{9, 5, 8, 3, 4, 3},
                  {6, 1, 1, 1, 1, 1},
                  {5, 5, 6, 8, 2, 7},
                  {3, 1, 0, 4, 2, 0},
                  {8, 1, 2, 3, 9, 8},
                  {9, 2, 5, 7, 8, 9}};
        print(mat);
        mat = new int[][]
                {{9, 5, 8, 3, 4, 3},
                 {9, 2, 5, 7, 8, 9}};
        print(mat);
    }

    private static void print(int[][] mat) {
        int rowStart = 0;
        int rowEnd = mat.length - 1;
        int colStart = 0;
        int colEnd = mat[0].length - 1;
        Node spiral = spiralForm(mat, 1, rowStart, rowEnd, colStart, colEnd);
        while (spiral != null) {
            System.out.print(spiral.data + " -> ");
            spiral = spiral.next;
        }
        System.out.println();
    }

    private static Node spiralForm(int[][] mat, int currCase, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart > rowEnd || colStart > colEnd) return null;
        Node nextSetOfNodes = null;
        switch (currCase) {
            case 1:
                nextSetOfNodes = spiralForm(mat, 2, rowStart + 1, rowEnd, colStart, colEnd);
                break;
            case 2:
                nextSetOfNodes = spiralForm(mat, 3, rowStart, rowEnd, colStart, colEnd - 1);
                break;
            case 3:
                nextSetOfNodes = spiralForm(mat, 4, rowStart, rowEnd - 1, colStart, colEnd);
                break;
            case 4:
                nextSetOfNodes = spiralForm(mat, 1, rowStart, rowEnd, colStart + 1, colEnd);
                break;
        }
        return mergeWithNextSetOfNodes(mat, currCase, rowStart, rowEnd, colStart, colEnd, null, nextSetOfNodes);
    }

    private static Node mergeWithNextSetOfNodes(int[][] mat, int currCase, int rowStart, int rowEnd, int colStart, int colEnd, Node currentSetOfNodes, Node nextSetOfNodes) {
        currentSetOfNodes = new Node();
        if (currCase % 2 == 0) {
            currentSetOfNodes.data = (currCase == 2) ? mat[rowStart++][colEnd] : mat[rowEnd--][colStart];
        } else {
            currentSetOfNodes.data = (currCase == 1) ? mat[rowStart][colStart++] : mat[rowEnd][colEnd--];
        }
        if (rowStart > rowEnd || colStart > colEnd) {
            currentSetOfNodes.next = nextSetOfNodes;
        } else {
            currentSetOfNodes.next = mergeWithNextSetOfNodes(mat, currCase, rowStart, rowEnd, colStart, colEnd, currentSetOfNodes.next, nextSetOfNodes);
        }
        return currentSetOfNodes;
    }

}

class Node {
    int data;
    Node next;
}
