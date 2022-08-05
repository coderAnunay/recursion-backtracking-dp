package com.anunay.recursion.sorting;

import java.util.Arrays;

public class RecursiveBubbleSort {

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        recursiveBubbleSort(3, 0, arr);
        System.out.println("After sorting: " + Arrays.toString(arr));

        int[] arr2 = {12, 17, 2, 0, 76, 123, 98, 56, 71};
        recursiveBubbleSort(arr2.length-1, 0, arr2);
        System.out.println("After sorting: " + Arrays.toString(arr2));
    }

    static void recursiveBubbleSort(int lastIndex, int currIndex, int[] arr) {
        // Base condition
        if (lastIndex == 0) return;
        if (currIndex < lastIndex) {
            // Check if elem at currIndex is larger than its next element
            if(arr[currIndex] > arr[currIndex+1]) {
                // Swap
                swap(currIndex, arr);
            }
            // Call for next currIndex
            recursiveBubbleSort(lastIndex, currIndex+1, arr);
        } else {
            // At this stage the largest element is at lastIndex
            // So call for lastIndex-1
            recursiveBubbleSort(lastIndex-1, 0, arr);
        }
    }

    private static void swap(int currIndex, int[] arr) {
        // Swap
        int temp = arr[currIndex];
        arr[currIndex] = arr[currIndex+1];
        arr[currIndex+1] = temp;
    }
}
