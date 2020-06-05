package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem14 {
    private final File file = new File("input.in");
    private Scanner sc;
    private static final int MAX_RANGE = 2000000;
    int[] coin = {50, 25, 10, 3, 1};
    int n, coins = MAX_RANGE;

    {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void backTrack(int sum, int coins, int index) {
        if (sum == n) {
            if(coins < this.coins) {
                this.coins = coins;
            }
            return;
        }

        if(index > coin.length){
            return;
        }

        if(sum + coin[index] <= n) {
            backTrack(sum + coin[index], coins + 1, index);
        } else {
            backTrack(sum, coins, index + 1);
        }
    }

    void run() {
        n = sc.nextInt();
        for (int i = 0; i < coin.length; i++) {
            backTrack(0, 0, i);
        }
        System.out.println(coins);
    }

}
