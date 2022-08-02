package com.anunay.recursion.arrayquestions;

import java.util.Arrays;

/**
 * Given an array check using Recursion if it is in strict ascending order
 */
public class CheckSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9, 17, 23};
        System.out.println("Is array " + Arrays.toString(arr) + " sorted?: " + isSorted(arr, 0));
        int[] arr2 = {1, 2, 8, 4, 9, 17, 23};
        System.out.println("Is array " + Arrays.toString(arr2) + " sorted?: " + isSorted(arr2, 0));
    }

    static boolean isSorted(int[] arr, int index) {
        // Base condition
        if (index == arr.length - 1) return true;
        return arr[index] < arr[index+1] && isSorted(arr, index+1);
    }
}
