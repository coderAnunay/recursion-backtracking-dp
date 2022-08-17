package com.anunay.recursion.backtrackingandmazeproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 3x3 Maze, count all paths from (3,3) to (1,1)
 */
public class Maze1 {

    public static void main(String[] args) {
        System.out.println("Number of paths from (3,3) to (1,1): " + countPaths(3,3));
        printPaths(3,3, "");
        System.out.println("\nList of paths from (3,3) to (1,1): " + getPathsList(3,3,""));
    }

    /**
     * Count all paths from (r,c) to (1,1)
     */
    static int countPaths(int r, int c) {
        // Base condition: Either row = 1 or col = 1,
        // then return 1 as only single path exists
        if (r == 1 || c == 1) {
            return 1;
        }
        // return addition of paths found by moving down(r-1) or right (col-1)
        return  countPaths(r-1,c) + countPaths(r,c-1);
    }

    /**
     * Print all paths in manner: RRDD for Right,Right,Down,Down
     */
    static void printPaths(int r, int c, String processed) {
        // Base condition: row = 1 AND col = 1,
        // then print the processed string as one fo the answers is found
        if (r == 1 && c == 1) {
            System.out.println(processed);
            return;
        }

        if (r > 1) {
            // Move down
            printPaths(r-1, c, processed + "D");
        }

        if (c > 1) {
            // Move right
            printPaths(r, c-1, processed + "R");
        }
    }

    /**
     * Return all paths in an arraylist
     */
    static List<String> getPathsList(int r, int c, String processed) {
        // Base condition: row = 1 AND col = 1,
        // then print the processed string as one fo the answers is found
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        // ArrayList local to the method call
        List<String> list = new ArrayList<>();

        if (r > 1) {
            // Move down
            list.addAll(getPathsList(r-1, c, processed + "D"));
        }

        if (c > 1) {
            // Move right
            list.addAll(getPathsList(r, c-1, processed + "R"));
        }

        return list;
    }
}