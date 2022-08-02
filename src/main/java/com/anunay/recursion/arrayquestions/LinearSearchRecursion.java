package com.anunay.recursion.arrayquestions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implement recursive Linear Search
 */
public class LinearSearchRecursion {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9, 17, 23};
        int target = 23;
        System.out.println("Target element " + target + " found?: "
                + recursiveLinearSearch(arr, target, 0));
        System.out.println("Target element " + target + " found?: "
                + recursiveLinearSearchFromLast(arr, target, arr.length-1));

        int[] arr2 = {1, 2, 8, 4, 9, 17, 23};
        target = 55;
        System.out.println("Target element " + target + " found?: "
                + recursiveLinearSearch(arr2, target, 0));
        System.out.println("Target element " + target + " found?: "
                + recursiveLinearSearchFromLast(arr2, target, arr.length-1));

        int[] arr3 = {12, 19, 26, 89, 76, 100, 103, 55, 19, 12};
        ArrayList<Integer> arrayList = new ArrayList<>();
        target = 12;
        System.out.println("Target element " + target + " found at indices: "
                + findMultiple(arr3, target, 0, arrayList));

        arrayList.clear();
        target = 19;
        System.out.println("Target element " + target + " found at indices: "
                + findMultiple(arr3, target, 0, arrayList));

        arrayList.clear();
        target = 99;
        System.out.println("Target element " + target + " found at indices: "
                + findMultiple(arr3, target, 0, arrayList));

        // Find multiple without passing array list in argument
        target=12;
        System.out.println("Target element " + target + " found at indices: "
                + findMultiple(arr3, target, 0));

        target=19;
        System.out.println("Target element " + target + " found at indices: "
                + findMultiple(arr3, target, 0));

        target=99;
        System.out.println("Target element " + target + " found at indices: "
                + findMultiple(arr3, target, 0));
    }

    static boolean recursiveLinearSearch(int[] arr, int target, int index) {
        // Base condition
        if (index == arr.length) return false;
        return (arr[index] == target) || recursiveLinearSearch(arr, target, index+1);
    }

    static boolean recursiveLinearSearchFromLast(int[] arr, int target, int index) {
        //Base condition
        if (index == -1) return false;
        return (arr[index] == target) || recursiveLinearSearchFromLast(arr, target, index-1);
    }

    static ArrayList<Integer> findMultiple(int[] arr, int target, int index, ArrayList<Integer> list) {
        //Base condition
        if (index == arr.length) return list;
        if (arr[index] == target) {
            list.add(index);
        }
        return findMultiple(arr, target, index+1, list);
    }

    /**
     * VERY IMPORTANT: Return the array list without passing it into argument
     */
    static ArrayList<Integer> findMultiple(int[] arr, int target, int index) {
        // Initialize a new list
        ArrayList<Integer> list = new ArrayList<>();

        //Base condition
        if (index == arr.length) return list;
        if (arr[index] == target) {
            // Add into list object of THIS stack frame
            list.add(index);
        }
        // Add answers from corresponding function calls into THIS stack frame's list
        list.addAll(findMultiple(arr, target, index+1));
        return list;
    }
}
