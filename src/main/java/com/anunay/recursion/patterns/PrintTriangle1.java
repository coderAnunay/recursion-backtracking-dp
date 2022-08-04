package com.anunay.recursion.patterns;

public class PrintTriangle1 {

    public static void main(String[] args) {
        /**
         * Prints - ****
         *          ***
         *          **
         *          *
         */
        print1(4,0);
        System.out.println();
        print2(4, 0);
    }

    private static void print1(int row, int col) {
        if (col < row) {
            int i = col;
            while (i < row) {
                System.out.print("*");
                i++;
            }
            System.out.println();
            print1(row, col+1);
        }
    }

    /**
     * Without any loop
     */
    private static void print2(int row, int col) {
        // Base condition
        if (row == 0) {
            return;
        }
        if (col < row) {
            System.out.print("*");
            print2(row, col+1);
        } else {
            System.out.println();
            print2(row-1, 0);
        }
    }
}
