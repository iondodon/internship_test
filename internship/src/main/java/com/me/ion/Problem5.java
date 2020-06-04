package com.me.ion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem5 {
    private final Scanner in = new Scanner(System.in);
    private List<Integer> array = new ArrayList<>();

    void run() {
        while (in.hasNextInt()) {
            // end the list of integers with a letter, ex: 1 2 3 4 a
            array.add(in.nextInt());
        }

        int evens = 0;
        int sumOdd = 0;

        for (int current : array) {
            if (current % 2 == 0) {
                evens++;
            } else {
                sumOdd += current;
            }
        }

        System.out.println("Evens: " + evens);
        System.out.println("Sum odd: " + sumOdd);
    }

}
