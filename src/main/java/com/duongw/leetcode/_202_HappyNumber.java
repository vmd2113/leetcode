package com.duongw.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _202_HappyNumber {

    /**
     * Write an algorithm to determine if a number n is happy.
     * <p>
     * A happy number is a number defined by the following process:
     * <p>
     * Starting with any positive integer, replace the number by the sum of the squares of its digits.
     * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
     * Those numbers for which this process ends in 1 are happy.
     * Return true if n is a happy number, and false if not.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 19
     * Output: true
     * Explanation:
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     * Example 2:
     * <p>
     * Input: n = 2
     * Output: false
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= n <= 231 - 1
     */

    private static int sumOfSquare(int n) {
        int sum = 0;
        while (n > 0) {
            int digits = n % 10;
            sum += digits * digits;
            n = n / 10;
        }
        return sum;
    }

    public static boolean isHappyRecursive(int n, Set<Integer> numbers) {
        if (n == 1) return true;
        if (numbers.contains(n)) {
            return false;
        }

        numbers.add(n);
        return isHappyRecursive(sumOfSquare(n), numbers);
    }

    public static boolean isHappy(int n) {
        Set<Integer> numbers = new HashSet<>();
        return isHappyRecursive(n, numbers);

    }

    public static void main(String[] args) {

        int n = 19;
        System.out.println(isHappy(n));


    }
}
