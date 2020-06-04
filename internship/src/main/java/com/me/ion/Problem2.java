package com.me.ion;

import java.util.Scanner;

public class Problem2 {
    private final Scanner in = new Scanner(System.in);

    void run() {
        int height = in.nextInt();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print('#');
            }
            System.out.println();
        }
    }

}
