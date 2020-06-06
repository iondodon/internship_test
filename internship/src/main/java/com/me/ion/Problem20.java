package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem20 {
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

    private LinkedList<Integer> clear(LinkedList<Integer> list) {
        int index = 0;
        while (list.size() > 1 && index < list.size() - 1) {
            if(list.get(index) == list.get(index + 1) + 1 || list.get(index) == list.get(index + 1) - 1) {
                list.remove(index);
            } else {
                index++;
            }
        }

        return list;
    }

    void run() {
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        clear(list);
        System.out.println(list.toString());
    }

}
