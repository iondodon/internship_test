package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem7 {
    private final int[][] array = new int[100][100];
    private final File file = new File("input.in");
    private Scanner sc;

    {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    boolean isMagic(int size, int[][] array) {
        int sumPrimaryDiagonal = 0;
        int sumSecondaryDiagonal = 0;

        for (int i = 0; i < size; i++) {
            sumPrimaryDiagonal += array[i][i];
            sumSecondaryDiagonal += array[i][size - i - 1];
        }

        // check diagonals
        if (sumPrimaryDiagonal != sumSecondaryDiagonal){
            return false;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][size] += array[i][j];
                array[size][j] += array[i][j];
            }
        }

        //check rows and columns
        for (int i = 0; i < size; i++) {
            if (array[i][size] != sumPrimaryDiagonal || array[size][i] != sumPrimaryDiagonal) {
                return false;
            }
        }

        return true;
    }

    void run() {
        if (sc != null) {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = sc.nextInt();
                }
            }

            System.out.println(isMagic(n, array));
        }
    }

}
