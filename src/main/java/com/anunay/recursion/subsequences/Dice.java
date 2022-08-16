package com.anunay.recursion.subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question asked in Amazon
 * Given a dice, in which ways can we form a particular sum S?
 * Note: This solution is not optimized. Use Dynamic Programming to achieve optimization
 */
public class Dice {
    public static void main(String[] args) {
        int target = 4;
        System.out.println("Possible outcomes to get sum: " + target + ": ");
        printCombinations("", target);
        System.out.println("List of possible combinations to get sum: " + target + ": " + getCombinationList("", target));
        System.out.println("Number of possible combinations to get sum: " + target + ": " + getCount("", target));

        target = 6;
        System.out.println("Possible outcomes to get sum: " + target + ": ");
        printCombinations("", target);
        System.out.println("List of possible combinations to get sum: " + target + ": " + getCombinationList("", target));
        System.out.println("Number of possible combinations to get sum: " + target + ": " + getCount("", target));

        System.out.println("**Variable Faces on the Dice**");
        target = 12;
        System.out.println("Possible outcomes to get sum: " + target + ": ");
        printCombinationsVariableDice("", target, 8);
        System.out.println("List of possible combinations to get sum: " + target + ": " + getCombinationListVariableDice("", target, 8));
        System.out.println("Number of possible combinations to get sum: " + target + ": " + getCountVariableDice("", target, 8));
    }

    /**
     * Prints all the combinations
     */
    static void printCombinations(String processed, int target){
        // Base condition: target is equal to 0, that means we have found an answer
        if (target == 0) {
            System.out.println(processed);
            return;
        }

        // Use a for loop to iterate over all possible numbers we can subtract from processed number
        for (int i = 1; i <= 6 && i <= target; i++) {
            printCombinations(processed + i, target - i);
        }
    }

    /**
     * Return all possible combinations in a list
     */
    static List<String> getCombinationList(String given, int target) {
        // Initialize a local list for this function call
        List<String> localList = new ArrayList<>();

        // Base condition: when target is equal to 0, means we have found an answer so add to local list
        if (target == 0) {
            localList.add(given);
            return localList;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            // Add the results of subsequent function calls to the local list
            localList.addAll(getCombinationList(given + i, target - i));
        }
        return localList;
    }

    /**
     * Count the possible combinations
     */
    static int getCount(String given, int target) {
        // Initialize a local variable for storing the count of this function call
        int count = 0;

        // Base condition: when target is equal to 0, means we have found an answer so return 1
        if (target == 0) {
            return 1;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            // Add the results of subsequent function calls to this count
            count += getCount(given + i, target - i);

        }
        // return the count to top level recursion calls
        return count;
    }

    /**
     * Dice with variable number of faces
     */
    /**
     * Prints all the combinations
     */
    static void printCombinationsVariableDice(String processed, int target, int faces){
        // Base condition: target is equal to 0, that means we have found an answer
        if (target == 0) {
            System.out.println(processed);
            return;
        }

        // Use a for loop to iterate over all possible numbers we can subtract from processed number
        for (int i = 1; i <= faces && i <= target; i++) {
            printCombinations(processed + i, target - i);
        }
    }

    /**
     * Return all possible combinations in a list
     */
    static List<String> getCombinationListVariableDice(String given, int target, int faces) {
        // Initialize a local list for this function call
        List<String> localList = new ArrayList<>();

        // Base condition: when target is equal to 0, means we have found an answer so add to local list
        if (target == 0) {
            localList.add(given);
            return localList;
        }

        for (int i = 1; i <= faces && i <= target; i++) {
            // Add the results of subsequent function calls to the local list
            localList.addAll(getCombinationList(given + i, target - i));
        }
        return localList;
    }

    /**
     * Count the possible combinations
     */
    static int getCountVariableDice(String given, int target, int faces) {
        // Initialize a local variable for storing the count of this function call
        int count = 0;

        // Base condition: when target is equal to 0, means we have found an answer so return 1
        if (target == 0) {
            return 1;
        }

        for (int i = 1; i <= faces && i <= target; i++) {
            // Add the results of subsequent function calls to this count
            count += getCount(given + i, target - i);

        }
        // return the count to top level recursion calls
        return count;
    }
}
