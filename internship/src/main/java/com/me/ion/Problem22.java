package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/GrahamScan.java.html
 */
public class Problem22 {
    private final File file = new File("input.in");
    private Scanner sc;

    {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private Stack<Point2D> hull = new Stack<Point2D>();

    public void grahamScan(Point2D[] pts) {
        int N = pts.length;
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++)
            points[i] = pts[i];

        Arrays.sort(points);
        Arrays.sort(points, 1, N, points[0].polarOrder());

        hull.push(points[0]);

        int k1;
        for (k1 = 1; k1 < N; k1++)
            if (!points[0].equals(points[k1])) break;
        if (k1 == N) return;        // all points equal

        int k2;
        for (k2 = k1 + 1; k2 < N; k2++)
            if (Point2D.ccw(points[0], points[k1], points[k2]) != 0) break;
        hull.push(points[k2-1]);

        for (int i = k2; i < N; i++) {
            Point2D top = hull.pop();
            while (Point2D.ccw(hull.peek(), top, points[i]) <= 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points[i]);
        }

        assert isConvex();
    }

    public Iterable<Point2D> hull() {
        Stack<Point2D> s = new Stack<>();
        for (Point2D p : hull) s.push(p);
        return s;
    }

    private boolean isConvex() {
        int N = hull.size();
        if (N <= 2) return true;

        Point2D[] points = new Point2D[N];
        int n = 0;
        for (Point2D p : hull()) {
            points[n++] = p;
        }

        for (int i = 0; i < N; i++) {
            if (Point2D.ccw(points[i], points[(i+1) % N], points[(i+2) % N]) <= 0) {
                return false;
            }
        }
        return true;
    }

    public void run() {
        int N = sc.nextInt();
        Point2D[] points = new Point2D[N];
        for (int i = 0; i < N; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            points[i] = new Point2D(x, y);
        }

        grahamScan(points);
        double perimeter = 0;
        Iterable<Point2D> iterable = hull();
        Iterator<Point2D> iterator = iterable.iterator();
        Point2D firstPoint = iterator.next();
        Point2D prevPoint = firstPoint;
        for (Iterator<Point2D> it = iterator; it.hasNext(); ) {
            Point2D p = it.next();
            perimeter += p.distanceTo(prevPoint);
            prevPoint = p;
        }
        perimeter += firstPoint.distanceTo(prevPoint);

        System.out.println(perimeter);
    }
}
