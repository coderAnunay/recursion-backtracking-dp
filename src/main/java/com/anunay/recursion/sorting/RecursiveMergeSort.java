package com.anunay.recursion.sorting;

import java.util.Arrays;

public class RecursiveMergeSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 3, 12, 6, 5};
        int[] ans = mergeSort(arr);
        System.out.println("Array after sorting: " + Arrays.toString(ans));
        System.out.println("Original array not altered: " + Arrays.toString(arr));
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println("Array after IN_PLACE sorting: " + Arrays.toString(arr));
    }

    static int[] mergeSort(int[] arr) {
        // Base condition
        if (arr.length == 1) return arr;

        // Find the mid index to divide the array
        int mid = arr.length/2;
        // Make recursive calls to further divide the arrays
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        // merge the array (out of place, i.e create new array and return)
        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {
        // Create new array to merge the two arrays passed in arguments
        int[] mix = new int[first.length + second.length];
        // Loop variables
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // There might be a case when one of the arrays still has more elements left
        // In that case simply append those elements to the merged array
        // Note: Only one of the following two loops will run
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        // return the merged array
        return mix;
    }

    // No need to return a new array as it is in-place sorting
    static void mergeSortInPlace(int[] arr, int start, int end) {
        // Base condition
        if (end - start == 1) return;
        // Mid index to help dividing array in place
        int mid = start + (end - start)/2;
        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        // Have to create a temporary array to store the sorted order for this recursive call
        int[] mix = new int[end - start];

        // Loop variables
        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j < end) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        // Now using the "mix" sorted order, sort the original array
        for (int l = 0; l < mix.length; l++) {
            arr[start + l] = mix[l];
        }
    }
}
