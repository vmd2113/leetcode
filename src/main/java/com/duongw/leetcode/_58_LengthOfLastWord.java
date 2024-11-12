package com.duongw.leetcode;


public class _58_LengthOfLastWord {

    /**
     * Given a string s consisting of words and spaces, return the length of the last word in the string.
     * <p>
     * A word is a maximal
     * substring
     * consisting of non-space characters only.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "Hello World"
     * Output: 5
     * Explanation: The last word is "World" with length 5.
     * Example 2:
     * <p>
     * Input: s = "   fly me   to   the moon  "
     * Output: 4
     * Explanation: The last word is "moon" with length 4.
     * Example 3:
     * <p>
     * Input: s = "luffy is still joyboy"
     * Output: 6
     * Explanation: The last word is "joyboy" with length 6.
     */

    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split("\\s+");
        return words[words.length - 1].length();

    }


    public static void main(String[] args) {

    }
}
