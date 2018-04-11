package net.learning.computerscience.datastructures.topic_2_matrices.geeks_for_geeks.summary.p3_a_boolean_matrix_question;

/**
 * http://www.geeksforgeeks.org/a-boolean-matrix-question/
 */
public class Solution {

    public static void main(String[] args) {
        int mat[][] = {{1, 0, 0, 1},
                       {0, 0, 1, 0},
                       {0, 0, 0, 0}};
        mat = modifyingColumns(mat, 0, 1);
        modifyingRows(mat, 1, 0);
    }

    private static int[][] modifyingColumns(int[][] mat, int i, int j) {
        if (j == mat[0].length) return mat;
        if (i == 0) {
            if (mat[i][j] == 1) {
                i++;
            }
        } else if (i == mat.length) {
            j++;
        } else {
            mat[i++][j] = 1;
        }
        return modifyingColumns(mat, i, j);
    }

    private static int[][] modifyingRows(int[][] mat, int i, int j) {

        return new int[0][];
    }

}
