package com.duongw.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class _268_MissingNumber {
    /**
     * 268. Missing Number
     * Easy
     * Topics
     * Companies
     * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [3,0,1]
     * Output: 2
     * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
     * Example 2:
     * <p>
     * Input: nums = [0,1]
     * Output: 2
     * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
     * Example 3:
     * <p>
     * Input: nums = [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == nums.length
     * 1 <= n <= 104
     * 0 <= nums[i] <= n
     * All the numbers of nums are unique.
     * <p>
     * <p>
     * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
     */


    public static int missingNumber(int[] nums) {

        int n = nums.length;
        // Bước 1: Khởi tạo HashMap với các số từ 0 đến n
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            map.put(i, true);
        }

        // Bước 2: Loại bỏ các số xuất hiện trong nums
        for (int num : nums) {
            map.remove(num);
        }

        // Bước 3: Tìm số còn lại trong HashMap
        for (int key : map.keySet()) {
            return key; // Chỉ còn lại một số duy nhất
        }

        // Nếu không tìm thấy (không thể xảy ra vì bài toán đảm bảo có 1 số thiếu)
        return -1;


    }

    public static int missingNumberV2(int[] nums) {
        int n = nums.length;
        // Bước 1: Khởi tạo HashSet với các số từ 0 đến n
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            set.add(i);
        }

        // Bước 2: Loại bỏ các số xuất hiện trong nums
        for (int num : nums) {
            set.remove(num);
        }

        // Bước 3: Tìm số còn lại trong HashSet
        for (int missing : set) {
            return missing; // HashSet chỉ còn lại một số duy nhất
        }

        // Nếu không tìm thấy (không thể xảy ra vì bài toán đảm bảo có 1 số thiếu)
        return -1;
    }

    public static int missingNumberV3(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int realSum = (n * (n + 1)) / 2;
        return realSum - sum;
    }



    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));

        int[] nums2 = {0, 1};
        System.out.println(missingNumber(nums2));


        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums3));

    }
}

