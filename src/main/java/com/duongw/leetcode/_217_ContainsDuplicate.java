package com.duongw.leetcode;

import java.util.HashSet;

public class _217_ContainsDuplicate {

    /**
     * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     * <p>

     * Example 1:
     * <p>
     * Input: nums = [1,2,3,1]
     * <p>
     * Output: true
     * Explanation:
     * <p>
     * The element 1 occurs at the indices 0 and 3.
     */



    public static boolean containsDuplicate(int num[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            if(set.contains(num[i])){
                return true;
            }
            set.add(num[i]);

        }
        return false;

    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        boolean result = containsDuplicate(nums);
        System.out.println("Result: "+ result);

    }
}
