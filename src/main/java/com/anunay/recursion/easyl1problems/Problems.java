package com.anunay.recursion.easyl1problems;

public class Problems {

    public static void main(String[] args) {
        // Problem 1
        System.out.println("***Problem 1***");
        p1(5);

        // Problem 2
        System.out.println("\n***Problem 2***");
        p2(5);

        // Problem 3
        System.out.println("\n***Problem 3***");
        p3(5);

        // Problem 4
        System.out.println("\n***Problem 4***");
        int factorial = fact(5);
        System.out.println("Factorial of 5: " + factorial);

        // Problem 5
        System.out.println("\n***Problem 5***");
        int sum = sumOfn(5);
        System.out.println("Sum of first 5 natural numbers: " + sum);

        // Problem 6
        System.out.println("\n***Problem 6***");
        sum = sumOfDigits(1342);
        System.out.println("Sum of digits of 1342: " + sum);

        // Problem 7
        System.out.println("\n***Problem 7***");
        int product = productOfDigits(1342);
        System.out.println("Product of digits of 1342: " + product);

        // Problem 8.1
        System.out.println("\n***Problem 8: Method 1***");
        reversenumberWay1(1234);
        System.out.println("Reverse of digits of 1234 using method one: " + Problems.sum);

        // Problem 8.2
        System.out.println("\n***Problem 8: Method 2***");
        int reverse = reversenumberWay2(1234);
        System.out.println("Reverse of digits of 1234 using method two: " + reverse);

        // Problem 9.1
        System.out.println("\n***Problem 9: Method 1***");
        System.out.println("is 1001 a palindrome?: " + isPalindrome(1001));
        System.out.println("is 1234 a palindrome?: " + isPalindrome(1234));

        // Problem 9.2
        System.out.println("\n***Problem 9: Method 2***");
        System.out.println("is 1001 a palindrome?: " + isPalindromeMethod2(1001));
        System.out.println("is 1234 a palindrome?: " + isPalindromeMethod2(1234));

        // Problem 10.1
        System.out.println("\n***Problem 10: Method 1***");
        System.out.println("Number of 0s in 430207: " + countZeroesMethod1(430207, 0));
        System.out.println("Number of 0s in 86754: " + countZeroesMethod1(86754, 0));

        // Problem 10.2
        System.out.println("\n***Problem 10: Method 2***");
        System.out.println("Number of 0s in 430207: " + countZeroesMethod2(430207));
        System.out.println("Number of 0s in 86754: " + countZeroesMethod2(86754));
    }

    /**
     *  Given an integer "n" print all values from n to 1
     */
    static void p1(int n) {
        if (n == 0) return;
        System.out.print(n + ", ");
        p1(n-1);
    }

    /**
     *  Given an integer "n" print all values from 1 to n
     */
    static void p2(int n) {
        if (n == 0) return;
        p2(n-1);
        System.out.print(n + ", ");
    }

    /**
     *  Given an integer "n" print all values from n to 1 and 1 to n
     */
    static void p3(int n) {
        p1(n);
        p2(n);
    }
    /**
     * Alternatively the above problem is basically performing
     * a combo of both p1 and p2,
     *
     *  static void p3(int n) {
     *      if (n == 0) {
     *          return;
     *      }
     *      System.out.println(n + ", ");
     *      p3(n-1);
     *      System.out.println(n + ", ");
     *  }
     */

    /**
     * Factorial of n
     */
    static int fact(int n) {
        if (n == 1) return 1;
        return n * fact(n-1);
    }

    /**
     * Sum of first n natural numbers
     */
    static int sumOfn(int n) {
        if (n == 1) return 1;
        return n + sumOfn(n-1);
    }

    /**
     * Sum of digits of a number n
     * 1003 = 1 + 0 + 0 + 3 = 4
     */
    static int sumOfDigits(int n) {
        if (n == 0) return 0;
        return (n % 10) + sumOfDigits(n/10);
    }

    /**
     * Product of digits of a number n
     * 1342 = 1 * 3 * 4 * 2 = 24
     */
    static int productOfDigits(int n) {
        if (n % 10 == n) return n;
        return (n % 10) * productOfDigits(n/10);
    }

    /**
     * Given an integer n, reverse it
     * 1234 ==> 4321
     */
    // A variable to store and update the result
    private static int sum = 0;

    static void reversenumberWay1(int n) {
        if (n == 0) {
            return;
        }
        int remainder = n % 10;
        sum = sum * 10 + remainder;
        reversenumberWay1(n/10);
    }

    /**
     * Sometimes you might need some additional variables in the argument
     * In that case, make use of another helper function to carry out actual recursion
     */
    static int reversenumberWay2(int n) {
        // Shortcut to find the number of digits
        int digits = (int) (Math.log10(n)) + 1;
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if (n % 10 == n) return n;
        int remainder = n % 10;
        return remainder * ((int) Math.pow(10, digits - 1.0)) + helper(n/10, digits - 1);
    }

    /**
     *  Check if given number n is palindrome or not
     */
    static boolean isPalindrome(int n) {
       return n == reversenumberWay2(n);
    }

    /**
     * TODO: Convert the iterative approach of comparing numbers at indices from left and right to recursive approach
     */
    static boolean isPalindromeMethod2(int n) {
        String number = String.valueOf(n);
        return palindromeHelper(number, 0, number.length() - 1);
    }

    private static boolean palindromeHelper(String number, int start, int end) {
        while (start < end) {
            if (number.charAt(start++) != number.charAt(end--))
                return false;
        }
        return true;
    }

    /**
     *  Count the number of zeroes in a number Method1
     */
    static int countZeroesMethod1(int n, int count) {
        if (n % 10 == n) {
            if (n == 0) count++;
            /*
            In these kinds of problems, the value returned in the base condition
            is the final value returned
             */
            return count;
        }
        int rem = n % 10;
        if (rem == 0) return countZeroesMethod1(n / 10, ++count);
        else return countZeroesMethod1(n / 10, count);
    }

    /**
     *  Count the number of zeroes in a number Method2
     */
    static int countZeroesMethod2(int n) {
        return helper2(n, 0);
    }

    private static int helper2(int n, int c) {
        if (n == 0) {
            /*
            In these kinds of problems, the value returned in the base condition
            is the final value returned
             */
            return c;
        }
        int rem = n % 10;
        if (rem == 0) return helper2(n/10, c+1);
        else return countZeroesMethod1(n/10, c);
    }
}
