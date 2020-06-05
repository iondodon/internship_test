package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem15 {
    private final File file = new File("input.in");
    private Scanner sc;
    private static final int MAX_RANGE = 100;

    {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int[][] rotateClockwise(int[][] m, int n) {
        int[][] aux = new int[MAX_RANGE][MAX_RANGE];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aux[j][n - i - 1] = m[i][j];
            }
        }

        return aux;
    }

    private void printMatrix(int[][] m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    void run() {
        int n = sc.nextInt();
        int m[][] = new int[MAX_RANGE][MAX_RANGE];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        m = rotateClockwise(m, n);
        m = rotateClockwise(m, n);
        printMatrix(m, n);
    }

}
