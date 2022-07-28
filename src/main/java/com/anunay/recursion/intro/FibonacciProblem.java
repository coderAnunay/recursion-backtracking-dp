package com.anunay.recursion.intro;

/**
 * Given an integer "n", calculate the nth Fibonacci number
 * Consider "0" as the "0th" Fibonacci number
 */
public class FibonacciProblem {

    public static void main(String[] args) {
        int n = 0;
        int ans = fib(n); // should return "8" --> 0, 1, 1, 2, 3, 5, 8
        System.out.println(n + "th fibonacci number is: " + ans);
    }

    static int fib(int n) {
        // Base condition for 0th, 1st and 2nd Fibonacci numbers
        if (n < 2) {
            return n;
        }
        // Recurrence
        return fib(n-1) + fib(n-2);
    }
}
