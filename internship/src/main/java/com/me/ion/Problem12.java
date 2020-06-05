package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem12 {
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

    private int[] sumRows(int[][] m, int n) {
        int[] sum = new int[MAX_RANGE];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i] += m[i][j];
            }
        }

        return sum;
    }

    private int[][] sortMatrixRows(int[][] m, int n, int[] sum) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(sum[i] > sum[j]) {
                    int[] aux = m[i];
                    m[i] = m[j];
                    m[j] = aux;
                }
            }
        }

        return m;
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
        int[][] m = new int[MAX_RANGE][MAX_RANGE];
        // read the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        int[] sum = sumRows(m, n);
        printMatrix(sortMatrixRows(m, n, sum), n);
    }

}
