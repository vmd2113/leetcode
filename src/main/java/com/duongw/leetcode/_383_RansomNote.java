package com.duongw.leetcode;

public class _383_RansomNote {

    /**
     * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
     *
     * Each letter in magazine can only be used once in ransomNote.
     *
     *
     *
     * Example 1:
     *
     * Input: ransomNote = "a", magazine = "b"
     * Output: false
     * Example 2:
     *
     * Input: ransomNote = "aa", magazine = "ab"
     * Output: false
     * Example 3:
     *
     * Input: ransomNote = "aa", magazine = "aab"
     * Output: true
     *
     *
     * Constraints:
     *
     * 1 <= ransomNote.length, magazine.length <= 105
     * ransomNote and magazine consist of lowercase English letters.*/

    public static boolean canConstruct(String ransomNote, String magazine) {
        int counts[] = new int[26]; // khởi tạo mảng đếm số lượng kí tự từ a đến z

        for (char c: magazine.toCharArray()){
            counts[c-'a'] += 1;
        }

        for (char c: ransomNote.toCharArray()){
            if (counts[c-'a'] == 0) return false;
            counts[c-'a'] -=1;
        }
        return true;
    }

        public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));




    }
}
