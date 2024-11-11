package com.duongw.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _169_MajorityElement {
    /**
     * Given an array nums of size n, return the majority element.
     * <p>
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,2,3]
     * Output: 3
     * Example 2:
     * <p>
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -109 <= nums[i] <= 109
     * <p>
     * <p>
     * Follow-up: Could you solve the problem in linear time and in O(1) space?
     */

    //Method 1: sort the array, then return the middle element
    public static int majorityElement1(int[] nums) {
        int[] sorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted);
        return sorted[sorted.length / 2];
    }

    //Method 2: count the number of times each element appears, then return the element with the most occurrences
    public static int majorityElement(int[] nums) {
        int count = 0;
        int majority = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majority = nums[i];
                count = 1;
            }
        }
        return majority;
    }

    // Method 3: count the number of times each element appears, then return the element with the most occurrences
    public static int majorityElement2(int[] nums) {
        int[] count = new int[100];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int majority = 0;
        int maxCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                majority = i;
            }
        }
        return majority;
    }


    // method 4: using hashmap and put the element in the map, then return the element with the most occurrences
    public static int majorityElement3(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                map.put(nums[i], map.get(nums[i]) + 1);
//            } else {
//                map.put(nums[i], 1);
//            }
//        }
//
//        Map.Entry<Integer, Integer> entry = map.entrySet().stream().max(Map.Entry.comparingByValue()).get();
//
//        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//        //     System.out.println(entry.getKey() + " " + entry.getValue());
//        // }
//        return entry.getKey();
//

        Map<Integer, Integer> map = new HashMap<>();
        int majorityCount = nums.length / 2;

        // Đếm số lần xuất hiện của mỗi phần tử
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Tìm phần tử xuất hiện nhiều hơn n / 2 lần
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > majorityCount) {
                return entry.getKey();
            }
        }

        return -1; // Trường hợp không tồn tại (không xảy ra theo đề bài)
    }


    public static void main(String[] args) {

        int[] nums = {3, 2, 3};
        int majorityElement = majorityElement(nums);
        System.out.println(majorityElement);

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int majorityElement2 = majorityElement2(nums2);
        System.out.println(majorityElement2);

        int[] nums3 = {4, 2, 2, 3, 7};
        int majorityElement3 = majorityElement3(nums3);
        System.out.println(majorityElement3);


    }
}
