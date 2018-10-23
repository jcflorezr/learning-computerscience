package net.learning.computerscience.algorithms.backtracking.p1_rat_in_a_maze;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Solution {

    public static Deque<Pair> getMazePath(char[][] maze, Pair start, Pair end) {
        Deque<Pair> path = new ArrayDeque<>();
        getPath(maze, start.x, start.y, path, end);
        return path;
    }

    private static boolean getPath(char[][] maze, int x, int y, Deque<Pair> path, Pair end) {
        Pair prev = path.pollFirst();
        if (prev != null) {
            Pair prevPrev = path.peekFirst();
            path.addFirst(prev);
            if (prevPrev != null && x == prevPrev.x && y == prevPrev.y) {
                path.addFirst(new Pair(x, y));
                return false;
            }
        }
        path.addFirst(new Pair(x, y));
        if (x < 0 || y < 0) return false;
        if (x == maze.length || y == maze[0].length) return false;
        if (maze[x][y] == 'x') return false;
        if (x == end.x && y == end.y) return true;
        boolean isValid = getPath(maze, x, y + 1, path, end);
        if (!isValid) path.pollFirst();
        isValid = !isValid ? getPath(maze, x + 1, y, path, end) : isValid;
        if (!isValid) path.pollFirst();
        isValid = !isValid ? getPath(maze, x - 1, y, path, end) : isValid;
        if (!isValid) path.pollFirst();
        isValid = !isValid ? getPath(maze, x, y - 1, path, end) : isValid;
        if (!isValid) path.pollFirst();
        return isValid;
    }

}


class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
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