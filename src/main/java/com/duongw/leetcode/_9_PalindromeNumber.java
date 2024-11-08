package com.duongw.leetcode;

public class _9_PalindromeNumber {

    /**
     * Given an integer x, return true if x is a
     * palindrome
     * , and false otherwise.
     * <p>
     * Example 1:
     * <p>
     * Input: x = 121
     * Output: true
     * Explanation: 121 reads as 121 from left to right and from right to left.
     * Example 2:
     * <p>
     * Input: x = -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * Example 3:
     * <p>
     * Input: x = 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     */


    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int original = x;

        int reverseNumber = 0;
        while (x > 0) {
            int digit = x % 10;
            reverseNumber = reverseNumber * 10 + digit;
            x = x / 10;
        }

        if (reverseNumber != original) return false;
        return true;
    }

    public static void main(String[] args) {

        int num1 = 121;
        System.out.println(isPalindrome(num1));

        int num2 = 23123;
        System.out.println(isPalindrome(num2));

        int num3 = -121;
        System.out.println(isPalindrome(num3));

    }


}
