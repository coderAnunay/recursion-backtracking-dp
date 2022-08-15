package com.anunay.recursion.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * Example 2:
 * Input: digits = ""
 * Output: []
 * <p>
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * <p>
 * Constraints:
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class Problem17 {

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String pad = "23";
        System.out.println("List of all combinations for " + pad + ": " + letterCombinations(pad).toString());
        pad = "";
        System.out.println("List of all combinations for " + pad + ": " + letterCombinations(pad).toString());
        pad = "2";
        System.out.println("List of all combinations for " + pad + ": " + letterCombinations(pad).toString());
    }

    /**
     * Code to return list of all combinations
     */
    public static List<String> letterCombinations(String digits) {
        return helper(digits, "");
    }

    static List<String> helper(String given, String processed) {

        List<String> list = new ArrayList<>();

        if (given.isEmpty()) {
            if (processed.isEmpty())
                return new ArrayList<String>();
            list.add(processed);
            return list;
        }

        int digit = given.charAt(0) - '0';

        for (int i = 0; i < KEYS[digit].length(); i++) {
            char current = KEYS[digit].charAt(i);
            list.addAll(helper(given.substring(1), processed + current));
        }
        return list;
    }
}
