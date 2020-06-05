package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem19 {
    private final File file = new File("input.in");
    private Scanner sc;
    private static final int MAX_RANGE = 100;
    private final Set<Integer> hashSet = new HashSet<>();
    private final int[] t = new int[MAX_RANGE];
    private int n;

    {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void per(int k) {
        hashSet.add(t[k]);

        if(k == n) {
            for (int i = 1; i <= n; i++) {
                System.out.print(t[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                if (!hashSet.contains(i)) {
                    t[k + 1] = i;
                    per(k + 1);
                }
            }
        }

        hashSet.remove(t[k]);
    }

    void run() {
        n = sc.nextInt();
        per(0);
    }

}
