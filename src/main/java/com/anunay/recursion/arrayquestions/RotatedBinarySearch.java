package com.anunay.recursion.arrayquestions;

public class RotatedBinarySearch {

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3};
        int key = 7;
        System.out.println("Key: " + key + ", found at index: "
                + rotatedBS(arr, key, 0, arr.length-1));
    }

    static int rotatedBS(int[] arr, int key, int start, int end) {
        // Base condition
        if (start > end) return -1;

        int mid = start + (end - start)/2;
        // Case 1: If key is equal to mid then simply return mid
        if (key == arr[mid]) return mid;

        // Case 2: If left half is sorted and the key is in left half of array, then search left half
        // If key is not in left half then search in right half
        if (arr[start] <= arr[mid]) {
            if (key >= arr[start] && key < arr[mid]) {
                // Left half is SORTED and Key is in left half so search it
                return rotatedBS(arr, key, start, mid-1);
            } else {
                // Left half is SORTED but Key is NOT in left half so search in right half
                return rotatedBS(arr, key, mid+1, end);
            }
        }

        // Case 3: If key is in right half then search it
        if (key > arr[mid] && key <= arr[end]) {
            // Key is in right half so search it
            return rotatedBS(arr, key, mid+1, end);
        } else {
            // Search in left half
            return rotatedBS(arr, key, start, mid-1);
        }
    }
}
