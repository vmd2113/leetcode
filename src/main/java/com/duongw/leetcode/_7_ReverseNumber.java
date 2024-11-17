package com.duongw.leetcode;

import java.util.Stack;

public class _7_ReverseNumber {

    /**
     * 7. Reverse Integer
     * Medium
     * Topics
     * Companies
     * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     * <p>
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     */


    public static int reverseV1(int x) {
        int temp = 0;
        if (x > 0) {
            temp = x;
        } else {
            temp = x * -1;
        }

        Stack<Integer> stack = new Stack<>();
        while (temp != 0) {
            stack.push(temp % 10);
            temp = temp / 10;
        }
        int reverse = 0;
        int m = 1;
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            if (reverse > (Integer.MAX_VALUE - digit) / 10) {
                return 0; // Tràn số
            }

            reverse = reverse + digit * m;
            m = m * 10;


        }
        return (x < 0) ? reverse * -1 : reverse;

    }

    public static int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            int digit = x % 10;

            x = x / 10;

            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Tràn số dương
            }
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Tràn số âm
            }

            reverse = reverse * 10 + digit;

        }
        return reverse;

    }

    public static int reverseV2(int x) {

        boolean isNegative = x < 0;
        String str = Integer.toString(Math.abs(x));
        String reversedStr = new StringBuilder(str).reverse().toString();

        try {
            int result = Integer.parseInt(reversedStr);
            return isNegative ? -result : result;
        } catch (NumberFormatException e) {
            return 0; // Tràn số

        }
    }

    public static void main(String[] args) {
        _7_ReverseNumber solution = new _7_ReverseNumber();

        System.out.println(solution.reverse(123));    // Output: 321
        System.out.println(solution.reverse(-123));   // Output: -321
        System.out.println(solution.reverse(120));    // Output: 21
        System.out.println(solution.reverse(1534236469)); // Output: 0 (tràn số)

    }
}
