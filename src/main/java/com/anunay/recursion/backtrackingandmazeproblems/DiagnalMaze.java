package com.anunay.recursion.backtrackingandmazeproblems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a 3x3 Maze, count all paths from (3,3) to (1,1)
 *
 * Constraint: Allowed to move Horizontal(Right), Vertical(Down) & Diagonally
 *
 */
public class DiagnalMaze {

    public static void main(String[] args) {
        System.out.println("Number of paths from (3,3) to (1,1): " + countPaths(3,3));
        printPaths(3,3,"");
        System.out.println("\nList of paths from (3,3) to (1,1): " + getPathsList(3,3,""));
    }

    /**
     * Count all paths
     */
    static int countPaths(int r, int c) {
        // Base condition: When r==1 || c==1
        // Return 1 as one of the paths is found
        if (r == 1 || c == 1) {
            return 1;
        }

        return countPaths(r-1, c) + countPaths(r, c-1) + countPaths(r-1, c-1);
    }

    /**
     * Print all paths
     */
    static void printPaths(int r, int c, String processed) {
        // Base condition: When r==1 & c==1
        // Print processed as one of the answers is found
        if (r == 1 && c == 1) {
            System.out.println(processed);
            return;
        }

        if (r > 1) {
            // Move Vertical
            printPaths(r-1, c, processed + "V");
        }

        if (c > 1) {
            // Move Horizontal
            printPaths(r, c-1, processed + "H");
        }

        if (r > 1 && c > 1) {
            // Move diagonally
            printPaths(r-1, c-1, processed + "D");
        }
    }

    /**
     * Return a list of paths
     */
    static List<String> getPathsList(int r, int c, String processed) {
        // Base condition: When r==1 & c==1
        // Add processed to list as one of the answers is found
        if (r == 1 && c == 1) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        // Create a local list
        List<String> list = new ArrayList<>();

        if (r > 1) {
            // Move Vertical
            list.addAll(getPathsList(r-1, c, processed + "V"));
        }

        if (c > 1) {
            // Move Horizontal
            list.addAll(getPathsList(r, c-1, processed + "H"));
        }

        if (r > 1 && c > 1) {
            // Move diagonally
            list.addAll(getPathsList(r-1, c-1, processed + "D"));
        }

        return list;
    }
}
