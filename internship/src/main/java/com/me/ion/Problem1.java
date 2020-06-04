package com.me.ion;

import java.util.Scanner;

public class Problem1 {
    private final Scanner in = new Scanner(System.in);

    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    void run() {
        System.out.println(isPalindrome(in.nextLine()) ? "Palindrome" : "Not palindrome");
    }

}
