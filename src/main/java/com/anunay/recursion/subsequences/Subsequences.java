package com.anunay.recursion.subsequences;

import java.util.ArrayList;
import java.util.Collections;

public class Subsequences {

    private static final String EMPTY = "EMPTY_STRING";

    public static void main(String[] args) {
        String str = "abc";
        System.out.format("Subsequences of %s:\n", str);
        printSubsequences(str, "");

        // ArrayList of subsequences
        ArrayList<String> subsequenceList = getSubsequenceList(str, "");
        System.out.format("ArrayList of subsequences of %s: %s", str, subsequenceList);
    }

    /**
     * Given a string, print all subsequences of it
     * E.g: "abc" ==> ["", "a", "b", "c", "ab", "ac", "bc", "abc"]
     */
    static void printSubsequences(String given, String processed) {
        // Base condition: If given string is empty, print the processed string
        if (given.isEmpty()) {
            if (processed.isEmpty())
                System.out.format("Subsequence: %s\n", EMPTY);
            else
                System.out.format("Subsequence: %s\n", processed);
            return;
        }

        // Get the current character
        Character currentCharacter = given.charAt(0);
        // Take current character
        printSubsequences(given.substring(1), processed + currentCharacter);
        // Ignore current character
        printSubsequences(given.substring(1), processed);
    }

    /**
     * Return an ArrayList of subsequences
     * Without passing the list as argument
     */
    static ArrayList<String> getSubsequenceList(String given, String processed) {

        // Create a new local ArrayList
        ArrayList<String> subsequenceList = new ArrayList<>();

        // Base condition: If given string is empty, print the processed string
        if (given.isEmpty()) {
            if (processed.isEmpty())
                subsequenceList.add(EMPTY);
            else
                subsequenceList.add(processed);
            return subsequenceList;
        }

        // Get the current character
        Character currentCharacter = given.charAt(0);
        // Take current character and store the left function call's return value
        ArrayList<String> left = getSubsequenceList(given.substring(1), processed + currentCharacter);
        // Ignore current character and store the right function call's return value
        ArrayList<String> right = getSubsequenceList(given.substring(1), processed);

        // Finally return a mix of left and right function calls' return value
        subsequenceList.addAll(left);
        subsequenceList.addAll(right);
        return subsequenceList;
    }
}
