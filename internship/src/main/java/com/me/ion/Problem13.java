package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem13 {
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

    private void shiftLeft(int[] t, int n) {
        int first = t[0];
        for (int i = 0; i < n - 1; i++) {
            t[i] = t[i + 1];
        }
        t[n - 1] = first;
    }

    private int[] rotateLeft(int[] t, int n, int k) {
        for (int i = 0; i < k % n; i++) {
            shiftLeft(t, n);
        }

        return t;
    }

    void run() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] t = new int[MAX_RANGE];

        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(rotateLeft(t, n, k)));
    }

}
