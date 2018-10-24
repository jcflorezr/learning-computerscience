package net.learning.computerscience.algorithms.backtracking.p2_n_queens_problem;

import java.util.Objects;

public class Solution {

    public static Pair[] placeQueens(int numQueens) {
        Pair[] queensPos = new Pair[numQueens];
        placeQueens(safeSlot(0, 0, queensPos), 0, queensPos);
        return queensPos;
    }

    private static boolean placeQueens(int x, int y, Pair[] queensPos) {
        if (queensPos[queensPos.length - 1] != null)
            return true;
        if (x < 0) return false;
        queensPos[y] = new Pair(x, y);
        boolean isPlaced = placeQueens(safeSlot(0, y + 1, queensPos), y + 1, queensPos);
        if (!isPlaced) {
            queensPos[y] = null;
            return placeQueens(safeSlot(x + 1, y, queensPos), y, queensPos);
        }
        return true;
    }

    private static int safeSlot(int x, int y, Pair[] queensPos) {
        if (queensPos[0] == null) return x;
        boolean isSafe = false;
        for (; x < queensPos.length; x++) {
            for (int n = y - 1; n >= 0; n--) {
                Pair pos = queensPos[n];
                if ((pos.x == x) || Math.abs(pos.x - x) == Math.abs(pos.y - y)) {
                    isSafe = false;
                    break;
                } else {
                    isSafe = true;
                }
            }
            if (isSafe) break;
        }
        return x == queensPos.length ? -1 : x;
    }

}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x &&
                y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}