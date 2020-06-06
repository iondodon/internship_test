package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem22 {
    private final File file = new File("input.in");
    private Scanner sc;
    private static final int MAX_RANGE = 100;

    {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void run() {
        
    }

}
