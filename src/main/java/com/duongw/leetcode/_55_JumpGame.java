package com.duongw.leetcode;

public class _55_JumpGame {

    /**
     * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
     * <p>
     * Return true if you can reach the last index, or false otherwise.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     * <p>
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 105
     */
    public static boolean canJump(int[] nums) {
        int step = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                flag = true;
                step = i;
                if (step == nums.length - 2 && flag) return true;

            } else {
                flag = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};
        boolean f = canJump(nums);
        System.out.println("Test: " + f);

        int nums_[] = {3, 2, 1, 0, 4};
        boolean f_ = canJump(nums_);
        System.out.println("Test: " + f_);


    }
}
