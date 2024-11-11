package com.duongw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _2601_PrimeSubtractionOperation {
    /**
     * You are given a 0-indexed integer array nums of length n.
     * <p>
     * You can perform the following operation as many times as you want:
     * <p>
     * Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].
     * Return true if you can make nums a strictly increasing array using the above operation and false otherwise.
     * <p>
     * A strictly increasing array is an array whose each element is strictly greater than its preceding element.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [4,9,6,10]
     * Output: true
     * Explanation: In the first operation: Pick i = 0 and p = 3, and then subtract 3 from nums[0], so that nums becomes [1,9,6,10].
     * In the second operation: i = 1, p = 7, subtract 7 from nums[1], so nums becomes equal to [1,2,6,10].
     * After the second operation, nums is sorted in strictly increasing order, so the answer is true.
     * Example 2:
     * <p>
     * Input: nums = [6,8,11,12]
     * Output: true
     * Explanation: Initially nums is sorted in strictly increasing order, so we don't need to make any operations.
     * Example 3:
     * <p>
     * Input: nums = [5,8,3]
     * Output: false
     * Explanation: It can be proven that there is no way to perform operations to make nums sorted in strictly increasing order, so the answer is false.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 1000
     * 1 <= nums[i] <= 1000
     * nums.length == n
     */

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Hàm tạo danh sách các số nguyên tố nhỏ hơn n
    private static List<Integer> generatePrimesLessThan(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }


    public static boolean primeSubOperation(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            // Nếu `nums[i]` không lớn hơn `nums[i-1]`, thực hiện phép trừ
            if (nums[i] <= nums[i - 1]) {
                List<Integer> primes = generatePrimesLessThan(nums[i]);
                boolean found = false;

                // Tìm số nguyên tố lớn nhất có thể trừ từ `nums[i]` để đạt điều kiện `nums[i] > nums[i-1]`
                for (int j = primes.size() - 1; j >= 0; j--) {
                    int prime = primes.get(j);
                    if (nums[i] - prime > nums[i - 1]) {
                        nums[i] -= prime;
                        found = true;
                        break;
                    }
                }

                // Nếu không tìm được số nguyên tố phù hợp, trả về false
                if (!found) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[] nums = {4, 9, 6, 10};
        System.out.println(primeSubOperation(nums));



    }
}
