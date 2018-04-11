package net.learning.computerscience.datastructures.topic_1_arrays.geeks_for_geeks.set1_rotations.p9_find_rotation_count_of_sorted_array;

/**
 * http://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        int pivot = findPivot(arr, 0, arr.length - 1);
        int rotations = pivot == arr.length - 1 ? 0 : pivot + 1;
        System.out.println("pivot -- > " + pivot + " rotations --> " + rotations);

        arr = new int[]{21, 2, 3, 6, 12, 15, 16, 17, 18, 19, 20};
        pivot = findPivot(arr, 0, arr.length - 1);
        rotations = pivot == arr.length - 1 ? 0 : pivot + 1;
        System.out.println("pivot -- > " + pivot + " rotations --> " + rotations);

        arr = new int[]{21, 22, 2, 3, 6, 12, 15, 16, 17, 18, 19, 20};
        pivot = findPivot(arr, 0, arr.length - 1);
        rotations = pivot == arr.length - 1 ? 0 : pivot + 1;
        System.out.println("pivot -- > " + pivot + " rotations --> " + rotations);

        arr = new int[]{6, 12, 15, 16, 17, 18, 19, 20, 21, 22, 2, 3};
        pivot = findPivot(arr, 0, arr.length - 1);
        rotations = pivot == arr.length - 1 ? 0 : pivot + 1;
        System.out.println("pivot -- > " + pivot + " rotations --> " + rotations);

        arr = new int[]{19, 20, 21, 22, 2, 3, 6, 12, 15, 16, 17, 18};
        pivot = findPivot(arr, 0, arr.length - 1);
        rotations = pivot == arr.length - 1 ? 0 : pivot + 1;
        System.out.println("pivot -- > " + pivot + " rotations --> " + rotations);

        arr = new int[]{20, 21, 22, 2, 3, 6, 12, 15, 16, 17, 18, 19};
        pivot = findPivot(arr, 0, arr.length - 1);
        rotations = pivot == arr.length - 1 ? 0 : pivot + 1;
        System.out.println("pivot -- > " + pivot + " rotations --> " + rotations);

        arr = new int[]{2, 3, 6, 12, 15, 16, 17, 18, 19, 20, 21, 22};
        pivot = findPivot(arr, 0, arr.length - 1);
        rotations = pivot == arr.length - 1 ? 0 : pivot + 1;
        System.out.println("pivot -- > " + pivot + " rotations --> " + rotations);

    }

    static int findPivot(int[] arr, int from, int to) {
        int diff = to - from;
        if (diff == 1) return from;

        int middle = (to + from) / 2;
        if (arr[middle] < arr[from]) return findPivot(arr, from, middle);
        if (arr[middle] > arr[to]) return findPivot(arr, middle, to);
        return to;
    }

}
