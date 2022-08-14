package com.anunay.recursion.permutations;

import java.util.ArrayList;

public class Permutations {

    public static void main(String[] args) {
        String str = "abc";
        System.out.format("Permutations of the string %s: ", str);
        System.out.println();
        printPermutations(str, "");
        ArrayList<String> permutationsList = getPermutationsList(str, "");
        System.out.format("Permutation list for string: %s is %s", str, permutationsList);
        int count = countPermutations(str, "");
        System.out.println("\nCount of permutations of " + str + " :" + count);
    }

    /**
     * Print all permutations of a given string
     * For e.g "abc" = [cba, bca, bac, cab, acb, abc]
     */
    static void printPermutations(String given, String processed) {
        // Base condition: given string is empty
        if (given.isEmpty()) {
            System.out.println(processed);
            return;
        }

        // Get the current character for processing
        char currentCharacter = given.charAt(0);

        // Recursion from for loop because it is variable
        for (int i = 0; i <= processed.length(); i++) {
            /**
             * Based on the length of the processed string,
             * we construct the permutations of given string by
             * placing the current character at all possible
             * positions in the processed string
             *
             * For e.g, --> processed/given --> ab/c
             *  --> c|ab + ac|b + abc|
             */

            // Get the first position
            String first = processed.substring(0, i);
            // Get the second position
            String second = processed.substring(i, processed.length());
            // Call recursion
            // Shrink given string by substringing from location of the second char
            // And pass the current char position to processed
            printPermutations(given.substring(1), first + currentCharacter + second);
        }
    }

    /**
     * Return the permutations in an ArrayList
     */
    static ArrayList<String> getPermutationsList(String given, String processed) {

        // Initialize a local ArrayList
        ArrayList<String> permutationList = new ArrayList<>();

        // Base condition: given string is empty
        if (given.isEmpty()) {
            permutationList.add(processed);
            return permutationList;
        }

        // Get the current character for processing
        char currentCharacter = given.charAt(0);

        // Recursion from for loop because it is variable
        for (int i = 0; i <= processed.length(); i++) {
            /**
             * Based on the length of the processed string,
             * we construct the permutations of given string by
             * placing the current character at all possible
             * positions in the processed string
             *
             * For e.g, --> processed/given --> ab/c
             *  --> c|ab + ac|b + abc|
             */

            // Get the first position
            String first = processed.substring(0, i);
            // Get the second position
            String second = processed.substring(i, processed.length());
            // Call recursion
            // Shrink given string by substringing from location of the second char
            // And pass the current char position to processed
            // Add all successive recursive calls to the local list
            permutationList.addAll(getPermutationsList(given.substring(1), first + currentCharacter + second));
        }
        return permutationList;
    }

    /**
     * Return the count of permutations of a string
     */
    static int countPermutations(String given, String processed) {
        // Base condition: given string is empty
        if (given.isEmpty()) {
            // As given string is empty that means we have found 1 permutation
            return 1;
        }

        // Get the current character for processing
        char currentCharacter = given.charAt(0);

        // Intitialize local count
        int count = 0;

        // Recursion from for loop because it is variable
        for (int i = 0; i <= processed.length(); i++) {
            /**
             * Based on the length of the processed string,
             * we construct the permutations of given string by
             * placing the current character at all possible
             * positions in the processed string
             *
             * For e.g, --> processed/given --> ab/c
             *  --> c|ab + ac|b + abc|
             */

            // Get the first position
            String first = processed.substring(0, i);
            // Get the second position
            String second = processed.substring(i, processed.length());
            // Call recursion
            // Shrink given string by substringing from location of the second char
            // And pass the current char position to processed
            count += countPermutations(given.substring(1), first + currentCharacter + second);
        }

        // Return the count for this call
        return count;
    }
}
