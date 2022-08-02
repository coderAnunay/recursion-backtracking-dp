package com.anunay.recursion.leetcode;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated
 * at an unknown pivot index k (1 <= k < nums.length) such that the
 * resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class Problem33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int index = search(nums, target);
        System.out.println(index);
        target = 9;
        index = search(nums, target);
        System.out.println(index);
    }

    public static int search(int[] nums, int target) {
        return rotatedBS(nums, target, 0, nums.length-1);
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
                return rotatedBS(arr, key, start, mid - 1);
            }

            // Left half is SORTED but Key is NOT in left half so search in right half
            return rotatedBS(arr, key, mid+1, end);
        }

        // Case 3: If left half is NOT sorted, the right half must be so then search in right half
        if (key > arr[mid] && key <= arr[end]) {
            // Key is in right half so search it
            return rotatedBS(arr, key, mid + 1, end);
        }

        // Search in left half
        return rotatedBS(arr, key, start, mid-1);
        }
}
