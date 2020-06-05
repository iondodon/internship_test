package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem10 {
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
        int k = sc.nextInt();
        // read the current year
        int indexYear = sc.nextInt();

        while (indexYear % 4 != 0){
            indexYear++;
        }

        int count = 0;
        while (count < k) {
            if(indexYear % 100 != 0 || (indexYear % 100 == 0 && indexYear % 400 == 0)) {
                count++;
                System.out.print(indexYear + " ");
            }

            indexYear += 4;
        }
    }

}
