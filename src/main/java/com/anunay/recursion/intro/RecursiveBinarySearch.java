package com.anunay.recursion.intro;

public class RecursiveBinarySearch {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        int target = 8;
        int index = binarySearch(input, target, 0, input.length - 1);
        if (index != -1) {
            System.out.println("Element " + target + " found at index: " + index);
        } else {
            System.out.println("Element " + target + " not found!");
        }
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start)/2;
        if (target > arr[mid]) {
            return binarySearch(arr, target, mid + 1, end);
        } else if (target < arr[mid]) {
            return binarySearch(arr, target, start, mid - 1);
        } else {
            return mid;
        }
    }
}
