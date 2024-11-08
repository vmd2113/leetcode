package com.duongw.leetcode;

import java.util.HashMap;

public class _1_TwoSum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */


// Solution 1: use two for loops O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        int result[] = new int [2];
        for (int i =0; i<nums.length; i++){
            for (int j = i+1; j<nums.length; j++){
                if (nums[i] + nums[j]==target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;

    }

    // Solution 2: use HashMap O(n)
    public static int[] twoSumV2(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {

        int nums[] = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Result: " + result[0] + " " + result[1]);


        int nums2[] = {2,8, 5, 10, -5, 4};
        int target2 = 12;

        int [] result2 = twoSumV2(nums2, target2);
        System.out.println("Result: " + result2[0] + " " + result2[1]);



    }
}
