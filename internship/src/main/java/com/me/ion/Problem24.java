package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Problem24 {
    private final File file = new File("input.in");
    private Scanner sc;
    private static final int MAX_RANGE = 100;
    private int solSum = 0;
    private int m, n;
    private Stack<Point> solPath;

    {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "{" + x + ", " + y + "}";
        }
    }

    private void backTrack(int[][] t, int i, int j, int sum, Stack<Point> path) {
        if (t[i][j] == 2) {
            sum++;
        }
        path.push(new Point(i, j));

        if (sum > solSum) {
            solSum = sum;
            solPath = (Stack<Point>) path.clone();
        }

        if (i + 1 < m && t[i + 1][j] != 1) {
            backTrack(t, i + 1, j, sum, path);
        }
        if (j + 1 < n && t[i][j + 1] != 1) {
            backTrack(t, i, j + 1, sum, path);
        }

        path.pop();
    }

    void run() {
        m = sc.nextInt();
        n = sc.nextInt();
        int t[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = sc.nextInt();
            }
        }

        backTrack(t, 0, 0, 0, new Stack<>());

        System.out.println(solSum);
        System.out.println(solPath);
    }

}
