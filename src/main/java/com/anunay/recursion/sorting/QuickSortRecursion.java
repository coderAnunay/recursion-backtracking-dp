package com.anunay.recursion.sorting;

import java.util.Arrays;

public class QuickSortRecursion {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int low, int high) {
        if (low >= high) return;
        // Initialize variables used for swapping and placing pivot at correct position
        int start = low;
        int end = high;
        int mid = start + (end - start)/2;
        int pivot = arr[mid];
        while (start <= end) {
            // To avoid swapping in case of array being already sorted
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            // Means violation found
            if (start <= end) {
                // swap if violation found
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        // Now sort the other two halves
        sort(arr, low, end);
        sort(arr, start, high);
    }
}
