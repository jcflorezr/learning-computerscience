package net.learning.computerscience.exercises.q_3_union_and_intersection;

/**
 * from: http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
 *
 * Given two sorted arrays, find their union and intersection.
 * Example:Input:
 * arr1[] = {1, 3, 4, 5, 7}
 * arr2[] = {2, 3, 5, 6}
 * Output:
 * Union : {1, 2, 3, 4, 5, 6, 7}
 * Intersection : {3, 5}
 *
 */
public class UnionAndIntersection {

    static int printUnion(int arr1[], int arr2[], int m, int n)
    {
        int i = 0, j = 0;
        while (i < m && j < n)
        {
            if (arr1[i] < arr2[j])
                System.out.print(arr1[i++]+" ");
            else if (arr2[j] < arr1[i])
                System.out.print(arr2[j++]+" ");
            else
            {
                System.out.print(arr2[j++]+" ");
                i++;
            }
        }

      /* Print remaining elements of
         the larger arrays */
        while(i < m)
            System.out.print(arr1[i++]+" ");
        while(j < n)
            System.out.print(arr2[j++]+" ");

        return 0;
    }

    static void printIntersection(int arr1[], int arr2[], int m, int n)
    {
        int i = 0, j = 0;
        while (i < m && j < n)
        {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr1[i])
                j++;
            else
            {
                System.out.print(arr2[j++]+" ");
                i++;
            }
        }
    }

    public static void main(String args[])
    {
        int arr1[] = {1, 2, 4, 5, 6};
        int arr2[] = {2, 3, 5, 7};
        int m = arr1.length;
        int n = arr2.length;
        printUnion(arr1, arr2, m, n);
        System.out.println();
        printIntersection(arr1, arr2, m, n);
    }

}
