package com.anunay.recursion.leetcode;

/**
 * Given an integer num, return the number of steps to reduce it to zero.
 *
 * In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 */
public class Problem1342 {

    public static void main(String[] args) {
        int num = 14;
        System.out.println("Number of steps to reduce to 0: " + numberOfSteps(14));
    }

    public static int numberOfSteps(int num) {
        return helper(num, 0);
    }

    private static int helper(int n, int steps) {
        if (n == 0) return steps;
        if (n%2 == 0) return helper(n/2, steps+1);
        else return helper(n-1, steps+1);
    }
}
