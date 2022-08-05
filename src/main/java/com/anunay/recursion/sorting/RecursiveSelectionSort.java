package com.anunay.recursion.sorting;

import java.util.Arrays;

public class RecursiveSelectionSort {

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        recursiveSelectionSort(arr.length, 0, 0, arr);
        System.out.println("After sorting: " + Arrays.toString(arr));

        int[] arr2 = {12, 17, 2, 0, 76, 123, 98, 56, 71};
        recursiveSelectionSort(arr2.length, 0, 0, arr2);
        System.out.println("After sorting: " + Arrays.toString(arr2));
    }

    static void recursiveSelectionSort(int lastIndex, int currIndex, int currMaxIndex, int[] arr) {
        // Base Condition
        if(lastIndex == 0) return;
        if (currIndex < lastIndex) {
            // Check if the currIndex elem is greater than currMax element
            if (arr[currIndex] > arr[currMaxIndex]) {
                // currMaxIndex updated
                recursiveSelectionSort(lastIndex, currIndex+1, currIndex, arr);
            } else {
                // Proceed to next index (currMaxIndex stays same)
                recursiveSelectionSort(lastIndex, currIndex+1, currMaxIndex, arr);
            }
        } else {
            // Swap currMax with lastIndex element and proceed to next sub-array
            swap(currMaxIndex, lastIndex-1, arr);
            recursiveSelectionSort(lastIndex-1, 0, 0, arr);
        }
    }

    private static void swap(int currMaxIndex, int lastIndex, int[] arr) {
        // Swap
        int temp = arr[currMaxIndex];
        arr[currMaxIndex] = arr[lastIndex];
        arr[lastIndex] = temp;
    }
}
