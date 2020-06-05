package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem8 {
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

    private List<Integer> getPrimesMethod1(int n) {
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; isPrime && j <= (int)Math.sqrt(i); j++) {
                if(i % j == 0) {
                    isPrime = false;
                }
            }

            if(isPrime) {
                primes.add(i);
            }
        }

        return primes;
    }

    private List<Integer> getPrimesMethod2(int n) {
        boolean[] array = new boolean[MAX_RANGE];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i < n; i++) {
            if(!array[i]) {
                primes.add(i);
                for (int j = i + i; j < n; j += i) {
                    array[j] = true;
                }
            }
        }

        return primes;
    }

    void run() {
        int n = sc.nextInt();
        System.out.println(getPrimesMethod1(n));
        System.out.println(getPrimesMethod2(n));
    }

}
