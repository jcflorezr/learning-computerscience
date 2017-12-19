package net.learning.computerscience.datastructures.topic2_matrices.geeks_for_geeks.summary.p2_print_matrix_in_spiral_form;

/**
 * http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 */
public class Solution {

    public static void main(String[] args) {
        int mat[][] = {{1,  2,  3,  4,  5,  6},
                       {7,  8,  9,  10, 11, 12},
                       {13, 14, 15, 16, 17, 18}};
        int rowStart = 0;
        int rowEnd = mat.length;
        int colStart = 0;
        int colEnd = mat[0].length;
        Node spiral = spiralForm(mat, 1, rowStart, rowEnd, colStart, colEnd);

    }

    private static Node spiralForm(int[][] mat, int currCase, int rowStart, int rowEnd, int colStart, int colEnd) {
        return
    }

    private static Node spiralForm2(int[][] mat, int currCase, int rowStart, int rowEnd, int colStart, int colEnd, Node node) {
        if ((currCase % 2 == 0 && rowStart > rowEnd) || (currCase % 2 != 0 && colStart > colEnd)) return null;
        switch (currCase) {
            case 1:
                spiralForm(mat, 2, ++rowStart, rowEnd, colStart, --colEnd)
        }
        return null;
    }

}

class Node {
    int data;
    Node next;
}
