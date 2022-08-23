package com.anunay.recursion.backtrackingandmazeproblems;

import java.util.Arrays;

/**
 * Given a 3x3 Maze, with movement allowed in all directions (Up, Down, Left and Right)
 *
 * Find all paths to reach from (0,0) to (2,2)
 *
 * NOTE: This problem is an introduction to Backtracking concept
 */
public class AllPathsMaze {

    // The maze
    private static final boolean[][] MAZE_3_BY_3 = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
    };

    public static void main(String[] args) {
        printAllPaths(0,0,"", MAZE_3_BY_3);
        System.out.println("-------All paths and Matrix------");
        int[][] path = new int[MAZE_3_BY_3.length][MAZE_3_BY_3[0].length];
        printAllPathsAndMatrix(0, 0, "", MAZE_3_BY_3, path, 1);
    }

    /**
     * Print all paths
     */
    static void printAllPaths(int r, int c, String processed, boolean[][] maze) {
        // Base condition: When r=2 & c=2,
        // Then print processed as we have found an answer
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // I am considering this cell in my path
        maze[r][c] = false;

        if (r < maze.length - 1) {
            // Go down
            printAllPaths(r+1, c, processed + "D", maze);
        }

        if (r > 0) {
            // Go up
            printAllPaths(r-1, c, processed + "U", maze);
        }

        if (c < maze[0].length - 1) {
            // Go left
            printAllPaths(r, c+1, processed + "R", maze);
        }

        if (c > 0) {
            // Go right
            printAllPaths(r, c - 1, processed + "L", maze);
        }

        // This line is where the function call will be over
        // before function returns, also remove the changes made by the function (backtracking)
        maze[r][c] = true;
    }

    static void printAllPathsAndMatrix(int r, int c, String processed, boolean[][] maze, int[][] path, int step) {
        // Base condition: When r=2 & c=2,
        // Then print processed as we have found an answer
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(processed);
            path[r][c] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // I am considering this cell in my path
        maze[r][c] = false;

        // The current cell in my path will be the step number
        path[r][c] = step;

        if (r < maze.length - 1) {
            // Go down
            printAllPathsAndMatrix(r+1, c, processed + "D", maze, path, step+1);
        }

        if (r > 0) {
            // Go up
            printAllPathsAndMatrix(r-1, c, processed + "U", maze, path, step+1);
        }

        if (c < maze[0].length - 1) {
            // Go left
            printAllPathsAndMatrix(r, c+1, processed + "R", maze, path, step+1);
        }

        if (c > 0) {
            // Go right
            printAllPathsAndMatrix(r, c - 1, processed + "L", maze, path, step+1);
        }

        // This line is where the function call will be over
        // before function returns, also remove the changes made by the function (backtracking)
        maze[r][c] = true;
        // Mark the cell = 0 so that changes made by this function call are reverted (backtracking)
        path[r][c] = 0;
    }
}
