package com.anunay.recursion.subsequences;

import java.util.ArrayList;
import java.util.Arrays;

public class AsciiValueProblems {

    private static final String EMPTY = "EMPTY_STRING";

    public static void main(String[] args) {
        // Printing ascii value of a character
        char c = 'a';
        int ascii = c + 0;
        System.out.println("ASCII value of 'a': " + ascii); // add 0 to it

        // Print subsequences and ascii value
        String str = "ab";
        System.out.format("Subsequences with ascii for %s: \n", str);
        printSubsequencesAscii(str, "");

        // Print ArrayList of subsequences and ascii values
        ArrayList<String> subsequences = getSubsequenceList(str, "");
        System.out.format("Subsequences ArrayList with ascii for %s: %s\n", str, subsequences);
    }

    /**
     * Given a string, print the subsequences along with ascii value
     * E.g, ab = {a, b, ab, 97, 98, 9798, a98, 97b, ""}
     */
    static void printSubsequencesAscii(String given, String processed) {
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
        printSubsequencesAscii(given.substring(1), processed + currentCharacter);
        // Ignore current character
        printSubsequencesAscii(given.substring(1), processed);
        // Print the ascii value also
        printSubsequencesAscii(given.substring(1), processed + (currentCharacter + 0));
    }

    /**
     * Return an ArrayList of subsequences and ascii
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
        // ArrayList for ascii value
        ArrayList<String> ascii = getSubsequenceList(given.substring(1), processed + (currentCharacter + 0));

        // Finally return a mix of left and right function calls' return value
        subsequenceList.addAll(left);
        subsequenceList.addAll(right);
        subsequenceList.addAll(ascii);
        return subsequenceList;
    }

}
