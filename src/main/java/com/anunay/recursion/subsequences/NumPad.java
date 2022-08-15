package com.anunay.recursion.subsequences;

import java.util.ArrayList;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * 1 -> abc
 * 2 -> def
 * 3 -> ghi
 * 4 -> jkl
 * 5 -> mno
 * 6 -> pqr
 * 7 -> stu
 * 8 -> vwx
 * 9 -> yz
 *
 * Example 1:
 * Input: digits = "12"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 * Input: digits = ""
 * Output: []
 *
 * Example 3:
 * Input: digits = "2"
 * Output: ["d","e","f"]
 *
 * Constraints:
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class NumPad {

    public static void main(String[] args) {
        String pad1 = "12";
        String pad2 = "";
        String pad3 = "234";
        String pad4 = "2";

        System.out.println("Combinations for " + pad1 + ":");
        printCombinations(pad1, "");
        System.out.println();
        System.out.println();
        System.out.println("Combinations for " + pad2 + ":");
        printCombinations(pad2, "");
        System.out.println();
        System.out.println();
        System.out.println("Combinations for " + pad3 + ":");
        printCombinations(pad3, "");
        System.out.println();
        System.out.println();
        System.out.println("Combinations for " + pad4 + ":");
        printCombinations(pad4, "");
        System.out.println();
        System.out.println();
        System.out.println("Combination list for: " + pad1 + ": " + getCombinationList(pad1, ""));
        System.out.println("Combination list for: " + pad2 + ": " + getCombinationList(pad2, ""));
        System.out.println("Combination list for: " + pad3 + ": " + getCombinationList(pad3, ""));
        System.out.println("Combination list for: " + pad4 + ": " + getCombinationList(pad4, ""));
        System.out.println("Number of combinations for string: " + pad1 + ": " + countCombinations(pad1, ""));
        System.out.println("Number of combinations for string: " + pad2 + ": " + countCombinations(pad2, ""));
        System.out.println("Number of combinations for string: " + pad3 + ": " + countCombinations(pad3, ""));
        System.out.println("Number of combinations for string: " + pad4 + ": " + countCombinations(pad4, ""));
    }

    /**
     *
     * @param given
     * @param processed
     *
     * Prints all combinations
     */
    static void printCombinations(String given, String processed) {
        // Base condition: when the given string is empty
        if (given.isEmpty()) {
            System.out.println(processed);
            return;
        }

        // Get the digit as an int
        int digit = given.charAt(0) - '0';

        // Run for loop for the range [(digit-1)*3, digit*3)
        for (int i = (digit-1)*3; i < (digit*3); i++) {
            // Condition to handle 9 -> yz
            if(i == 26) return;
            // Get the character represented by the digit
            char current = (char) ('a' + i);
            // Recursion call with updating processed string
            printCombinations(given.substring(1), current + processed);
        }
    }

    /**
     * Return all combinations in an ArrayList
     */
    static ArrayList<String> getCombinationList(String given, String processed) {
        // Create a new local ArrayList
        ArrayList<String> combinationList = new ArrayList<>();

        // Base condition: If given string is empty, add the processed string
        // to the local list and return
        if (given.isEmpty()) {
            combinationList.add(processed);
            return combinationList;
        }

        // Get the digit as an int
        int digit = given.charAt(0) - '0';

        // Run for loop for the range [(digit-1)*3, digit*3)
        for (int i = (digit-1)*3; i < (digit*3); i++) {
            // Condition to handle 9 -> yz
            if(i == 26) return combinationList;
            // Get the character represented by the digit
            char current = (char) ('a' + i);
            // Recursion call with adding the subsequent recursions to the local list
            combinationList.addAll(getCombinationList(given.substring(1), current + processed));
        }
        return combinationList;
    }

    /**
     * Counting the combiantions
     */
    static int countCombinations(String given, String processed) {
        // Local variable to count the strings for this method call
        int count = 0;

        // Base condition: If given string is empty, return count as 1
        // as we have found one answer
        if (given.isEmpty()) {
            // To handle empty string input
            if (processed.isEmpty()) return 0;
            else return 1;
        }

        // Get the digit as an int
        int digit = given.charAt(0) - '0';

        // Run for loop for the range [(digit-1)*3, digit*3)
        for (int i = (digit-1)*3; i < (digit*3); i++) {
            // Condition to handle 9 -> yz
            if(i == 26) return count;
            // Get the character represented by the digit
            char current = (char) ('a' + i);
            // Recursion call with adding the subsequent recursions to the local count variable
            count += countCombinations(given.substring(1), current + processed);
        }
        return count;
    }
}
