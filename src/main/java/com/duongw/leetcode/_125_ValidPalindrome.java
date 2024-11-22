package com.duongw.leetcode;

public class _125_ValidPalindrome {

    /**
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
     * <p>
     * Given a string s, return true if it is a palindrome, or false otherwise.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     * Example 2:
     * <p>
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     * Example 3:
     * <p>
     * Input: s = " "
     * Output: true
     * Explanation: s is an empty string "" after removing non-alphanumeric characters.
     * Since an empty string reads the same forward and backward, it is a palindrome.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 2 * 105
     * s consists only of printable ASCII characters.
     */


    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int indexLeft = 0;
        int indexRight = s.length() - 1;
        while (indexLeft < indexRight) {
            // bỏ qua những kí tự không phải là chữ hoặc số ở đầu

            while (indexLeft < indexRight && !Character.isLetterOrDigit(s.charAt(indexLeft))) {
                indexLeft++;
            }

            // bỏ qua các kí tự không phải là chữ hoặc số ở cuối

            while (indexLeft < indexRight && !Character.isLetterOrDigit(s.charAt(indexRight))) {
                indexRight--;
            }
            // trả về false nếu có kí tự ở đầu và cuối không trùng nhau
            if (Character.toLowerCase(s.charAt(indexLeft)) != Character.toLowerCase(s.charAt(indexRight))) {
                return false;
            }
            indexLeft++;
            indexRight--;
        }

        return true;

    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
        System.out.println(isPalindrome(" ")); // true

    }
}
