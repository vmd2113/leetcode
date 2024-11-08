package com.duongw.leetcode;

import java.util.logging.Logger;

public class _1295_FindNumbersWithEvenNumberOfDigits {

    private final static Logger LOGGER = Logger.getLogger(_1295_FindNumbersWithEvenNumberOfDigits.class.getName());


    /**
     * Problem:
     * Input: nums = [12,345,2,6,7896]
     * Output: 2
     * Explanation:
     * 12 contains 2 digits (even number of digits).
     * 345 contains 3 digits (odd number of digits).
     * 2 contains 1 digit (odd number of digits).
     * 6 contains 1 digit (odd number of digits).
     * 7896 contains 4 digits (even number of digits).
     * Therefor only 12 and 7896 contain an even number of digits.
     */

    public static boolean  checkOddOrEvenDigits(int number) {
        int count = 1;
        while (number / 10 > 0) {

            count++;
            number = number / 10;


        }
        if (count % 2 == 0) return true;
        else return false;

    }

    public static int findNumbers(int[] nums) {
        int countNumber = 0;
        for(int i =0; i<nums.length; i++){
            if (checkOddOrEvenDigits(nums[i])){
                countNumber ++;
            }
        }
        return countNumber;



    }

    public static void main(String[] args) {
        int nums[] ={12,345,2,6,7896};
        int nums2[] = {555,901,482,1771};

        int test_nums = findNumbers(nums);
        int test2_nums2  = findNumbers(nums2);

        System.out.println("Test 1: "+ test_nums);
        System.out.println("Test 2: " + test2_nums2);


    }


}
