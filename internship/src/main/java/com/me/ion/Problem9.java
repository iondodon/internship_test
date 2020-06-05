package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem9 {
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

    void run() {
        int n = sc.nextInt();
        double[] abundancyIndex = new double[MAX_RANGE];

        for (int i = 0; i < n; i++) {
            int m = i; // calculate sum of divisors of m

            int sumOfDivisors = 1;
            // prime factorization of m
            for (int j = 2; j <= Math.sqrt(m); j++) {
                int primeFactorPower = 1;
                int currentSum = 1;
                while (m % j == 0) {
                    m = m / j;
                    primeFactorPower *= j;
                    currentSum += primeFactorPower;
                }

                sumOfDivisors *= currentSum;
            }

            if (m >= 2) {
                sumOfDivisors *= (1 + m);
            }

            abundancyIndex[i] = (double)sumOfDivisors / (double)i;
        }

        // find friends
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (abundancyIndex[i] == abundancyIndex[j]) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

}
