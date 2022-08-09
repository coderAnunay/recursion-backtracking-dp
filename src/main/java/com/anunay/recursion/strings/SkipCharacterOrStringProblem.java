package com.anunay.recursion.strings;

/**
 * Given a string, return a string by skipping a particular character
 * E.g: "baccad" --> (skip 'a') --> "bccd"
 */
public class SkipCharacterOrStringProblem {

    public static void main(String[] args) {
        String given = "baccad";
        System.out.println("Given string: " + given);
        System.out.print("After skipping character 'a': ");
        skipCharacter1(given, "", 'a');
        System.out.print("\nAfter skipping character 'b': ");
        skipCharacter1(given, "", 'b');
        System.out.print("\nAfter skipping character 'c': ");
        skipCharacter1(given, "", 'c');

        System.out.println("**********Method 2**************");
        System.out.println("Given string: " + given);
        System.out.print("After skipping character 'a': " + skipCharacter2(given, 'a'));
        System.out.print("\nAfter skipping character 'b': " + skipCharacter2(given, 'b'));
        System.out.print("\nAfter skipping character 'c': " + skipCharacter2(given, 'c'));

        System.out.println("\n********** Skip String 'Apple' **************");
        String given2 = "bcdApplefgh";
        System.out.println("Given string: " + given2);
        System.out.println("After skipping Apple: " + skipStringApple(given2));

        System.out.println("\n********** Skip String 'App' Not 'Apple' **************");
        String given3 = "bcdApplefgh";
        String given4 = "bcdAppfgh";
        System.out.println("Given string: " + given2);
        System.out.println("After skipping App Not Apple: " + skipStringAppNotApple(given3));
        System.out.println("Given string: " + given4);
        System.out.println("After skipping App Not Apple: " + skipStringAppNotApple(given4));
    }

    /**
     * Method 1: By passing the answer string in argument
     */
    static void skipCharacter1(String given, String answer, Character skip) {
        // Base condition: Print the answer string
        // and return after we have processed all characters of given string
        if (given.isEmpty()) {
            System.out.println(answer);
            return;
        }

        // Get the current character for comparison
        Character currentCharacter = given.charAt(0);
        if (currentCharacter == skip) {
            // Skip this character and don't add to answer
            skipCharacter1(given.substring(1), answer, skip);
        } else {
            // Add this character to answer string
            skipCharacter1(given.substring(1), answer + currentCharacter, skip);
        }
    }

    /**
     * Method 2: Without passing answer string as argument
     */
    static String skipCharacter2(String given, Character skip) {
        // Base condition: Return empty string if given string is empty
        // after we have processed all characters of given string
        if (given.isEmpty()) {
            return "";
        }

        // Get the current character for comparison
        Character currentCharacter = given.charAt(0);
        if (currentCharacter == skip) {
            // Skip this character and add empty string to next recursive call
            return "" + skipCharacter2(given.substring(1), skip);
        } else {
            // Add this character to next recursive call
            return currentCharacter + skipCharacter2(given.substring(1), skip);
        }
    }

    static String skipStringApple(String given) {
        // Base condition: Return empty string if given string is empty
        if (given.isEmpty()) return "";

        if (given.startsWith("Apple")) {
            // skip "Apple", so size of apple = 5 (0-4) hence substring from 5
            return "" + skipStringApple(given.substring(5));
        } else {
            return given.charAt(0) + skipStringApple(given.substring(1));
        }

    }

    static String skipStringAppNotApple(String given) {
        // Base condition: Return empty string if given string is empty
        if (given.isEmpty()) return "";

        if (given.startsWith("App") && !given.startsWith("Apple")) {
            // skip "App", so size of apple = 3 (0-2) hence substring from 3
            return "" + skipStringAppNotApple(given.substring(3));
        } else {
            return given.charAt(0) + skipStringAppNotApple(given.substring(1));
        }

    }
}
