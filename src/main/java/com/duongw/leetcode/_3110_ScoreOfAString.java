package com.duongw.leetcode;

public class _3110_ScoreOfAString {

    /**
     * You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
     * <p>
     * Return the score of s.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "hello"
     * <p>
     * Output: 13
     * <p>
     * Explanation:
     * <p>
     * The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111. So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.
     * <p>
     * Example 2:
     * <p>
     * Input: s = "zaz"
     * <p>
     * Output: 50
     * <p>
     * Explanation:
     * <p>
     * The ASCII values of the characters in s are: 'z' = 122, 'a' = 97. So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.
     */

    public int scoreOfParentheses(String s) {

        int length = s.length();

        int score = 0;

        if (length <= 1) return 0;

        int asciiValue[] = new int[length];
        for (int i = 0; i < length; i++) {
            asciiValue[i] = s.charAt(i);
        }
        for (int i = 1; i < length; i++) {
            score += Math.abs(asciiValue[i] - asciiValue[i - 1]);

        }
        return score;
    }

    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 1; i < s.length(); i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i - 1));

        }

        return score;

    }


    public static void main(String[] args) {

    }
}
