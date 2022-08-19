package com.anunay.recursion.backtrackingandmazeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given 3x3 maze with obstacle cell (represented by false value in a boolean matrix)
 * Find paths from (0,0) to (2,2)
 */
public class ObstacleMaze {
    // The maze initialized with obstacle at (1,1)
    private static final boolean[][] MAZE_3_BY_3 = {
            {true, true, true},
            {true, false, true},
            {true, true, true}
    };

    public static void main(String[] args) {
        System.out.println("Number of paths from (0,0) to (2,2) with obstacle at (1,1): " + countPaths(0, 0, MAZE_3_BY_3));
        printPaths(0, 0, "", MAZE_3_BY_3);
        System.out.println("List of paths from (0,0) to (2,2) with obstacle at (1,1): " + getPathsList(0, 0, "", MAZE_3_BY_3));
    }

    /**
     * Print all paths
     */
    static void printPaths(int r, int c, String processed, boolean[][] maze) {
        // Base condition: If row=2 & col=2 for a 3x3 maze
        // Print processed as we have found an answer
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }

        // If given cell is not an obstacle
        if (maze[r][c]) {
            if (r < maze.length - 1) {
                printPaths(r+1, c, processed + "D", maze);
            }

            if (c < maze[0].length - 1) {
                printPaths(r, c+1, processed + "R", maze);
            }
        }
    }

    /**
     * Count all paths
     */
    static int countPaths(int r, int c, boolean[][] maze) {
        // Base condition: If row=2 || col=2 for a 3x3 maze
        // Return 1 as we have found a path
        if (r == maze.length - 1 || c == maze[0].length - 1) {
            return 1;
        }

        // If given cell is an obstacle return 0
        if (!maze[r][c]) {
            return 0;
        }

        return countPaths(r+1, c, maze) + countPaths(r, c+1, maze);
    }

    /**
     * Get a list of paths
     */
    static List<String> getPathsList(int r, int c, String processed, boolean[][] maze) {
        // Base condition: If row=2 & col=2 for a 3x3 maze
        // Add processed to list as we have found an answer
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        // Create a local list
        List<String> list = new ArrayList<>();

        // If given cell is not an obstacle
        if (maze[r][c]) {
            if (r < maze.length - 1) {
                list.addAll(getPathsList(r+1, c, processed + "D", maze));
            }

            if (c < maze[0].length - 1) {
                list.addAll(getPathsList(r, c+1, processed + "R", maze));
            }
        }
        return list;
    }
}
