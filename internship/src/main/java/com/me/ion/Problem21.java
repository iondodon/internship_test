package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem21 {
    private final File file = new File("input.in");
    private Scanner sc;
    private static final int MAX_RANGE = 100;
    private int n, m;
    private int[][] l = new int[MAX_RANGE][MAX_RANGE];

    private class Coordinate {
        int x;
        int y;

        Coordinate() {
        }

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "{" + x + ", " + y + "}";
        }
    }

    {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // lee
    private void lee(int x, int y) {
        Queue<Coordinate> queue = new LinkedList<>();

        queue.add(new Coordinate(x, y));
        l[x][y] = 1;
        while (!queue.isEmpty()) {
            Coordinate p = queue.poll();

            if(p.x - 1 >= 0 && l[p.x - 1][p.y] == 0) {
                l[p.x - 1][p.y] = l[p.x][p.y] + 1;
                queue.add(new Coordinate(p.x - 1, p.y));
            }

            if(p.y + 1 < m && l[p.x][p.y + 1] == 0) {
                l[p.x][p.y + 1] = l[p.x][p.y] + 1;
                queue.add(new Coordinate(p.x, p.y + 1));
            }

            if(p.x + 1 < n && l[p.x + 1][p.y] == 0) {
                l[p.x + 1][p.y] = l[p.x][p.y] + 1;
                queue.add(new Coordinate(p.x + 1, p.y));
            }

            if(p.y - 1 >= 0 && l[p.x][p.y - 1] == 0) {
                l[p.x][p.y - 1] = l[p.x][p.y] + 1;
                queue.add(new Coordinate(p.x, p.y - 1));
            }
        }
    }

    private Coordinate nextStep(Coordinate p) {
        Coordinate next = new Coordinate(p.x, p.y);

        if (p.x - 1 >= 0 && l[p.x - 1][p.y] != -1 && l[p.x - 1][p.y] < l[next.x][next.y]) {
            next.x = p.x - 1;
        }
        if (p.y + 1 < m && l[p.x][p.y + 1] != -1 && l[p.x][p.y + 1] < l[next.x][next.y]) {
            next.y = p.y + 1;
        }
        if (p.x + 1 < n && l[p.x + 1][p.y] != -1 && l[p.x + 1][p.y] < l[next.x][next.y]) {
            next.x = p.x + 1;
        }
        if (p.y - 1 >= 0 && l[p.x][p.y - 1] != -1 && l[p.x][p.y - 1] < l[next.x][next.y]) {
            next.y = p.y - 1;
        }

        return next;
    }

    private List<Coordinate> shortestPath() {
        List<Coordinate> path = new ArrayList<>();
        Coordinate borderCoordinate = new Coordinate();
        int distance = MAX_RANGE;

        for (int j = 0; j < m; j++) {
            if(l[0][j] < distance && l[0][j] != -1) {
                borderCoordinate.x = 0;
                borderCoordinate.y = j;
                distance = l[0][j];
            }
            if(l[n - 1][j] < distance && l[n - 1][j] != -1) {
                borderCoordinate.x = n - 1;
                borderCoordinate.y = j;
                distance = l[n - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            if(l[i][0] < distance && l[i][0] != -1) {
                borderCoordinate.x = i;
                borderCoordinate.y = 0;
                distance = l[i][0];
            }
            if(l[i][m - 1] < distance && l[i][m - 1] != -1) {
                borderCoordinate.x = i;
                borderCoordinate.y = m - 1;
                distance = l[i][m - 1];
            }
        }

        Coordinate p = new Coordinate(borderCoordinate.x, borderCoordinate.y);
        path.add(p);
        while (l[p.x][p.y] != 1) {
            p = nextStep(p);
            path.add(p);
        }

        return path;
    }

    void run() {
        n = sc.nextInt();
        m = sc.nextInt();
        int v;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                v = sc.nextInt();
                if(v == 1) {
                    l[i][j] = -1;
                } else {
                    l[i][j] = 0;
                }
            }
        }
        int x = sc.nextInt();
        int y = sc.nextInt();

        lee(x, y);
        System.out.println(shortestPath().toString());
    }

}
