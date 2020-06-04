package com.me.ion;

import java.util.Scanner;

public class Problem6 {
    private final Scanner in = new Scanner(System.in);

    void run() {
        double n = in.nextDouble();
        double approximatedPi = 4;

        double denominator = 1;
        int count = 0;
        while (Math.abs(Math.PI - approximatedPi) > 1 / Math.pow(10, n + 1) ) {
           count++;
           denominator += 2;

           if (count % 2 == 1) {
               approximatedPi -= 4 / denominator;
           } else {
               approximatedPi += 4 / denominator;
           }
        }

        System.out.println("Real PI: " + Math.PI);
        System.out.println("Appr.PI: " + approximatedPi);
        System.out.println("Error  :" + Math.abs(approximatedPi - Math.PI));
    }

}
