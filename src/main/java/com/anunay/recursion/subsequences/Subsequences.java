package com.anunay.recursion.subsequences;

public class Subsequences {

    private static final String EMPTY = "EMPTY_STRING";

    public static void main(String[] args) {
        String str = "abc";
        System.out.format("Subsequences of %s:\n", str);
        printSubsequences(str, "");
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
}
