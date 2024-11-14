package com.duongw.leetcode;

public class _66_PlusOne {
    /**
     * 66. Plus One
     * Attempted
     * Easy
     * Topics
     * Companies
     * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
     * <p>
     * Increment the large integer by one and return the resulting array of digits.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: digits = [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Incrementing by one gives 123 + 1 = 124.
     * Thus, the result should be [1,2,4].
     * Example 2:
     * <p>
     * Input: digits = [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321.
     * Incrementing by one gives 4321 + 1 = 4322.
     * Thus, the result should be [4,3,2,2].
     * Example 3:
     * <p>
     * Input: digits = [9]
     * Output: [1,0]
     * Explanation: The array represents the integer 9.
     * Incrementing by one gives 9 + 1 = 10.
     * Thus, the result should be [1,0].
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= digits.length <= 100
     * 0 <= digits[i] <= 9
     * digits does not contain any leading 0's.
     */

    public boolean checkMax(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 9) return false;
        }
        return true;
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        if (checkMax(digits)) {
            int newDigits[] = new int[digits.length + 1];
            for (int i = 0; i < newDigits.length; i++) {
                if (i == 0) newDigits[i] = 1;
                else newDigits[i] = 0;
            }
            return newDigits;
        }
        if (digits[n] < 9) {
            digits[n]++;
            return digits;
        }


        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] == 9) {
                if (digits[i - 1] != 9) {
                    digits[i] = 0;
                    digits[i - 1]++;
                    return digits;
                } else {
                    digits[i] = 0;
                }


            }

        }
        return digits;


    }

    public int[] plusOne_(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // Set current digit to 0 if it was 9
            digits[i] = 0;
        }

        // If all digits were 9, we need an extra digit at the start
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;

        return newDigits;
    }

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        _66_PlusOne plusOne = new _66_PlusOne();
//        int[] nums = {1, 2, 3};
//        System.out.println(plusOne.plusOne(nums));
//
//        int[] nums_ = {4, 3, 2, 1};
//        System.out.println(plusOne.plusOne(nums_));

        int[] nums__ = {9, 8,9 , 9};
        nums__ = plusOne.plusOne_(nums__);
        print(nums__);


    }
}
