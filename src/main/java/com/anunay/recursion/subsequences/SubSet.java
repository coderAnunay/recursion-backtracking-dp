package com.anunay.recursion.subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.format("All subsets of %s: %s\n", Arrays.toString(arr), getSubSets(arr));

        int[] arr2 = {2, 1, 2};
        System.out.format("All unique subsets of %s: %s", Arrays.toString(arr2), subsetWithoutDuplicates(arr2));
    }

    /**
     * Iterative method to return all subsets of an array
     */
    static List<List<Integer>> getSubSets(int[] arr) {
        // First create a list that will hold the different subsequences,
        // which are list of integers
        List<List<Integer>> outer = new ArrayList<>();

        // As we start with an empty list, therefore add it to outer list
        outer.add(new ArrayList<>());

        // For every number in given array
        for (int num: arr) {
            // Get the size of outer list
            int size = outer.size();

            // for every number from array, we will either accept it or reject it in recursion
            // so here we need to add this number to every individual list in outer
            // for e.g adding "1" to [] --> {[], [1]}
            // adding "2" to {[], [1]} --> {[], [1], [2], [1,2]}
            // adding "3" to {[], [1], [2], [1,2]} --> {[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]}
            for (int i = 0; i < size; i++) {
                // Get the ith list from outer
                List<Integer> internal = new ArrayList<>(outer.get(i));
                // Add "num" element to the internal list from outer
                internal.add(num);
                // Add this new internal list to outer
                outer.add(internal);
            }
        }
        return outer;
    }

    /**
     * Iterative method to return all subsets of an array
     */
    static List<List<Integer>> subsetWithoutDuplicates(int[] arr) {
        // First sort the array so that duplicates are together
        Arrays.sort(arr);

        // First create a list that will hold the different subsequences,
        // which are list of integers
        List<List<Integer>> outer = new ArrayList<>();

        // As we start with an empty list, therefore add it to outer list
        outer.add(new ArrayList<>());

        int start = 0;
        int end = 0;

        // For every number in given array
        for (int idx = 0; idx < arr.length; idx++) {
            start = 0;
            // if current and previous element are same, then start = end + 1
            if (idx > 0 && arr[idx] == arr[idx-1]) {
                start = end + 1;
            }
            end = outer.size() - 1;

            // Get the size of outer list
            int size = outer.size();

            // for every number from array, we will either accept it or reject it in recursion
            // so here we need to add this number to every individual list in outer
            // for e.g adding "1" to [] --> {[], [1]}
            // adding "2" to {[], [1]} --> {[], [1], [2], [1,2]}
            // adding "3" to {[], [1], [2], [1,2]} --> {[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]}
            for (int i = start; i < size; i++) {
                // Get the ith list from outer
                List<Integer> internal = new ArrayList<>(outer.get(i));
                // Add "num" element to the internal list from outer
                internal.add(arr[idx]);
                // Add this new internal list to outer
                outer.add(internal);
            }
        }
        return outer;
    }
}
