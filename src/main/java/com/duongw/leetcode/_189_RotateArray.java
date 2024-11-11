package com.duongw.leetcode;

public class _189_RotateArray {

    /**
     * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     * Example 2:
     *
     * Input: nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]*/


    public static void rotate(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            nums = reverse(nums);
        }


    }

    private static int[] reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }


    }
}
