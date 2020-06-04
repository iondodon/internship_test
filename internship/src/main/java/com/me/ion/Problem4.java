package com.me.ion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem4 {
    private final Scanner in = new Scanner(System.in);
    private List<Integer> array = new ArrayList<>();

    private List<Integer> bubbleSort(List<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = i + 1; j < array.size(); j++) {
                int a = array.get(i);
                int b = array.get(j);
                if (a > b) {
                    array.set(i, b);
                    array.set(j, a);
                }
            }
        }
        return array;
    }

    void run() {
        while (in.hasNextInt()) {
            // end the list of integers with a letter, ex: 1 2 3 4 a
            array.add(in.nextInt());
        }
        System.out.println(bubbleSort(array));
    }

}
