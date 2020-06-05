package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem17 {
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

    private void printMatrix(int[][] m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int[][] subMatrix(int[][] m, int n, int k) {
        int[][] sbm = new int[n - 1][n - 1];

        int a = 0, b = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j != k) {
                    sbm[a][b] = m[i][j];
                    b++;
                    if(b > n - 2) {
                        b = 0;
                    }
                }
            }
            a++;
        }

        return sbm;
    }

    private int determinant(int[][] m, int n) {
        if(n == 1) {
            return m[0][0];
        }

        int d = 0;
        for (int i = 0; i < n; i++) {
            d = d + (int)(Math.pow(-1, i + 2)) * m[0][i] * determinant(subMatrix(m, n, i), n - 1);
        }

        return d;
    }

    void run() {
        int n = sc.nextInt();
        int[][] m = new int[MAX_RANGE][MAX_RANGE];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        System.out.println(determinant(m, n));
    }

}
