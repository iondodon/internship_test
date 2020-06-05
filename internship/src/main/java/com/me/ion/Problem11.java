package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem11 {
    private final File file = new File("input.in");
    private Scanner sc;
    private static final int MAX_RANGE = 1000000;

    {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int[] merge(int[] arr1, int n, int[] arr2, int m) {
        int[] result = new int[n + m];

        int i = 0, j = 0, index = 0;
        while(i < n || j < m) {
            if(i >= n) {
                result[index] = arr2[j];
                j++;
                index++;
                continue;
            }

            if(j >= m) {
                result[index] = arr1[i];
                i++;
                index++;
                continue;
            }

            if(arr1[i] <= arr2[j]){
                result[index] = arr1[i];
                i++;
            } else {
                result[index] = arr2[j];
                j++;
            }
            index++;
        }

        return result;
    }

    private void printArray(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    void run() {
        int[] arr1 = new int[MAX_RANGE];
        int[] arr2 = new int[MAX_RANGE];
        int[] arr3 = new int[MAX_RANGE];
        int n, m, k;

        // arrays length
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        // read array 1
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        // read array 2
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        // read array 3
        for (int i = 0; i < k; i++) {
            arr3[i] = sc.nextInt();
        }

        printArray(arr1, n);
        printArray(arr2, m);
        printArray(arr3, k);

        int[] mergedArray = merge(merge(arr1, n, arr2, m), n + m, arr3, k);

        printArray(mergedArray, n + m + k);
    }

}
