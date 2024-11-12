package com.duongw.leetcode;

public class _14_LongestCommonPrefix {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     *
     *
     * Constraints:
     *
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] consists of only lowercase English letters.*/

    // method one, brute force
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) return "";
        for (int i = 0; i<strs[0].length(); i++)    {

            char c = strs[0].charAt(i);
            for (int j = i; j<strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));

        String[] strs_ = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs_));




    }


}
