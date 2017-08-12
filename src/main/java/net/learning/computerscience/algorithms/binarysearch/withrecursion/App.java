package net.learning.computerscience.algorithms.binarysearch.withrecursion;

public class App {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,4,5,8,9,10};
        int p = 0;
        int r = a.length - 1;
        int x = 2;
        System.out.println(binarySearch(a, p, r, x));
    }

    private static int binarySearch(int[] a, int p, int r, int x) {
        System.out.println("[ " + p + " ... " + r + " ]");
        if (p > r) {
            return -1;
        } else {
            int q = (p + r) / 2;
            if (x < a[q]) {
                return binarySearch(a, p, q - 1, x);
            } else if (x > a[q]) {
                return binarySearch(a, q + 1, r, x);
            } else {
                return q;
            }
        }
    }

}
