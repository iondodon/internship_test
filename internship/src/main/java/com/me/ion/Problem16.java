package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem16 {
    private final File file = new File("input.in");
    private Scanner sc;

    {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void run() {
        int n = sc.nextInt();
        System.out.println(n / 2 + n % 2);
    }

}
