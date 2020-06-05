package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem18 {
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
        int n = sc.nextInt(), p = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = p - 1;
        while (list.size() > 1) {
            list.remove(index);

            if(index > list.size() - 1) {
                index = 0;
            }

            for (int i = 0; i < p - 1; i++) {
                index ++;
                if(index > list.size() - 1) {
                    index = 0;
                }
            }
        }

        System.out.println(list.getFirst());
    }

}
