package net.learning.computerscience.algorithms.binarysearch;

public class App {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,3,5,6,7,9,12}, 4));
    }

    private static int binarySearch(int[] a, int x) {
        int p = 0;
        int r = a.length - 1;

        while (p <= r) {
            int q = (p + r) / 2;
            if (x < a[q]) {
                r = q - 1;
            } else if (x > a[q]) {
                p = q + 1;
            } else {
                return q;
            }
        }
        return -1;
    }

}
