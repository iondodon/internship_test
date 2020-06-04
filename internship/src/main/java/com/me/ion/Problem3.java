package com.me.ion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem3 {
    private final Scanner in = new Scanner(System.in);
    List<Integer> array = new ArrayList<>();

    private List<Integer> inverse(List<Integer> array) {
        for (int i = 0; i < array.size() / 2; i++) {
            int aux = array.get(i);
            array.set(i, array.get(array.size() - i - 1));
            array.set(array.size() - i - 1, aux);
        }
        return array;
    }

    void run() {
        while (in.hasNextInt()) {
            // end the list of integers with a letter, ex: 1 2 3 4 a
            array.add(in.nextInt());
        }
        System.out.println(inverse(array));
    }

}
