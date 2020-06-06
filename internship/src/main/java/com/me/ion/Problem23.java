package com.me.ion;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class Problem23 {
    private final File file = new File("input.in");
    private Scanner sc;
    private int solLen = 0;
    private int[] solSubSequence;

    {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean isAscending(int[] subSequence, int len) {
        for (int i = 1; i < len; i++) {
            if (subSequence[i] < subSequence[i - 1]) {
                return false;
            }
        }

        return true;
    }

    void findMaxSubsequence(int[] arr, int n) {
        int opSize = (int)Math.pow(2, n);

        // Run from counter 000..1 to 111..1
        int[] subSequence = new int[n];
        int len;
        for (int counter = 1; counter < opSize; counter++)
        {
            len = 0;
            for (int j = 0; j < n; j++)
            {
                if (BigInteger.valueOf(counter).testBit(j)) {
                    subSequence[len] = arr[j];
                    len++;
                }
            }

            if (len > solLen && isAscending(subSequence, len)) {
                solLen = len;
                solSubSequence = Arrays.copyOf(subSequence, len);
            }
        }
    }

    void run() {
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        findMaxSubsequence(input, n);

        for (int i = 0; i < solLen; i++) {
            System.out.print(solSubSequence[i] + " ");
        }
        System.out.println();
    }

}
