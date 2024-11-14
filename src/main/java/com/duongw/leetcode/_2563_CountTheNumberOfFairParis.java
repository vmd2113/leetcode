package com.duongw.leetcode;

import java.util.Arrays;


//note: this problem is not solved (yet)
public class _2563_CountTheNumberOfFairParis {

    /**
     * 2563. Count the Number of Fair Pairs
     * Medium
     * Topics
     * Companies
     * Hint
     * Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
     * <p>
     * A pair (i, j) is fair if:
     * <p>
     * 0 <= i < j < n, and
     * lower <= nums[i] + nums[j] <= upper
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
     * Output: 6
     * Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
     * Example 2:
     * <p>
     * Input: nums = [1,7,9,2,5], lower = 11, upper = 11
     * Output: 1
     * Explanation: There is a single fair pair: (2,3).
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 105
     * nums.length == n
     * -109 <= nums[i] <= 109
     * -109 <= lower <= upper <= 109
     */




    // solution 1: brute force
    public long countFairPairs(int[] nums, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] <= upper && nums[i] + nums[j] >= lower) {
                    count++;
                }
            }
        }
        return count;
    }

    // solution 2: // sử dụng kĩ thuật chia để trị, các phần tử của array được chia thành các phần tử nhỏ hơn

    public long countFairPairsV1(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
       int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int jMin = findLowerBound(nums, i + 1, n - 1, lower - nums[i]);
            int jMax = findUpperBound(nums, i + 1, n - 1, upper - nums[i]);
            if (jMin <= jMax) {
                count += (jMax - jMin + 1);
            }
        }
        return count;


    }

    private int findLowerBound(int nums[], int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int findUpperBound(int nums[], int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {

    }
}