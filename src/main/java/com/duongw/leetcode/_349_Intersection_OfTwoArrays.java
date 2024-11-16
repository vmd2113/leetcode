package com.duongw.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class _349_Intersection_OfTwoArrays {

    /**
     * Given two integer arrays nums1 and nums2, return an array of their
     * intersection
     * . Each element in the result must be unique and you may return the result in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     * Explanation: [4,9] is also accepted.
     *  */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            return intersection(nums2, nums1);
        }

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        int[] result_ = new int[result.size()];
        int index = 0;
        for (int num : result) {
            result_[index++] = num;
        }

        return result_;


    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection(nums1, nums2);

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : result) {
            list.add(num);
        }
        System.out.println(list);

    }
}



