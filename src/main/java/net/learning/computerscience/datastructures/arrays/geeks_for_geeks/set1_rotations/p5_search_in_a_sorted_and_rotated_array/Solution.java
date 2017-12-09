package net.learning.computerscience.datastructures.arrays.geeks_for_geeks.set1_rotations.p5_search_in_a_sorted_and_rotated_array;

/**
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class Solution {

    public static void main(String args[]) {
        int arr[] = {9,10,11,12,13,14,1,2,3,4,5,6,7,8};
        int key = 7;
        int pivot = findPivot(arr, 0, 1);
        if (pivot == -1) System.out.println("Array seems not to be rotated");
        else if (arr[pivot] == key) System.out.println(pivot);
        else {
            int idx = pivot == 0 ? findKey(arr, pivot + 1, arr.length, key)
                                 : key >= arr[0] ? findKey(arr, 0, pivot - 1, key)
                                                : findKey(arr, pivot + 1, arr.length, key);
            System.out.println(idx);
        }
    }

    private static int findPivot(int[] arr, int idx, int times) {
        int nextIdx = idx + 1 == arr.length ? 0 : idx + 1;
        if (times == arr.length) return -1;
        if (arr[idx] > arr[nextIdx]) return idx;
        return findPivot(arr, idx + 1, times + 1);
    }

    private static int findKey(int[] array, int from, int to, int key) {
        int diff = to - from;
        if (diff == 0) return key == array[to] ? to : -1;
        int center = (from + to) / 2;
        if (array[center] == key) return center;
        if (key < array[center]) return findKey(array, from, center - 1, key);
        return findKey(array, center + 1, to, key);
    }

}
